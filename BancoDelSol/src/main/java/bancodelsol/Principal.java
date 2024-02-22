package bancodelsol;

import bancodelsolpersistencia.conexion.Conexion;
import bancodelsolpersistencia.conexion.IConexion;
import bancodelsolpersistencia.daos.ClienteDAO;
import bancodelsolpersistencia.daos.CuentaDAO;
import bancodelsolpersistencia.daos.IClienteDAO;
import bancodelsolpersistencia.daos.ICuentaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase principal del programa.
 * Inicia la aplicación y establece la conexión con la base de datos.
 * Crea instancias de las clases DAO necesarias para interactuar con la base de datos.
 * Muestra la ventana principal de la aplicación.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class Principal {

    static final Logger logger = Logger.getLogger(Principal.class.getName());
    
    public static void main(String[] args) {
            String cadenaConexion = "jdbc:mysql://localhost/banco_del_sol";
            String user = "root";
            String password = "tElina.69";
            
            IConexion conexion = new Conexion(cadenaConexion, user, password);
            IClienteDAO clientesDAO = new ClienteDAO(conexion);
            ICuentaDAO cuentaDAO = new CuentaDAO(conexion);
            
            Ventana ventana = new Ventana(conexion);
            ventana.cambiarVistaInicio();
            ventana.setVisible(true);
    }
}
