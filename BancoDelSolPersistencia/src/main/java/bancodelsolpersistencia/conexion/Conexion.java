package bancodelsolpersistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class Conexion implements IConexion{
    final String cadenaConexion;
    final String user;
    final String password;
    static final Logger logger = Logger.getLogger(Conexion.class.getName());

    public Conexion(String cadenaConexion, String user, String password) {
        this.cadenaConexion = cadenaConexion;
        this.user = user;
        this.password = password;
    }

    @Override
    public Connection obtenerConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(cadenaConexion, user, password);
        logger.log(Level.INFO,"Conexion establecida {0}", cadenaConexion);
        return conexion;
    }
}
