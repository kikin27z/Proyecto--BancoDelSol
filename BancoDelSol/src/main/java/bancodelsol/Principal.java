package bancodelsol;

import bancodelsol.dtos.ClienteNuevoDTO;
import bancodelsol.dtos.CuentaNuevaDTO;
import bancodelsol.dtos.TransferenciaNuevaDTO;
import bancodelsoldominio.Cliente;
import bancodelsoldominio.Cuenta;
import bancodelsolpersistencia.conexion.Conexion;
import bancodelsolpersistencia.conexion.IConexion;
import bancodelsolpersistencia.daos.ClienteDAO;
import bancodelsolpersistencia.daos.CuentaDAO;
import bancodelsolpersistencia.daos.IClienteDAO;
import bancodelsolpersistencia.daos.ICuentaDAO;
import bancodelsolpersistencia.daos.ITransferenciaDAO;
import bancodelsolpersistencia.daos.TransferenciaDAO;
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
        ICuentaDAO cuentaDAO = new CuentaDAO(conexion);
        ITransferenciaDAO transferenciaDAO = new TransferenciaDAO(conexion);
        
        Ventana ventana = new Ventana();
        ventana.cambiarVistaCliente();
//        VistaCliente vistaCliente = new VistaCliente(ventana);
//        
//        ventana.add(vistaCliente);
//        vistaCliente.setBounds(0, 0, 1000, 580);
//        ventana.setLocationRelativeTo(null);
//        ventana.setVisible(true);
        
        
        
//        try {
//            TransferenciaNuevaDTO transferenciaNueva = new TransferenciaNuevaDTO();
//            transferenciaNueva.setMonto(200);
//            transferenciaNueva.setCuentaDestino("1234567899123456");
//            
//            transferenciaDAO.agregar(transferenciaNueva, Long.valueOf(2));
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
}


/*
CuentaNuevaDTO cuentaDTO = new CuentaNuevaDTO();
            cuentaDTO.setNumeroCuenta("0364577099123456");
            cuentaDTO.setIdCliente(Long.valueOf(4));
            cuentaDTO.setSaldo(300);
            
            cuentaDAO.agregar(cuentaDTO);

ClienteNuevoDTO prueba = new ClienteNuevoDTO();
            prueba.setNombres("Luis Miguel");
            prueba.setApellidoPaterno("Basteri");
            prueba.setApellidoMaterno("Gallego");
            prueba.setFecha("2004-03-27");
            prueba.setUsuario("kikin27z");
            prueba.setContrasena("1234qwerty");
            
            
            clientesDAO.agregar(prueba);
*/