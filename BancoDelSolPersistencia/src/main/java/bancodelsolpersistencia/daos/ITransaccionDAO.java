package bancodelsolpersistencia.daos;

import bancodelsoldominio.Retiro;
import bancodelsoldominio.Transaccion;
import bancodelsoldominio.Transferencia;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Esta interfaz define los métodos que deben ser implementados por las clases DAO 
 * relacionadas con las transacciones en la base de datos.
 * Los métodos permiten realizar operaciones como realizar transferencias, consultar
 * transacciones y crear un modelo de tabla con información de las transacciones.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public interface ITransaccionDAO {
    
    /**
     * Realiza una transferencia entre cuentas.
     * 
     * @param idCuenta El ID de la cuenta desde la que se realizará la transferencia.
     * @param numeroCuentaDestino El número de cuenta destino.
     * @param motivo El motivo de la transferencia.
     * @param monto El monto de la transferencia.
     * @return Una instancia de Transferencia representando la transferencia realizada, o null si no se pudo realizar.
     * @throws PersistenciaException Si hay un error al acceder a la base de datos.
     */
    Transferencia realizarTransferencia(Long idCuenta,String numeroCuentaDestino,String motivo, Double monto) throws PersistenciaException;
    
    /**
     * Consulta todas las transacciones (transferencias y retiros) almacenadas en la base de datos.
     * 
     * @return Una lista de objetos Transaccion que representan las transacciones consultadas.
     * @throws PersistenciaException Si hay un error al acceder a la base de datos.
     */
    List<Transaccion> consultar() throws PersistenciaException; 
    
    /**
     * Crea un modelo de tabla con la información de todas las transacciones (transferencias y retiros) almacenadas en la base de datos.
     * 
     * @param modelo El modelo de tabla donde se agregarán los datos de las transacciones.
     * @param idCliente El ID del cliente del que se quieren obtener las transacciones.
     * @param opcion La opción que indica si se quieren consultar todas las transacciones o solo las del último mes.
     * @throws PersistenciaException Si hay un error al acceder a la base de datos.
     */
    void crearTabla(DefaultTableModel  modelo, Long idCliente, int opcion) throws PersistenciaException;
    
    /**
     * Crea un modelo de tabla con la información de todas las transacciones (transferencias y retiros) almacenadas en la base de datos en un período específico.
     * 
     * @param modelo El modelo de tabla donde se agregarán los datos de las transacciones.
     * @param fechaDesde La fecha de inicio del período.
     * @param fechaHasta La fecha de fin del período.
     * @param idCliente El ID del cliente del que se quieren obtener las transacciones.
     * @param opcion La opción que indica si se quieren consultar todas las transacciones o solo las del período especificado.
     * @throws PersistenciaException Si hay un error al acceder a la base de datos.
     */
    void creaTablaConPeriodo(DefaultTableModel modelo, String fechaDesde, String fechaHasta,Long idCliente, int opcion) throws PersistenciaException;
    
    boolean generarRetiroSinCuenta(long idCuenta, String folio, String contrasena) throws PersistenciaException;
    
    Retiro buscarRetiro(String folio, String contrasena) throws PersistenciaException;
}
