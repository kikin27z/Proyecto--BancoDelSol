package bancodelsol.validaciones;

import bancodelsoldominio.Cliente;
import bancodelsoldominio.Cuenta;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import bancodelsolpersistencia.excepciones.ValidacionDTOException;

/**
 *
 * @author
 */
public interface IValidacion {

    boolean existeUsuario(String usuario) throws ValidacionDTOException, PersistenciaException;

    Cliente clienteValido(String usuario, String contrasena) throws ValidacionDTOException;
    
    Cliente existeCliente(Long idCliente) throws PersistenciaException;
    
    Cuenta existeCuenta(String numeroCuenta) throws ValidacionDTOException;

}
