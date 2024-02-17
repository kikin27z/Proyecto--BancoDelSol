package bancodelsolpersistencia.daos;

import bancodelsol.dtos.ClienteNuevoDTO;
import bancodelsoldominio.Cliente;
import bancodelsolpersistencia.conexion.IConexion;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import bancodelsolpersistencia.excepciones.ValidacionDTOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class ClienteDAO implements IClienteDAO {

    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(ClienteDAO.class.getName());

    public ClienteDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Cliente agregar(ClienteNuevoDTO clienteNuevo) throws PersistenciaException {
            //        String sentenciaSQL = """
//                         SELECT COUNT(*) AS total FROM clientes WHERE usuario = ?;
//                         """;
//        try (
//                Connection conexion = this.conexionBD.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);) {
//            comando.setString(1, clienteNuevo.getUsuario());
//            ResultSet resultado = comando.executeQuery();
//            resultado.next();
//            int totalClienntes = resultado.getInt("total");
//            if (totalClienntes > 0) {
//                throw new PersistenciaException("El usuario ya existe en la base de datos.");
//            }
//        } catch (SQLException e) {
//            logger.log(Level.SEVERE, "No se pudo verificar la existencia del usuario.", e);
//            throw new PersistenciaException("No se pudo verificar la existencia del usuario.", e);
//        }

        try {
            if (existeUsuario(clienteNuevo.getUsuario())) {
                throw new PersistenciaException("El usuario ya existe en la base de datos.");
            }
        } catch (ValidacionDTOException e) {
            logger.log(Level.SEVERE, "El usuario ya existe en la base de datos.", e);
        }
        
        
        StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
        String contrasenaEnctriptada = encryptor.encryptPassword(clienteNuevo.getContrasena());
        
        String sentenciaSQL = """
                             INSERT INTO clientes (nombres, apellido_paterno, apellido_materno, fecha_nacimiento, usuario, contrasena) 
                              VALUES (?, ?, ?, ?, ?, ?);
                              """;
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, clienteNuevo.getNombres());
            comando.setString(2, clienteNuevo.getApellidoPaterno());
            comando.setString(3, clienteNuevo.getApellidoMaterno());
            comando.setString(4, clienteNuevo.getFecha());
            comando.setString(5, clienteNuevo.getUsuario());
            comando.setString(6, contrasenaEnctriptada);

            int numeroRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agregaron {0} clientes", numeroRegistrosInsertados);
            ResultSet idsGenerados = comando.getGeneratedKeys();
            idsGenerados.next();
            Cliente cliente = new Cliente(idsGenerados.getLong(1), clienteNuevo.getNombres(), clienteNuevo.getApellidoPaterno(), clienteNuevo.getApellidoMaterno(), clienteNuevo.getUsuario(), clienteNuevo.getContrasena(), clienteNuevo.getFecha());
            return cliente;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "No se pudo guardar el cliente.", e);
            throw new PersistenciaException("No se pudo guardar el cliente.", e);
        }
    }

    @Override
    public List<Cliente> consultar() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Cliente existe(Long idCliente) throws PersistenciaException {
        String sentenciaSQL = """
                             SELECT * FROM clientes 
                               WHERE id_cliente = ?;
                              """;
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {

            comando.setLong(1, idCliente);

            try (ResultSet datosCliente = comando.executeQuery()) {
                if (!datosCliente.next()) {
                    logger.log(Level.INFO, "No se halló al cliente con id {0}", idCliente);
                    return null;
                }

                logger.log(Level.INFO, "Se encontró al cliente");
                Cliente cliente = new Cliente(
                        idCliente,
                        datosCliente.getString("nombres"),
                        datosCliente.getString("apellido_paterno"),
                        datosCliente.getString("apellido_materno"),
                        datosCliente.getString("usuario"),
                        datosCliente.getString("contrasena"),
                        datosCliente.getString("fecha_nacimiento")
                );
                return cliente;
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "No se pudo encontrar el cliente.", e);
            throw new PersistenciaException("No se pudo encontrar el cliente.", e);
        }

    }

    @Override
    public boolean existeUsuario(String usuario) throws ValidacionDTOException {
        String sentenciaSQL = """
                             SELECT * FROM clientes 
                               WHERE usuario = ?;
                              """;
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);) {
            comando.setString(1, usuario);

            try (ResultSet datosCliente = comando.executeQuery()) {
                if (!datosCliente.next()) {
                    logger.log(Level.INFO, "No se halló al cliente con usuario {0}", usuario);
                    return false;
                }
                logger.log(Level.INFO, "Se encontró al cliente");
                return true;
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "No se pudo encontrar el cliente.", e);
            throw new ValidacionDTOException("No se pudo consultar intente de nuevo.");
        }
    }

    @Override
    public boolean clienteValido(String usuario, String contrasena) throws ValidacionDTOException {
        StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
        String sentenciaSQL = """
                             SELECT * FROM clientes 
                               WHERE usuario = ? and contrasna = ?;
                              """;
        return false;

    
    
    }
}
