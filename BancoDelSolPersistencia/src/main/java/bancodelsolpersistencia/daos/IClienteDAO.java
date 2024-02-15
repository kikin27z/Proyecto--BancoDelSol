package bancodelsolpersistencia.daos;

import bancodelsol.dtos.ClienteNuevoDTO;
import bancodelsoldominio.Cliente;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public interface IClienteDAO {
    Cliente agregar(ClienteNuevoDTO clienteNuevo)throws PersistenciaException;
    List<Cliente> consultar() throws PersistenciaException;
    Cliente existe(Long idCliente) throws PersistenciaException;
    
}