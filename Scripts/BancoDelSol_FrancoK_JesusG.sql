CREATE DATABASE IF NOT EXISTS `banco_del_sol`;
USE `banco_del_sol`;

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
    `id_cliente` BIGINT NOT NULL AUTO_INCREMENT,
    `nombres` VARCHAR(50) NOT NULL,
    `apellido_paterno` VARCHAR(30) NOT NULL,
    `apellido_materno` VARCHAR(30) NOT NULL,
    `fecha_nacimiento` DATE NOT NULL,
    `usuario` VARCHAR(30) NOT NULL UNIQUE,
    `contrasena` VARCHAR(100) NOT NULL ,
    PRIMARY KEY (`id_cliente`)
);

DROP TABLE IF EXISTS `domicilios`;
CREATE TABLE `domicilios` (
    `id_domicilio` BIGINT NOT NULL AUTO_INCREMENT,
    `calle` VARCHAR(50) NOT NULL,
    `colonia` VARCHAR(50) NOT NULL,
    `codigo_postal` VARCHAR(5) NOT NULL,
    `numero_exterior` VARCHAR(10) NOT NULL,
    `ciudad` VARCHAR(20) NOT NULL,
    `id_cliente` BIGINT NOT NULL,
    PRIMARY KEY (`id_domicilio`),
    FOREIGN KEY (`id_cliente`) REFERENCES `clientes`(`id_cliente`)
);



DROP TABLE IF EXISTS `cuentas`;
CREATE TABLE `cuentas` (
    `id_cuenta` BIGINT NOT NULL AUTO_INCREMENT,
    `fecha_apertura` DATE  NULL,
    `nombre_cuenta` VARCHAR(15) NOT NULL,
    `numero_cuenta` VARCHAR(9) NOT NULL UNIQUE,
    `estado` VARCHAR(10) DEFAULT 'Activa' CHECK (estado IN ('Activa', 'Inactiva')),
    `saldo` DOUBLE NOT NULL DEFAULT 0,
    `id_cliente` BIGINT NOT NULL,
    PRIMARY KEY (`id_cuenta`),
    FOREIGN KEY (`id_cliente`) REFERENCES `clientes`(`id_cliente`)
);

DROP TABLE IF EXISTS `transacciones`;
CREATE TABLE `transacciones` (
    `id_transaccion` BIGINT NOT NULL AUTO_INCREMENT,
    `fecha` DATETIME NULL DEFAULT NOW(),
    `tipo` VARCHAR(14)  CHECK (tipo IN ('Transferencia', 'Retiro')),
    `monto` DOUBLE NOT NULL,
    `id_cuenta` BIGINT NOT NULL,
    PRIMARY KEY (`id_transaccion`),
    FOREIGN KEY (`id_cuenta`) REFERENCES `cuentas`(`id_cuenta`)
);

DROP TABLE IF EXISTS `retiros`;
CREATE TABLE `retiros` (
    `id_retiro` BIGINT NOT NULL AUTO_INCREMENT,
    `contrasena` VARCHAR(8) NOT NULL,
    `folio` VARCHAR(16) NOT NULL,
    `estado` VARCHAR(50) DEFAULT 'en espera' CHECK (estado IN ('caducado', 'en espera', 'realizado')),
    `id_transaccion` BIGINT NOT NULL,
    PRIMARY KEY (`id_retiro`),
    FOREIGN KEY (`id_transaccion`) REFERENCES `transacciones`(`id_transaccion`)
);

DROP TABLE IF EXISTS `transferencias`;
CREATE TABLE `transferencias` (
    `id_transferencia` BIGINT NOT NULL AUTO_INCREMENT,
    `id_transaccion` BIGINT NOT NULL,
    `motivo` VARCHAR(50) NULL DEFAULT "Sin motivo",
    `cuenta_destino` VARCHAR(9) NOT NULL,
    PRIMARY KEY (`id_transferencia`),
    FOREIGN KEY (`id_transaccion`) REFERENCES `transacciones`(`id_transaccion`),
    FOREIGN KEY (`cuenta_destino`) REFERENCES `cuentas`(`numero_cuenta`)
);

DELIMITER $$

CREATE TRIGGER actualizar_saldo_despues_de_retiro_sin_cuenta
AFTER INSERT ON retiros
FOR EACH ROW
BEGIN
    DECLARE monto_retirado DOUBLE;
	DECLARE cuenta_id BIGINT;
    
    -- Obtener el monto retirado a través de la tabla de transacciones
    SELECT monto INTO monto_retirado
    FROM transacciones
    WHERE id_transaccion = NEW.id_transaccion;
    
    SELECT id_cuenta INTO cuenta_id
    FROM transacciones
    WHERE id_transaccion = NEW.id_transaccion;
    -- Actualizar el saldo de la cuenta
    UPDATE cuentas
    SET saldo = saldo - monto_retirado
    WHERE id_cuenta = cuenta_id;
END;
$$

DELIMITER ;

DELIMITER //

CREATE PROCEDURE generar_retiro_sin_cuenta(
    IN folio_retiro VARCHAR(16),
    IN contrasena_retiro VARCHAR(8),
    IN cuenta_id BIGINT -- Nuevo parámetro para el ID de cuenta
)
BEGIN
    DECLARE id_transaccion_retiro BIGINT;

    -- Iniciar la transacción
    START TRANSACTION;

    -- Insertar el registro en la tabla de transacciones con el id_cuenta especificado
    INSERT INTO transacciones (tipo, monto, id_cuenta) -- Asegúrate de incluir id_cuenta
    VALUES ('Retiro', 0, cuenta_id);

    -- Obtener el ID de la última transacción insertada
    SET id_transaccion_retiro = LAST_INSERT_ID();

    -- Insertar el registro en la tabla de retiros
    INSERT INTO retiros (contrasena, folio, id_transaccion)
    VALUES (contrasena_retiro, folio_retiro, id_transaccion_retiro);

    -- Confirmar la transacción
    COMMIT;
