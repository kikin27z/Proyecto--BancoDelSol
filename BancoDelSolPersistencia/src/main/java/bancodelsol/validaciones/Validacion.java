package bancodelsol.validaciones;

import bancodelsoldominio.Cliente;
import bancodelsoldominio.Cuenta;
import bancodelsolpersistencia.conexion.IConexion;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import bancodelsolpersistencia.excepciones.ValidacionDTOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 * Esta clase proporciona métodos para validar la existencia y autenticación de
 * clientes delbanco. Implementa la interfaz IValidacion.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class Validacion implements IValidacion {

    static final Logger logger = Logger.getLogger(Validacion.class.getName());
    final IConexion conexionBD;

    public Validacion(IConexion conexionBD) {
        this.conexionBD = conexionBD;
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
            throw new ValidacionDTOException("Error al consultar el usuario en la base de datos.");
        }
    }

    @Override
    public Cliente existeCliente(Long idCliente) throws PersistenciaException {
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
    public Cliente clienteValido(String usuario, String contrasena) throws ValidacionDTOException {
        StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
        String sentenciaSQL = """
                  SELECT * FROM clientes 
                  WHERE usuario = ?
                  """;
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);) {
            comando.setString(1, usuario);
            try (ResultSet resultado = comando.executeQuery()) {
                if (resultado.next()) {
                    String contrasenaEncriptadaAlmacenada = resultado.getString("contrasena");
                    // Verifica si la contraseña ingresada coincide con la contraseña encriptada almacenada
                    if (encryptor.checkPassword(contrasena, contrasenaEncriptadaAlmacenada)) {
                        // Si la contraseña es válida, crea un objeto Cliente con los datos obtenidos
                        Long idCliente = resultado.getLong("id_cliente");
                        String nombre = resultado.getString("nombres");
                        String apellidoPaterno = resultado.getString("apellido_paterno");
                        String apellidoMaterno = resultado.getString("apellido_materno");
                        String fechaNacimiento = resultado.getString("fecha_nacimiento");
                        // Crear y devolver un objeto Cliente
                        return new Cliente(idCliente, nombre, apellidoPaterno, apellidoMaterno, usuario, contrasena, fechaNacimiento);
                    }
                }
            }
            // Si no se encontró ningún cliente con el usuario dado o la contraseña no coincide, devuelve null
            return null;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al validar el cliente.", e);
            throw new ValidacionDTOException("Error al validar el cliente.", e);
        }
    }

    @Override
    public Cuenta existeCuenta(String numeroCuenta) throws ValidacionDTOException {
        String sentenciaSQL = """
                             SELECT * FROM cuentas 
                              WHERE numero_cuenta = ?;
                              """;
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {

            comando.setString(1, numeroCuenta);

            try (ResultSet datosCuenta = comando.executeQuery()) {
                if (!datosCuenta.next()) {
                    logger.log(Level.INFO, "No se halló la cuenta con número de cuenta: {0}",numeroCuenta);
                    throw new ValidacionDTOException("No se pudo encontrar la cuenta.");
                }

                logger.log(Level.INFO, "Se encontró al cliente");
                Cuenta cuenta = new Cuenta(
                    datosCuenta.getLong("id_cuenta"),
                    datosCuenta.getDate("fecha_apertura").toString(),
                    datosCuenta.getString("nombre_cuenta"),
                    datosCuenta.getString("numero_cuenta"),
                    datosCuenta.getDouble("saldo"),
                        datosCuenta.getLong("id_cliente"),
                        datosCuenta.getString("estado")
                );
                return cuenta;
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "No se pudo encontrar la cuenta.", e);
            throw new ValidacionDTOException("No se pudo encontrar la cuenta.");
        }
    }

}
