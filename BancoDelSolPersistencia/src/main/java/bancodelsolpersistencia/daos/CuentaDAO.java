package bancodelsolpersistencia.daos;

import bancodelsol.dtos.CuentaNuevaDTO;
import bancodelsoldominio.Cliente;
import bancodelsoldominio.Cuenta;
import bancodelsolpersistencia.conexion.IConexion;
import static bancodelsolpersistencia.daos.ClienteDAO.logger;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class CuentaDAO implements ICuentaDAO{
    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(ClienteDAO.class.getName());

    public CuentaDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    
    @Override
    public Cuenta agregar(CuentaNuevaDTO cuentaNueva) throws PersistenciaException {
            String sentenciaSQL = """
                                  INSERT INTO cuentas (fecha_apertura, numero_cuenta, saldo, id_cliente) 
                                  VALUES (?,?, ?, ?);
                              """;
        try (
            Connection conexion = this.conexionBD.obtenerConexion(); 
            PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);
        ) {
            
            comando.setString(1, LocalDate.now().toString());
            comando.setString(2, cuentaNueva.getNumeroCuenta());
            comando.setDouble(3, cuentaNueva.getSaldo());
            comando.setLong(4, cuentaNueva.getIdCliente());
            

            
            int numeroRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agregaron {0} cuentas", numeroRegistrosInsertados);
            ResultSet filaGenerada = comando.getGeneratedKeys();
            filaGenerada.next();
            Cuenta cuenta = new Cuenta(filaGenerada.getLong(1), filaGenerada.getDate("fecha_apertura").toString(), filaGenerada.getString("numero_cuenta"), filaGenerada.getDouble("saldo"), filaGenerada.getLong("id_cliente"));
            return cuenta;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "No se pudo guardar la cuenta.", e);
            throw new PersistenciaException("No se pudo guardar la cuenta.", e);
        }
        }

    @Override
    public Cuenta actualizar(Long idCuenta,double nuevoSaldo) throws PersistenciaException {
        String sentenciaSQL = """
                                  UPDATE cuentas SET saldo = ? 
                              WHERE (id_cuenta = ?);
                              """;
        String sentenciaSQLTraerCuenta = """
                                         SELECT * FROM cuentas
                                         WHERE id_cuenta = ?;
                                         """;
        try (
            Connection conexion = this.conexionBD.obtenerConexion(); 
            PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);
            PreparedStatement comandoSelect = conexion.prepareStatement(sentenciaSQLTraerCuenta);
        ) {
            comandoSelect.setLong(1, idCuenta);
    
                Cuenta cuenta = new Cuenta();
            try (ResultSet datosCuenta = comandoSelect.executeQuery()) {
                logger.log(Level.INFO, "Se encontró al cliente");
                cuenta.setSaldo(datosCuenta.getDouble("saldo"));
                cuenta.setFechaApertura(datosCuenta.getString("fecha_apertura"));
                cuenta.setNumeroCuenta(datosCuenta.getString("numero_cuenta"));
                cuenta.setIdCliente(datosCuenta.getLong("id_cliente"));
            }
            
            Double saldoActualizado = nuevoSaldo + cuenta.getSaldo();
            
            comando.setDouble(1, saldoActualizado);
            comando.setLong(2, idCuenta);
            
            int registrosActualizados = comando.executeUpdate();
            logger.log(Level.INFO, "Se actualizaron {0} cuentas", registrosActualizados);
            ResultSet idsGenerados = comando.getGeneratedKeys();
            idsGenerados.next();
            cuenta.setSaldo(idsGenerados.getDouble("saldo"));
            return cuenta;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "No se pudo actualizar el socio.", e);
            throw new PersistenciaException("No se pudo actualizar el socio.", e);
        }
    }

    @Override
    public Cuenta existe(Long idCuenta) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}