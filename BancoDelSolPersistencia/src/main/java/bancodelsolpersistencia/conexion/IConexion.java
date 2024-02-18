package bancodelsolpersistencia.conexion;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Esta interfaz se utiliza en la capa de persistencia de la aplicación bancaria para
 * establecer conexiones a la base de datos y realizar operaciones de base de datos.
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public interface IConexion {
    /**
     * Método para obtener una conexión a la base de datos.
     *
     * @return Una conexión a la base de datos.
     * @throws SQLException Si ocurre un error al intentar establecer la conexión.
     */
    Connection obtenerConexion() throws SQLException;
}
