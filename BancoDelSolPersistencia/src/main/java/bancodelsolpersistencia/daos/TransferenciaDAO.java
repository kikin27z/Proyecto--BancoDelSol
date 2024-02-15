package bancodelsolpersistencia.daos;

import bancodelsol.dtos.TransferenciaNuevaDTO;
import bancodelsoldominio.Transaccion;
import bancodelsoldominio.Transferencia;
import bancodelsolpersistencia.conexion.IConexion;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class TransferenciaDAO implements ITransferenciaDAO{
    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(TransferenciaDAO.class.getName());
    
    public TransferenciaDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    @Override
    public Transferencia agregar(TransferenciaNuevaDTO transferenciaNueva,Long id_cuenta) throws PersistenciaException {
        String sentenciaSQLCrearTransaccion = """
                              INSERT INTO transacciones (fecha,monto,id_cuenta)
                              VALUES (NOW(),?,?);
                              """;
        String sentenciaSQLCrearTransferencia = """
                                                INSERT INTO transferencias (id_transaccion,motivo,cuenta_destino) 
                                                VALUES (?,?,?);
                                                """;
        try (
            Connection conexion = this.conexionBD.obtenerConexion(); 
            PreparedStatement comando = conexion.prepareStatement(sentenciaSQLCrearTransaccion, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement comando2 = conexion.prepareStatement(sentenciaSQLCrearTransferencia, Statement.RETURN_GENERATED_KEYS);
        ) {
            // Se insertan los datos de transaccion en su tabla
            comando.setDouble(1, transferenciaNueva.getMonto());
            comando.setLong(2, id_cuenta);
            // Se muestra en pantalla cuantos cambios se hicieron
            int numeroRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agregaron {0} transacciones", numeroRegistrosInsertados);

            ResultSet datosFila = comando.getGeneratedKeys();
            datosFila.next();
            
            System.out.println(datosFila.getDouble("monto"));

            Transaccion transaccion = new Transaccion(datosFila.getLong(1), datosFila.getString("fecha"), datosFila.getDouble("monto"), id_cuenta);

            comando2.setLong(1, transaccion.getIdTransaccion());
            comando2.setString(2, transferenciaNueva.getMotivo());
            comando2.setString(3, transferenciaNueva.getCuentaDestino());
//
            int numTransferenciaInsertadas = comando2.executeUpdate();
            logger.log(Level.INFO, "Se agregaron {0} transferencias", numTransferenciaInsertadas);

//            Transferencia transferencia = new Transferencia(transferenciaNueva.getMotivo(), transferenciaNueva.getCuentaDestino(), idTransaccion, transaccion.getFecha(), transferenciaNueva.getMonto(), id_cuenta);
            return null;

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "No se pudo guardar la transferencia.", e);
            throw new PersistenciaException("No se pudo guardar la transferencia.", e);
        }
    }

    

    @Override
    public Transferencia eliminar(Integer id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Transferencia> consultar() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Transferencia> ultimas3() throws PersistenciaException {
        
        return null;
    }

    
    
    
    
}
