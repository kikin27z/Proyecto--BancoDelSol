package bancodelsolpersistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase Conexion implementa la interfaz IConexion y proporciona una implementación
 * para obtener una conexión a la base de datos.
 * 
 * Esta clase se utiliza en la capa de persistencia de la aplicación bancaria para
 * establecer conexiones a la base de datos MySQL.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class Conexion implements IConexion{
    final String cadenaConexion;
    final String user;
    final String password;
    static final Logger logger = Logger.getLogger(Conexion.class.getName());

    /**
     * Constructor de la clase Conexion.
     *
     * @param cadenaConexion La cadena de conexión a la base de datos.
     * @param user El nombre de usuario para la conexión a la base de datos.
     * @param password La contraseña para la conexión a la base de datos.
     */
    public Conexion(String cadenaConexion, String user, String password) {
        this.cadenaConexion = cadenaConexion;
        this.user = user;
        this.password = password;
    }

    /**
     * Método para obtener una conexión a la base de datos.
     *
     * @return Una conexión a la base de datos.
     * @throws SQLException Si ocurre un error al intentar establecer la conexión.
     */
    @Override
    public Connection obtenerConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(cadenaConexion, user, password);
        logger.log(Level.INFO,"Conexion establecida {0}", cadenaConexion);
        return conexion;
    }
}
