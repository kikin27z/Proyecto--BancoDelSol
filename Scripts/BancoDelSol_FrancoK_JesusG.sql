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


SET autocommit = 0;

