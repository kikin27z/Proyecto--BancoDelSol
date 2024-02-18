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
}
