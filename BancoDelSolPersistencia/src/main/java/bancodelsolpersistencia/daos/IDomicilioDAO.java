package bancodelsolpersistencia.daos;

import bancodelsol.dtos.DomicilioNuevoDTO;
import bancodelsoldominio.Domicilio;
import bancodelsolpersistencia.excepciones.PersistenciaException;

/**
 * Esta interfaz define las operaciones que pueden realizarse sobre objetos de tipo Domicilio.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public interface IDomicilioDAO {
    
    /**
     * Agrega un domicilio nuevo a la base de datos.
     *
     * @param domicilioNuevo  La información del nuevo domicilio a agregar.
     * @param idCliente El identificador del cliente a asociar el domicilio
     * @return El domicilio recién agregada.
     * @throws PersistenciaException Si ocurre un error durante la consulta a la base de datos.
     */
    Domicilio agregar(DomicilioNuevoDTO domicilioNuevo,Long idCliente)throws PersistenciaException;
    
    /**
     * Método que devuelve el domicilio del cliente con su identificador de la base de datos.
     *
     * @param idCliente El identificador del cliente a asociar el domicilio
     * @return El domicilio recién agregada.
     * @throws PersistenciaException Si ocurre un error durante la consulta a la base de datos.
     */
    Domicilio existe(Long idCliente) throws PersistenciaException;
    
    /**
     * Actualiza la información de un domicilio existente en la base de datos.
     *
     * @param domicilioNuevo  La información actualizada del cliente.
     * @param idCliente El identificador del cliente a asociar el domicilio.
     * @return El domicilio actualizado.
     * @throws PersistenciaException Si ocurre un error durante la actualización en la base de datos.
     */
    Domicilio actualizar(DomicilioNuevoDTO domicilioNuevo,Long idCliente) throws PersistenciaException;
}
