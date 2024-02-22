package bancodelsolpersistencia.daos;

import bancodelsoldominio.Cuenta;
import bancodelsoldominio.Retiro;
import bancodelsolpersistencia.conexion.IConexion;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Clase que implementa la interfaz IRetiroDAO para operaciones relacionadas con retiros en la base de datos.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913r
 */
public class RetiroDAO implements IRetiroDAO {

    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(Retiro.class.getName());

    /**
     * Constructor de RetiroDAO.
     * @param conexionBD Objeto que proporciona la conexión a la base de datos.
     */
    public RetiroDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     * Consulta el saldo de una cuenta y verifica si hay suficiente saldo para realizar un retiro.
     * @param cuenta La cuenta de la que se consultará el saldo.
     * @param saldo El saldo que se intentará retirar.
     * @return El nuevo saldo después de realizar el retiro.
     * @throws PersistenciaException Si ocurre algún error durante la consulta.
     */
    @Override
    public double consultarSaldo(Cuenta cuenta, double saldo) throws PersistenciaException {
        String numeroCuenta = cuenta.getNumeroCuenta();
        String sentenciaSQL = """
                         SELECT saldo FROM cuentas 
                         WHERE numero_cuenta = ?;
                          """;
        double saldoActual;
        try (Connection conexion = this.conexionBD.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);) {
            comando.setString(1, numeroCuenta);
            try (ResultSet saldoCuenta = comando.executeQuery()) {
                if (saldoCuenta.next()) {
                    saldoActual = saldoCuenta.getDouble("saldo");
                    if (saldoActual >= saldo) {
                        return saldoActual - saldo;
                    } else {
                        throw new PersistenciaException("El saldo de la cuenta no es suficiente para realizar esta operación");
                    }
                } else {
                    throw new PersistenciaException("La cuenta especificada no existe");
                }
            } catch (SQLException e) {
                throw new PersistenciaException("Error al consultar el saldo de la cuenta", e);
            }
        } catch (SQLException ex) {
            throw new PersistenciaException("Error de conexión a la base de datos", ex);
        }
    }

     /**
     * Verifica si un folio dado ya existe en la base de datos.
     * @param folio El folio que se verificará.
     * @return true si el folio existe, false en caso contrario.
     * @throws PersistenciaException Si ocurre algún error durante la verificación.
     */
    @Override
    public boolean existeFolio(String folio) throws PersistenciaException {
        String sentenciaSQL = "SELECT COUNT(*) AS count FROM retiros WHERE folio = ?";
        try (Connection conexion = this.conexionBD.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL)) {
            comando.setString(1, folio);
            try (ResultSet resultado = comando.executeQuery()) {
                if (resultado.next()) {
                    int count = resultado.getInt("count");
                    return count > 0; // Si count es mayor que cero, el folio existe en la tabla
                } else {
                    throw new PersistenciaException("Error al verificar folios");
                }
            }
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al verificar folios", ex);
        }
    }

    /**
     * Genera un registro de retiro en la base de datos.
     * @param retiro El objeto Retiro que se registrará.
     * @return true si el registro se generó exitosamente, false en caso contrario.
     * @throws PersistenciaException Si ocurre algún error durante la inserción.
     */
    @Override
    public boolean generarRegistroRetiro(Retiro retiro) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO retiros (contrasena, folio) VALUES (?, ?)";
        try (Connection conexion = this.conexionBD.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL)) {
            comando.setString(1, retiro.getContrasena());
            comando.setString(2, retiro.getFolio());
            int filasAfectadas = comando.executeUpdate();
            return filasAfectadas > 0; // Devuelve true si se insertó al menos una fila
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al generar el registro de retiro", ex);
        }
    }
    
    /**
     * Consulta el monto del retiro sin cuenta y el número de cuenta al que pertenece.
     * @param folio El folio del retiro sin cuenta.
     * @param contrasena La contraseña asociada al retiro sin cuenta.
     * @return Un arreglo de objetos donde el primer elemento es el monto del retiro y el segundo elemento es el número de cuenta.
     * @throws PersistenciaException Si ocurre algún error durante la consulta.
     */
    @Override
    public Object[] consultarRetiroSinCuenta(String folio, String contrasena) throws PersistenciaException {
        String sentenciaSQL = """
                         SELECT t.monto, c.numero_cuenta
                         FROM retiros r
                         INNER JOIN transacciones t ON r.id_transaccion = t.id_transaccion
                         INNER JOIN cuentas c ON t.id_cuenta = c.id_cuenta
                         WHERE r.folio = ? AND r.contrasena = ?;
                          """;

        try (Connection conexion = this.conexionBD.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL)) {
            comando.setString(1, folio);
            comando.setString(2, contrasena);
            try (ResultSet resultado = comando.executeQuery()) {
                if (resultado.next()) {
                    double monto = resultado.getDouble("monto");
                    String numeroCuenta = resultado.getString("numero_cuenta");
                    return new Object[]{monto, numeroCuenta};
                } else {
                    throw new PersistenciaException("No se encontró un retiro sin cuenta con el folio y la contraseña especificados");
                }
            }
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al consultar el retiro sin cuenta", ex);
        }
    }
    

}
