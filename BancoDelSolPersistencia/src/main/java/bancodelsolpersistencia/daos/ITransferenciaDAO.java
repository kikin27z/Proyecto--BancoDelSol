package bancodelsolpersistencia.daos;

import bancodelsol.dtos.TransferenciaNuevaDTO;
import bancodelsoldominio.Transferencia;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public interface ITransferenciaDAO {
    Transferencia agregar(TransferenciaNuevaDTO transferenciaNueva)throws PersistenciaException;
    List<Transferencia> consultar() throws PersistenciaException;
//    Transferencia actualizar(TransferenciaActualizadadaDTO transferenciaActualizada) throws PersistenciaException;
    Transferencia eliminar(Integer id)throws PersistenciaException;
}
