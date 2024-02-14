package bancodelsolpersistencia.conexion;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public interface IConexion {
    Connection obtenerConexion() throws SQLException;
}
