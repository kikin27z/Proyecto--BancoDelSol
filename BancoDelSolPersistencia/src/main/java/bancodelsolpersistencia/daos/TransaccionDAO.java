
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
 *
 * @author karim
 */
public class TransaccionDAO implements ITransaccionDAO{

    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(CuentaDAO.class.getName());

    /**
    * Constructor de la clase CuentaDAO.
    *
    * @param conexionBD La conexión a la base de datos que se utilizará para realizar operaciones de persistencia.
    */
    public TransaccionDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }
    
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

    @Override
    public void crearTabla(DefaultTableModel  modelo) throws PersistenciaException {
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
        
        
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); 
                PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);
                ResultSet resultados = comando.executeQuery();
                ) {
            
            
                while (resultados.next()) {
                    String numeroFormateado = String.format("%.2f", resultados.getDouble("t.monto"));
                    String moneda = "$"+numeroFormateado+" MXN";
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
        
            logger.log(Level.INFO,"Se consultaron {0} transacciones", modelo.getRowCount());
//            return modelo;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudieron consultar las cuentas", ex);
            throw new PersistenciaException("No se pudieron consultar las cuentas",ex);
        }
    }
    
}
