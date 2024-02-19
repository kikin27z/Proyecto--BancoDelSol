package bancodelsol.validaciones;

import bancodelsoldominio.Cliente;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import bancodelsolpersistencia.excepciones.ValidacionDTOException;

/**
 *
 * @author
 */
public interface IValidacion {

    boolean existeUsuario(String usuario) throws ValidacionDTOException, PersistenciaException;

    Cliente existeCliente(Long idCliente) throws PersistenciaException;

    Cliente clienteValido(String usuario, String contrasena) throws ValidacionDTOException;

}
