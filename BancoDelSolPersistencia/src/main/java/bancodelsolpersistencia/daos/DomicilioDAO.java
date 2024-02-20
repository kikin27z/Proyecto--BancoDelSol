package bancodelsolpersistencia.daos;

import bancodelsol.dtos.DomicilioNuevoDTO;
import bancodelsoldominio.Domicilio;
import bancodelsolpersistencia.conexion.IConexion;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase DomicilioDAO implementa la interfaz IDomicilioDAO y proporciona
 * implementaciones para realizar operaciones relacionadas con los domicilios en la
 * base de datos.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class DomicilioDAO implements IDomicilioDAO{

    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(DomicilioDAO.class.getName());

    /**
    * Constructor de la clase DomicilioDAO.
    *
    * @param conexionBD La conexión a la base de datos que se utilizará para realizar operaciones de persistencia.
    */
    public DomicilioDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     * Agrega un domicilio nuevo a la base de datos.
     *
     * @param domicilioNuevo  La información del nuevo domicilio a agregar.
     * @param idCliente El identificador del cliente a asociar el domicilio
     * @return El domicilio recién agregada.
     * @throws PersistenciaException Si ocurre un error durante la consulta a la base de datos.
     */
    @Override
    public Domicilio agregar(DomicilioNuevoDTO domicilioNuevo, Long idCliente) throws PersistenciaException {
        String sentenciaSQL = """
                             INSERT INTO domicilios (calle, colonia, codigo_postal, numero_exterior, ciudad, id_cliente) 
                              VALUES (?, ?, ?, ?, ?, ?);
                              """;
        try (
            Connection conexion = this.conexionBD.obtenerConexion(); 
            PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);
        ) {
            comando.setString(1, domicilioNuevo.getCalle());
            comando.setString(2, domicilioNuevo.getColonia());
            comando.setString(3, domicilioNuevo.getCodigoPostal());
            comando.setString(4, domicilioNuevo.getNumeroExterior());
            comando.setString(5, domicilioNuevo.getCiudad());
            comando.setLong(6, idCliente);
            
            int numeroRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agregaron {0} domicilios", numeroRegistrosInsertados);
            ResultSet idsGenerados = comando.getGeneratedKeys();
            idsGenerados.next();
            Domicilio domicilio = new Domicilio(idsGenerados.getLong(1), domicilioNuevo.getCalle(), domicilioNuevo.getColonia(), domicilioNuevo.getNumeroExterior(),domicilioNuevo.getCodigoPostal(),domicilioNuevo.getCiudad(),idCliente);
            return domicilio;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "No se pudo guardar el domicilio.", e);
            throw new PersistenciaException("No se pudo guardar el domicilio.", e);
        }
    }

    /**
     * Método que devuelve el domicilio del cliente con su identificador de la base de datos.
     *
     * @param idCliente El identificador del cliente a asociar el domicilio
     * @return El domicilio recién agregada.
     * @throws PersistenciaException Si ocurre un error durante la consulta a la base de datos.
     */
    @Override
    public Domicilio existe(Long idCliente) throws PersistenciaException {
        String sentenciaSQL = """
                             SELECT * FROM domicilios 
                               WHERE id_cliente = ?;
                              """;
          try (
            Connection conexion = this.conexionBD.obtenerConexion(); 
            PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);
            
        ) {
              
            comando.setLong(1, idCliente);
    
            try (ResultSet datosDomicilio = comando.executeQuery()) {
                if (!datosDomicilio.next()) {
                    logger.log(Level.INFO, "No se halló el do con id {0}", idCliente);
                    return null;
                }

                logger.log(Level.INFO, "Se encontró la cuenta");
                Domicilio domicilio = new Domicilio(
                    datosDomicilio.getLong("id_domicilio"),
                    datosDomicilio.getString("calle"),
                    datosDomicilio.getString("colonia"),
                    datosDomicilio.getString("numero_exterior"),
                    datosDomicilio.getString("codigo_postal"),
                    datosDomicilio.getString("ciudad"),
                    datosDomicilio.getLong("id_cliente")
                );
                
                return domicilio;
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "No se pudo encontrar el domicilio.", e);
            throw new PersistenciaException("No se pudo encontrar el domicilio.", e);
        }
    }

    /**
     * Actualiza la información de un domicilio existente en la base de datos.
     *
     * @param domicilioNuevo  La información actualizada del cliente.
     * @param idCliente El identificador del cliente a asociar el domicilio.
     * @return El domicilio actualizado.
     * @throws PersistenciaException Si ocurre un error durante la actualización en la base de datos.
     */
    @Override
    public Domicilio actualizar(DomicilioNuevoDTO domicilioNuevo, Long idCliente) throws PersistenciaException {
        
        String sentenciaSQL = """
                                UPDATE domicilios SET calle = ?, colonia = ?,
                              codigo_postal = ?, numero_exterior = ?,
                              ciudad = ? WHERE (id_cliente = ?);
                              """;
        try (
        Connection conexion = this.conexionBD.obtenerConexion(); 
        PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);
        ) {
            comando.setString(1, domicilioNuevo.getCalle());
            comando.setString(2, domicilioNuevo.getColonia());
            comando.setString(3, domicilioNuevo.getCodigoPostal());
            comando.setString(4, domicilioNuevo.getNumeroExterior());
            comando.setString(5, domicilioNuevo.getCiudad());
            comando.setLong(6, idCliente);

            int registrosActualizados = comando.executeUpdate();
            logger.log(Level.INFO, "Se actualizaron {0} domicilio", registrosActualizados);

            // Devuelve el domicilio actualizado utilizando la información proporcionada en el DTO
            return null;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "No se pudo actualizar el domicilio.", e);
            throw new PersistenciaException("No se pudo actualizar el domicilio.", e);
        }
    }
    
}
