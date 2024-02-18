package bancodelsolpersistencia.daos;

import bancodelsol.dtos.CuentaNuevaDTO;
import bancodelsoldominio.Cuenta;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import java.util.List;

/**
 * Esta interfaz define las operaciones que pueden realizarse sobre objetos de tipo Cuenta.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public interface ICuentaDAO {
     /**
     * Agrega una nueva cuenta a la base de datos.
     *
     * @param cuentaNueva La información de la nueva cuenta a agregar.
     * @return La cuenta recién agregada.
     * @throws PersistenciaException Si ocurre un error durante la consulta a la base de datos.
     */
    Cuenta agregar(CuentaNuevaDTO cuentaNueva)throws PersistenciaException;
    
    /**
     * Actualiza el saldo de una cuenta existente.
     *
     * @param idCuenta El identificador único de la cuenta a actualizar.
     * @param nuevoSaldo El nuevo saldo a establecer para la cuenta.
     * @return La cuenta actualizada.
     * @throws PersistenciaException Si ocurre un error durante la actualización.
     */
    Cuenta actualizar(Long idCuenta,double nuevoSaldo) throws PersistenciaException;
    
    /**
     * Verifica si una cuenta con el identificador especificado existe en la base de datos.
     *
     * @param idCuenta El identificador único de la cuenta a verificar.
     * @return La cuenta si existe, null si no existe.
     * @throws PersistenciaException Si ocurre un error durante la verificación.
     */
    Cuenta existe(Long idCuenta) throws PersistenciaException;
    
    /**
     * Consulta todas las cuentas asociadas a un cliente específico.
     *
     * @param idCliente El identificador único del cliente cuyas cuentas se desean consultar.
     * @return Una lista de cuentas asociadas al cliente especificado.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<Cuenta> consultar(Long idCliente) throws PersistenciaException;
}
