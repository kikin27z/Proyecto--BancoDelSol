package bancodelsolpersistencia.daos;

import bancodelsol.dtos.ClienteNuevoDTO;
import bancodelsoldominio.Cliente;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import java.util.List;

/**
 * Esta interfaz proporciona métodos para agregar nuevos clientes y consultar la
 * información de los clientes existentes en la base de datos.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public interface IClienteDAO {
    /**
     * Agrega un nuevo cliente a la base de datos.
     *
     * @param clienteNuevo La información del nuevo cliente a agregar.
     * @return El cliente recién agregado.
     * @throws PersistenciaException Si ocurre un error durante la consulta a la base de datos.
     */
    Cliente agregar(ClienteNuevoDTO clienteNuevo)throws PersistenciaException;
    
    /**
     * Consulta todos los clientes almacenados en la base de datos.
     *
     * @return Una lista de clientes almacenados en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la consulta a la base de datos.
     */
    List<Cliente> consultar() throws PersistenciaException;
    
     /**
     * Verifica si un cliente con el identificador especificado existe en la base de datos.
     *
     * @param idCliente El identificador único del cliente a verificar.
     * @return El cliente si existente, null si no existe.
     * @throws PersistenciaException Si ocurre un error durante la verificación.
     */
    Cliente existe(Long idCliente) throws PersistenciaException;
}
