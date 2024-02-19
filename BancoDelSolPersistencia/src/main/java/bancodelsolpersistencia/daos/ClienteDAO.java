package bancodelsolpersistencia.daos;

import bancodelsol.dtos.ClienteNuevoDTO;
import bancodelsol.validaciones.Validacion;
import bancodelsoldominio.Cliente;
import bancodelsolpersistencia.conexion.IConexion;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import bancodelsolpersistencia.excepciones.ValidacionDTOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 * La clase ClienteDAO implementa la interfaz IClienteDAO y se encarga de interactuar
 * con la base de datos para realizar operaciones relacionadas con los clientes.
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class ClienteDAO implements IClienteDAO {

    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(ClienteDAO.class.getName());

    /**
    * Constructor de la clase ClienteDAO.
    *
    * @param conexionBD La conexión a la base de datos que se utilizará para realizar operaciones de persistencia.
    */
    public ClienteDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     * Agrega un nuevo cliente a la base de datos.
     *
     * @param clienteNuevo La información del nuevo cliente a agregar.
     * @return El cliente recién agregado.
     * @throws PersistenciaException Si ocurre un error durante la consulta a la base de datos.
     */
    @Override
    public Cliente agregar(ClienteNuevoDTO clienteNuevo) throws PersistenciaException {

        Validacion validacion = new Validacion(conexionBD);
        try {
            if (validacion.existeUsuario(clienteNuevo.getUsuario())) {
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
                Connection conexion = this.conexionBD.obtenerConexion(); 
                PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);
                ) {
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

    /**
     * Consulta todos los clientes almacenados en la base de datos.
     *
     * @return Una lista de clientes almacenados en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la consulta a la base de datos.
     */
    @Override
    public List<Cliente> consultar() throws PersistenciaException {
        String sentencia = """
                           SELECT id_cliente, nombres, apellido_paterno, apellido_materno, fecha_nacimiento, usuario
                           FROM socios;
                           """;
        List<Cliente> listaClientes = new LinkedList<>();
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentencia); ResultSet resultados = comando.executeQuery();) {
            while (resultados.next()) {
                Long idCliente = resultados.getLong("id_cliente");
                String nombre = resultados.getString("nombre");
                String apellidoPaterno = resultados.getString("apellido_paterno");
                String apellidoMaterno = resultados.getString("apellido_materno");
                String usuario = resultados.getString("usuario");
//                String contraseña = resultados.getString(nombre);
                String fechaNacimiento = resultados.getString("fecha_nacimiento");
                Cliente cliente = new Cliente(idCliente, nombre, apellidoPaterno, apellidoMaterno, usuario,"", fechaNacimiento);

                listaClientes.add(cliente);
            }
            logger.log(Level.INFO, "Se consultaron {0} clientes", listaClientes.size());
            return listaClientes;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se pudieron consultar los clientes", e);
            throw new PersistenciaException("No se pudieron consular los clientes", e);
        }
    }

    
    /**
     * Verifica si un cliente con el identificador especificado existe en la base de datos.
     *
     * @param idCliente El identificador único del cliente a verificar.
     * @return El cliente si existente, null si no existe.
     * @throws PersistenciaException Si ocurre un error durante la verificación.
     */
    @Override
    public Cliente existe(Long idCliente) throws PersistenciaException {
        String sentenciaSQL = """
                             SELECT * FROM clientes 
                               WHERE id_cliente = ?;
                              """;
          try (
            Connection conexion = this.conexionBD.obtenerConexion(); 
            PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);
            
        ) {
              
            comando.setLong(1, idCliente);
    
            try (ResultSet datosCuenta = comando.executeQuery()) {
                if (!datosCuenta.next()) {
                    logger.log(Level.INFO, "No se halló la cuenta con id {0}", idCliente);
                    return null;
                }

                logger.log(Level.INFO, "Se encontró la cuenta");
                Cliente cliente = new Cliente(
                    idCliente,
                    datosCuenta.getString("nombres"),
                    datosCuenta.getString("apellido_paterno"),
                    datosCuenta.getString("apellido_materno"),
                    datosCuenta.getString("usuario"),
                    datosCuenta.getString("contrasena"),
                    datosCuenta.getString("fecha_nacimiento")
                );
                return cliente;
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "No se pudo encontrar la cuenta.", e);
            throw new PersistenciaException("No se pudo encontrar la cuenta.", e);
        }
    
    }

}
