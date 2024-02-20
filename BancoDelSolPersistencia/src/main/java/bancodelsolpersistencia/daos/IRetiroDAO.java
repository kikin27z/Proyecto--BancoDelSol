package bancodelsolpersistencia.daos;

import bancodelsoldominio.Cuenta;
import bancodelsoldominio.Retiro;
import bancodelsolpersistencia.excepciones.PersistenciaException;

/**
 * Interfaz que define las operaciones para acceder y manipular datos relacionados con retiros en la base de datos.
 * Implementaciones de esta interfaz deben proporcionar funcionalidad para consultar saldos, verificar la existencia de folios
 * y generar registros de retiros.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public interface IRetiroDAO {

     /**
     * Consulta el saldo de una cuenta y verifica si hay suficiente saldo para realizar un retiro.
     * @param cuenta La cuenta de la que se consultará el saldo.
     * @param saldo El saldo que se intentará retirar.
     * @return El nuevo saldo después de realizar el retiro.
     * @throws PersistenciaException Si ocurre algún error durante la consulta.
     */
    double consultarSaldo(Cuenta cuenta, double saldo) throws PersistenciaException;

     /**
     * Verifica si un folio dado ya existe en la base de datos.
     * @param folio El folio que se verificará.
     * @return true si el folio existe, false en caso contrario.
     * @throws PersistenciaException Si ocurre algún error durante la verificación.
     */
    boolean existeFolio(String folio) throws PersistenciaException;
    
    /**
     * Genera un registro de retiro en la base de datos.
     * @param retiro El objeto Retiro que se registrará.
     * @return true si el registro se generó exitosamente, false en caso contrario.
     * @throws PersistenciaException Si ocurre algún error durante la inserción.
     */
    boolean generarRegistroRetiro(Retiro retiro) throws PersistenciaException;
}
