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