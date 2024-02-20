
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
