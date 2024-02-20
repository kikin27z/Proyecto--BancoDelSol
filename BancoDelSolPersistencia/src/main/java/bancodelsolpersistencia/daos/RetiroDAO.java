package bancodelsolpersistencia.daos;

import bancodelsoldominio.Cuenta;
import bancodelsolpersistencia.conexion.IConexion;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author rover
 */
public class RetiroDAO implements IRetiroDAO{

    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(TransferenciaDAO.class.getName());

    public RetiroDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }
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
    
    @Override
    public boolean existeFolio(String folio) throws PersistenciaException {
        String sentenciaSQL = "SELECT COUNT(*) AS count FROM retiros WHERE folio = ?";
        try (Connection conexion = this.conexionBD.obtenerConexion();
             PreparedStatement comando = conexion.prepareStatement(sentenciaSQL)) {
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
}