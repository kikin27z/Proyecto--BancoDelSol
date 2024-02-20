package bancodelsolpersistencia.daos;

import bancodelsoldominio.Transaccion;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author karim
 */
public interface ITransaccionDAO {
    
    List<Transaccion> consultar() throws PersistenciaException; 
    
    void crearTabla(DefaultTableModel  modelo) throws PersistenciaException;
}