END//

DELIMITER ;

-- SET autocommit = 1;

DELIMITER //

CREATE PROCEDURE transferir(
    IN cuenta_origen_id BIGINT,
    IN cuenta_destino_numero VARCHAR(9),
    IN motivo_transferencia VARCHAR(50),
    IN monto_transferencia DOUBLE
)
BEGIN
    DECLARE saldo_origen DOUBLE;
    DECLARE fecha_actual DATETIME;
    DECLARE last_insert_id BIGINT; -- Mover la declaración de la variable fuera del bloque BEGIN ... END

    -- Iniciar la transacción
    START TRANSACTION;

    -- Obtenemos el saldo de la cuenta origen
    SELECT saldo INTO saldo_origen FROM cuentas WHERE id_cuenta = cuenta_origen_id FOR UPDATE;


        -- Restamos el monto transferido al saldo de la cuenta origen
        UPDATE cuentas SET saldo = saldo - monto_transferencia WHERE id_cuenta = cuenta_origen_id;

        -- Sumamos el monto transferido al saldo de la cuenta destino
        UPDATE cuentas SET saldo = saldo + monto_transferencia WHERE numero_cuenta = cuenta_destino_numero;

        -- Obtenemos la fecha actual
        SET fecha_actual = NOW();

        -- Insertamos la transacción
        INSERT INTO transacciones (fecha, tipo, monto, id_cuenta)
        VALUES (fecha_actual, 'Transferencia', monto_transferencia, cuenta_origen_id);

        -- Obtenemos el ID de la última transacción insertada
        SET last_insert_id = LAST_INSERT_ID(); -- Corregir la asignación de la variable

        -- Insertamos la información de la transferencia
        INSERT INTO transferencias (id_transaccion, motivo, cuenta_destino)
        VALUES (last_insert_id, motivo_transferencia, cuenta_destino_numero);

        -- Confirmar la transacción
        COMMIT;

        -- Devolvemos la información de la transacción mediante un JOIN
        SELECT 
			transacciones.*,
            transferencias.motivo,
            transferencias.cuenta_destino,
            transferencias.id_transferencia
        FROM transacciones
        LEFT JOIN transferencias ON transacciones.id_transaccion = transferencias.id_transaccion
        WHERE transacciones.id_transaccion = last_insert_id;

END//

DELIMITER ;


DELIMITER //

CREATE PROCEDURE filtroPeriodo (IN fecha_desde DATE, IN fecha_hasta DATE, IN idCliente BIGINT)
BEGIN
	SET @mi_fecha_desde := STR_TO_DATE(CONCAT(fecha_desde, ' 00:00:00'), '%Y-%m-%d %H:%i:%s');
	SET @mi_fecha_hasta := STR_TO_DATE(CONCAT(fecha_hasta, ' 23:59:59'), '%Y-%m-%d %H:%i:%s');

    
    SELECT 
	t.id_transaccion,
    t.tipo,
    t.fecha,
    t.monto,
    tr.motivo,
    tr.cuenta_destino,
    r.estado,
    r.folio,
    c.id_cliente
FROM transacciones AS t 
LEFT JOIN transferencias AS tr ON t.id_transaccion = tr.id_transaccion 
LEFT JOIN retiros AS r ON t.id_transaccion  = r.id_transaccion
INNER JOIN cuentas AS c ON t.id_cuenta = c.id_cuenta  
WHERE 
	 c.id_cliente = idCliente AND
	t.fecha BETWEEN @mi_fecha_desde AND @mi_fecha_hasta
    ORDER BY t.fecha DESC;
END //

DELIMITER ;


DELIMITER //

CREATE PROCEDURE actualizar_estado_retiro_sin_cuenta(
    IN folio_retiro VARCHAR(16),
    IN contrasena_retiro VARCHAR(8)
)
BEGIN
    DECLARE id_transaccion_retiro BIGINT;
    DECLARE cuenta_origen_id BIGINT;
    DECLARE monto_retirado DOUBLE;

    -- Buscar el ID de la transacción de retiro usando el folio y la contraseña
    SELECT id_transaccion INTO id_transaccion_retiro
    FROM retiros
    WHERE folio = folio_retiro AND contrasena = contrasena_retiro AND estado = 'en espera';

    -- Si no se encontró ninguna transacción con el folio y la contraseña proporcionados, emitir un mensaje de error
    IF id_transaccion_retiro IS NULL THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No se encontró un retiro pendiente con los datos proporcionados';
    ELSE
        -- Obtener el monto retirado a través de la tabla de transacciones
        SELECT monto INTO monto_retirado
        FROM transacciones
        WHERE id_transaccion = id_transaccion_retiro;

        -- Obtener el ID de la cuenta de origen del retiro
        SELECT id_cuenta INTO cuenta_origen_id
        FROM transacciones
        WHERE id_transaccion = id_transaccion_retiro;

        -- Actualizar el estado del retiro a 'realizado'
        UPDATE retiros
        SET estado = 'realizado'
        WHERE id_transaccion = id_transaccion_retiro;

        -- Restar el monto retirado del saldo de la cuenta de origen
        UPDATE cuentas
        SET saldo = saldo - monto_retirado
        WHERE id_cuenta = cuenta_origen_id;
        
        SELECT CONCAT('Retiro realizado por un monto de $', monto_retirado, ' de la cuenta con ID ', cuenta_origen_id) AS 'Mensaje';
    END IF;
END//

DELIMITER ;
