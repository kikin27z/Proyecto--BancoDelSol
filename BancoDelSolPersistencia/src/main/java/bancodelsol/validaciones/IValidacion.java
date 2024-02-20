package bancodelsol.validaciones;

import bancodelsoldominio.Cliente;
import bancodelsoldominio.Cuenta;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import bancodelsolpersistencia.excepciones.ValidacionDTOException;

/**
 * Esta interfaz define métodos para validar la existencia y autenticación de
 * clientes del banco.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public interface IValidacion {

    /**
     * Verifica si un usuario existe en la base de datos.
     *
     * @param usuario Nombre de usuario a verificar.
     * @return true si el usuario existe, false en caso contrario.
     * @throws ValidacionDTOException Si hay un error en la validación.
     * @throws PersistenciaException Si hay un error en la persistencia de datos.
     */
    boolean existeUsuario(String usuario) throws ValidacionDTOException, PersistenciaException;

    /**
     * Verifica si un cliente y contraseña son válidos.
     *
     * @param usuario Nombre de usuario del cliente.
     * @param contrasena Contraseña del cliente.
     * @return Objeto Cliente si es válido, null si no coincide o no existe.
     * @throws ValidacionDTOException Si hay un error en la validación de datos.
     */
    Cliente clienteValido(String usuario, String contrasena) throws ValidacionDTOException;
    
     /**
     * Verifica si un cliente existe en la base de datos.
     *
     * @param idCliente Identificador del cliente a verificar.
     * @return Objeto Cliente si existe, null si no se encuentra.
     * @throws PersistenciaException Si hay un error en la persistencia de datos.
     */
    Cliente existeCliente(Long idCliente) throws PersistenciaException;
    
     /**
     * Verifica si una cuenta existe en la base de datos.
     *
     * @param numeroCuenta Número de cuenta a verificar.
     * @return Objeto Cuenta si existe, null si no se encuentra.
     * @throws ValidacionDTOException Si hay un error en la validación de datos.
     */
    Cuenta existeCuenta(String numeroCuenta) throws ValidacionDTOException;

}
