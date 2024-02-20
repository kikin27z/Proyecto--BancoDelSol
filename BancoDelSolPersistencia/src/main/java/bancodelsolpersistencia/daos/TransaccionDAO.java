package bancodelsolpersistencia.daos;

import bancodelsoldominio.Retiro;
import bancodelsoldominio.Transaccion;
import bancodelsoldominio.Transferencia;
import bancodelsolpersistencia.conexion.IConexion;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase proporciona métodos para realizar operaciones de acceso a datos 
 * relacionadas con las transacciones en la base de datos.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class TransaccionDAO implements ITransaccionDAO{

    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(CuentaDAO.class.getName());

    /**
    * Constructor de la clase TransaccionDAO.
    *
    * @param conexionBD La conexión a la base de datos que se utilizará para realizar operaciones de persistencia.
    */
    public TransaccionDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    /**
     * Consulta todas las transacciones (transferencias y retiros) almacenadas en la base de datos.
     * 
     * @return Una lista de objetos Transaccion que representan las transacciones consultadas.
     * @throws PersistenciaException Si hay un error al acceder a la base de datos.
     */
    @Override
    public List<Transaccion> consultar() throws PersistenciaException {
        String sentenciaSQL = """
                              SELECT 
                              	t.id_transaccion,
                                  t.tipo,
                                  t.fecha,
                                  t.monto,
                                  tr.motivo,
                                  tr.cuenta_destino,
                                  r.estado,
                                  r.folio
                              FROM transacciones AS t LEFT JOIN transferencias AS tr ON t.id_transaccion = tr.id_transaccion 
                              LEFT JOIN retiros AS r ON t.id_transaccion  = r.id_transaccion 
                              ORDER BY t.fecha DESC;
                              """;
        
        List<Transaccion> listaTransacciones = new LinkedList<>();
        Transferencia transferenciaAux;
        Retiro retiroAux;
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); 
                PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);
                ) {
            
            
            try (ResultSet resultados = comando.executeQuery()) {
                while (resultados.next()) {
                    if(resultados.getString("estado") == null){
                        transferenciaAux = new Transferencia();
                        transferenciaAux.setIdTransaccion(resultados.getLong("t.id_transaccion"));
                        transferenciaAux.setTipo(resultados.getString("t.tipo"));
                        transferenciaAux.setFecha(resultados.getString("t.fecha"));
                        transferenciaAux.setMonto(resultados.getDouble("t.monto"));
                        transferenciaAux.setMotivo(resultados.getString("tr.motivo"));
                        transferenciaAux.setCuentaDestino(resultados.getString("tr.cuenta_destino"));
                        
                        listaTransacciones.add(transferenciaAux);
                    }else{
                        retiroAux = new Retiro();
                        retiroAux.setIdTransaccion(resultados.getLong("id_transaccion"));
                        retiroAux.setTipo(resultados.getString("t.tipo"));
                        retiroAux.setFecha(resultados.getString("t.fecha"));
                        retiroAux.setMonto(resultados.getDouble("t.monto"));
                        retiroAux.setEstado(resultados.getString("r.estado"));
                        retiroAux.setFolio(resultados.getString("r.folio"));
                        
                        listaTransacciones.add(retiroAux);
                    }
                }
             }
            logger.log(Level.INFO,"Se consultaron {0} transacciones", listaTransacciones.size());
            return listaTransacciones;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudieron consultar las cuentas", ex);
            throw new PersistenciaException("No se pudieron consultar las cuentas",ex);
        }
    }

    /**
     * Crea un modelo de tabla con la información de todas las transacciones (transferencias y retiros) almacenadas en la base de datos.
     * 
     * @param modelo El modelo de tabla donde se agregarán los datos de las transacciones.
     * @param idCliente El ID del cliente del que se quieren obtener las transacciones.
     * @param opcion La opción que indica si se quieren consultar todas las transacciones o solo las del último mes.
     * @throws PersistenciaException Si hay un error al acceder a la base de datos.
     */
    @Override
    public void crearTabla(DefaultTableModel  modelo, Long idCliente,int opcion) throws PersistenciaException {
        String sentenciaSQL = """
                              SELECT 
                              	t.id_transaccion,
                                  t.tipo,
                                  t.fecha,
                                  t.monto,
                                  t.id_cuenta,
                                  tr.motivo,
                                  tr.cuenta_destino,
                                  r.estado,
                                  r.folio,
                                  c.id_cliente
                              FROM transacciones AS t LEFT JOIN transferencias AS tr ON t.id_transaccion = tr.id_transaccion 
                              LEFT JOIN retiros AS r ON t.id_transaccion  = r.id_transaccion 
                              INNER JOIN cuentas AS c ON t.id_cuenta = c.id_cuenta 
                              WHERE c.id_cliente = ?
                              ORDER BY t.fecha DESC;
                              """;
        
        
        
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); 
                PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);
                ) {
            
                comando.setLong(1, idCliente);
    
            try (ResultSet resultados = comando.executeQuery()) {
                if (resultados.next()) {
                    logger.log(Level.INFO, "Se encontraron ");
                    String numeroFormateado = String.format("%.2f", resultados.getDouble("t.monto"));
                    String moneda = "$"+numeroFormateado+" MXN";
                    
                    if(opcion == 0){
                        Object[] fila = {
                                resultados.getString("t.tipo"),
                                resultados.getString("t.fecha"),
                                moneda,
                                resultados.getString("tr.motivo"),
                                resultados.getString("tr.cuenta_destino"),
                                resultados.getString("r.estado"),
                                resultados.getString("r.folio")
                            };
                        modelo.addRow(fila);
                    }else if(opcion == 1){
                        if(resultados.getString("t.tipo").equals("Transferencia")){
                            Object[] fila = {
                                resultados.getString("t.tipo"),
                                resultados.getString("t.fecha"),
                                moneda,
                                resultados.getString("tr.motivo"),
                                resultados.getString("tr.cuenta_destino"),
                                resultados.getString("r.estado"),
                                resultados.getString("r.folio")
                            };
                            modelo.addRow(fila);
                        }
                    }else{
                        if(resultados.getString("t.tipo").equals("Retiro")){
                            Object[] fila = {
                                resultados.getString("t.tipo"),
                                resultados.getString("t.fecha"),
                                moneda,
                                resultados.getString("tr.motivo"),
                                resultados.getString("tr.cuenta_destino"),
                                resultados.getString("r.estado"),
                                resultados.getString("r.folio")
                            };
                            modelo.addRow(fila);
                        }
                    } 
                    
                        
                    while (resultados.next()) {
                         numeroFormateado = String.format("%.2f", resultados.getDouble("t.monto"));
                         moneda = "$"+numeroFormateado+" MXN";
                         if(opcion == 0){
                            Object[] fila = {
                                    resultados.getString("t.tipo"),
                                    resultados.getString("t.fecha"),
                                    moneda,
                                    resultados.getString("tr.motivo"),
                                    resultados.getString("tr.cuenta_destino"),
                                    resultados.getString("r.estado"),
                                    resultados.getString("r.folio")
                                };
                            modelo.addRow(fila);
                        }else if(opcion == 1){
                            if(resultados.getString("t.tipo").equals("Transferencia")){
                                Object[] fila = {
                                    resultados.getString("t.tipo"),
                                    resultados.getString("t.fecha"),
                                    moneda,
                                    resultados.getString("tr.motivo"),
                                    resultados.getString("tr.cuenta_destino"),
                                    resultados.getString("r.estado"),
                                    resultados.getString("r.folio")
                                };
                                modelo.addRow(fila);
                            }
                        }else{
                            if(resultados.getString("t.tipo").equals("Retiro")){
                                Object[] fila = {
                                    resultados.getString("t.tipo"),
                                    resultados.getString("t.fecha"),
                                    moneda,
                                    resultados.getString("tr.motivo"),
                                    resultados.getString("tr.cuenta_destino"),
                                    resultados.getString("r.estado"),
                                    resultados.getString("r.folio")
                                };
                                modelo.addRow(fila);
                            }
                        } 
                    }
                }else{
                    logger.log(Level.INFO, "No se hallo transferencias al cliente {0}", idCliente);
                    
                }

                
            }
            
            
                
        
            logger.log(Level.INFO,"Se consultaron {0} transacciones", modelo.getRowCount());
//            return modelo;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudieron consultar las operaciones", ex);
            throw new PersistenciaException("No se pudieron consultar las operaciones",ex);
        }
    }

    /**
     * Realiza una transferencia entre cuentas.
     * 
     * @param idCuenta El ID de la cuenta desde la que se realizará la transferencia.
     * @param numeroCuentaDestino El número de cuenta destino.
     * @param motivo El motivo de la transferencia.
     * @param monto El monto de la transferencia.
     * @return Una instancia de Transferencia representando la transferencia realizada, o null si no se pudo realizar.
     * @throws PersistenciaException Si hay un error al acceder a la base de datos.
     */
    @Override
    public Transferencia realizarTransferencia(Long idCuenta, String numeroCuentaDestino, String motivo, Double monto) throws PersistenciaException {
        String sentenciaSQL = """
                                CALL transferir(?,?,?,?);
                              """;
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); 
                PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);
            ) {
            comando.setLong(1, idCuenta);
            comando.setString(2, numeroCuentaDestino);
            comando.setString(3, motivo);
            comando.setDouble(4, monto);
            
    
            try (ResultSet datosCuenta = comando.executeQuery()) {
                if (!datosCuenta.next()) {
                    logger.log(Level.INFO, "No se pudo hacer la transferencia");
                    return null;
                }

                logger.log(Level.INFO, "Se realizo la transferencia");
                Transferencia transferencia = new Transferencia(
                        datosCuenta.getString("motivo"),
                        datosCuenta.getString("cuenta_destino"),
                        datosCuenta.getDate("fecha").toString(),
                        datosCuenta.getDouble("monto"),
                        datosCuenta.getString("tipo"),
                        datosCuenta.getLong("id_transaccion"),
                        datosCuenta.getLong("id_transferencia"),
                        datosCuenta.getLong("id_cuenta")
                        
                );
                
                return transferencia;
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se realizar la transferencia", e);
            throw new PersistenciaException("No se pudo realizar la transferencia", e);
        }
        
    }

    /**
     * Crea un modelo de tabla con la información de todas las transacciones (transferencias y retiros) almacenadas en la base de datos en un período específico.
     * 
     * @param modelo El modelo de tabla donde se agregarán los datos de las transacciones.
     * @param fechaDesde La fecha de inicio del período.
     * @param fechaHasta La fecha de fin del período.
     * @param idCliente El ID del cliente del que se quieren obtener las transacciones.
     * @param opcion La opción que indica si se quieren consultar todas las transacciones o solo las del período especificado.
     * @throws PersistenciaException Si hay un error al acceder a la base de datos.
     */
    @Override
    public void creaTablaConPeriodo(DefaultTableModel modelo, String fechaDesde, String fechaHasta, Long idCliente,int opcion) throws PersistenciaException {
         String sentenciaSQL = """
                              CALL filtroPeriodo(?,?,?);
                              """;
        
        
        
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); 
                PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);
                ) {
            
                comando.setString(1, fechaDesde);
                comando.setString(2, fechaHasta);
                comando.setLong(3, idCliente);
    
            try (ResultSet resultados = comando.executeQuery()) {
                if (resultados.next()) {
                    logger.log(Level.INFO, "Se encontraron ");
                    String numeroFormateado = String.format("%.2f", resultados.getDouble("t.monto"));
                    String moneda = "$"+numeroFormateado+" MXN";
                    
                    if(opcion == 0){
                        Object[] fila = {
                                resultados.getString("t.tipo"),
                                resultados.getString("t.fecha"),
                                moneda,
                                resultados.getString("tr.motivo"),
                                resultados.getString("tr.cuenta_destino"),
                                resultados.getString("r.estado"),
                                resultados.getString("r.folio")
                            };
                        modelo.addRow(fila);
                    }else if(opcion == 1){
                        if(resultados.getString("t.tipo").equals("Transferencia")){
                            Object[] fila = {
                                resultados.getString("t.tipo"),
                                resultados.getString("t.fecha"),
                                moneda,
                                resultados.getString("tr.motivo"),
                                resultados.getString("tr.cuenta_destino"),
                                resultados.getString("r.estado"),
                                resultados.getString("r.folio")
                            };
                            modelo.addRow(fila);
                        }
                    }else{
                        if(resultados.getString("t.tipo").equals("Retiro")){
                            Object[] fila = {
                                resultados.getString("t.tipo"),
                                resultados.getString("t.fecha"),
                                moneda,
                                resultados.getString("tr.motivo"),
                                resultados.getString("tr.cuenta_destino"),
                                resultados.getString("r.estado"),
                                resultados.getString("r.folio")
                            };
                            modelo.addRow(fila);
                        }
                    } 
                    
                        
                    while (resultados.next()) {
                         numeroFormateado = String.format("%.2f", resultados.getDouble("t.monto"));
                         moneda = "$"+numeroFormateado+" MXN";
                         if(opcion == 0){
                            Object[] fila = {
                                    resultados.getString("t.tipo"),
                                    resultados.getString("t.fecha"),
                                    moneda,
                                    resultados.getString("tr.motivo"),
                                    resultados.getString("tr.cuenta_destino"),
                                    resultados.getString("r.estado"),
                                    resultados.getString("r.folio")
                                };
                            modelo.addRow(fila);
                        }else if(opcion == 1){
                            if(resultados.getString("t.tipo").equals("Transferencia")){
                                Object[] fila = {
                                    resultados.getString("t.tipo"),
                                    resultados.getString("t.fecha"),
                                    moneda,
                                    resultados.getString("tr.motivo"),
                                    resultados.getString("tr.cuenta_destino"),
                                    resultados.getString("r.estado"),
                                    resultados.getString("r.folio")
                                };
                                modelo.addRow(fila);
                            }
                        }else{
                            if(resultados.getString("t.tipo").equals("Retiro")){
                                Object[] fila = {
                                    resultados.getString("t.tipo"),
                                    resultados.getString("t.fecha"),
                                    moneda,
                                    resultados.getString("tr.motivo"),
                                    resultados.getString("tr.cuenta_destino"),
                                    resultados.getString("r.estado"),
                                    resultados.getString("r.folio")
                                };
                                modelo.addRow(fila);
                            }
                        } 
                    }
                }else{
                    logger.log(Level.INFO, "No se hallo transferencias al cliente {0}", idCliente);
                    
                }

                
            }
            
            
                
        
            logger.log(Level.INFO,"Se consultaron {0} transacciones", modelo.getRowCount());
//            return modelo;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudieron consultar las operaciones", ex);
            throw new PersistenciaException("No se pudieron consultar las operaciones",ex);
        }
    }

    
    
}
