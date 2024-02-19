package bancodelsol.validaciones;

import bancodelsoldominio.Cliente;
import bancodelsoldominio.Cuenta;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import bancodelsolpersistencia.excepciones.ValidacionDTOException;

/**
 * Interfaz que define los métodos para validar usuarios, clientes y cuentas en el sistema bancario.
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public interface IValidacion {

    /**
     * Verifica si un usuario existe en el sistema.
     * 
     * @param usuario El nombre de usuario a verificar.
     * @return true si el usuario existe, false de lo contrario.
     * @throws ValidacionDTOException Si ocurre un error de validación.
     * @throws PersistenciaException Si ocurre un error de persistencia.
     */
    boolean existeUsuario(String usuario) throws ValidacionDTOException, PersistenciaException;

    /**
     * Valida las credenciales de un cliente en el sistema.
     * 
     * @param usuario El nombre de usuario del cliente.
     * @param contrasena La contraseña del cliente.
     * @return El objeto Cliente si las credenciales son válidas.
     * @throws ValidacionDTOException Si ocurre un error de validación.
     */
    Cliente clienteValido(String usuario, String contrasena) throws ValidacionDTOException;

    /**
     * Verifica si un cliente existe en el sistema dado su identificador.
     * 
     * @param idCliente El identificador del cliente.
     * @return El objeto Cliente si existe, null de lo contrario.
     * @throws PersistenciaException Si ocurre un error de persistencia.
     */
    Cliente existeCliente(Long idCliente) throws PersistenciaException;

    /**
     * Verifica si una cuenta existe en el sistema dado su número.
     * 
     * @param numeroCuenta El número de cuenta a verificar.
     * @return El objeto Cuenta si existe.
     * @throws ValidacionDTOException Si ocurre un error de validación.
     */
    Cuenta existeCuenta(String numeroCuenta) throws ValidacionDTOException;

}
