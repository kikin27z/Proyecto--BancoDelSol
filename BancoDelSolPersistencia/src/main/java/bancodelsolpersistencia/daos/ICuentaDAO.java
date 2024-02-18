package bancodelsolpersistencia.daos;

import bancodelsol.dtos.CuentaNuevaDTO;
import bancodelsoldominio.Cuenta;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public interface ICuentaDAO {
    Cuenta agregar(CuentaNuevaDTO cuentaNueva)throws PersistenciaException;
    Cuenta actualizar(Long idCuenta,double nuevoSaldo) throws PersistenciaException;
    Cuenta existe(Long idCuenta) throws PersistenciaException;
    List<Cuenta> consultar(Long idCliente) throws PersistenciaException;
//    Transferencia actualizar(TransferenciaActualizadadaDTO transferenciaActualizada) throws PersistenciaException;
//    Transferencia eliminar(Integer id)throws PersistenciaException;
}
