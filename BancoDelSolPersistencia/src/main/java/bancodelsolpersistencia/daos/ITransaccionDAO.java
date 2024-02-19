package bancodelsolpersistencia.daos;

import bancodelsoldominio.Transaccion;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author karim
 */
public interface ITransaccionDAO {
    
    List<Transaccion> consultar() throws PersistenciaException; 
}
