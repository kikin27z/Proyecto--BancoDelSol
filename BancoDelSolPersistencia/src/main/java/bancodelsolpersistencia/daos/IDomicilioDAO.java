package bancodelsolpersistencia.daos;

import bancodelsol.dtos.DomicilioNuevoDTO;
import bancodelsoldominio.Domicilio;
import bancodelsolpersistencia.excepciones.PersistenciaException;

/**
 *
 * @author karim
 */
public interface IDomicilioDAO {
    Domicilio agregar(DomicilioNuevoDTO transferenciaNueva,Long idCliente)throws PersistenciaException;
}
