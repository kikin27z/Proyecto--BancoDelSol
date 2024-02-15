package bancodelsol;

import bancodelsol.dtos.ClienteNuevoDTO;
import bancodelsoldominio.Cliente;
import bancodelsolpersistencia.conexion.Conexion;
import bancodelsolpersistencia.conexion.IConexion;
import bancodelsolpersistencia.daos.ClienteDAO;
import bancodelsolpersistencia.daos.IClienteDAO;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karim
 */
public class Principal {

    static final Logger logger = Logger.getLogger(Principal.class.getName());
    
    public static void main(String[] args) {
        String cadenaConexion = "jdbc:mysql://localhost/banco_del_sol";
        String user = "root";
        String password = "JFK_jfk27";

        IConexion conexion = new Conexion(cadenaConexion, user, password);
        IClienteDAO clientesDAO = new ClienteDAO(conexion);
        
        try {
            ClienteNuevoDTO prueba = new ClienteNuevoDTO();
            prueba.setNombres("Luis Miguel");
            prueba.setApellidoPaterno("Basteri");
            prueba.setApellidoMaterno("Gallego");
            prueba.setFecha("2004-03-27");
            prueba.setUsuario("kikin27z");
            prueba.setContrasena("1234qwerty");
            
            
            clientesDAO.agregar(prueba);
        } catch (PersistenciaException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
