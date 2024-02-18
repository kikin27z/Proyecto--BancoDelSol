package bancodelsolpersistencia.daos;

import bancodelsol.dtos.CuentaNuevaDTO;
import bancodelsoldominio.Cuenta;
import bancodelsolpersistencia.conexion.IConexion;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase CuentaDAO implementa la interfaz ICuentaDAO y proporciona
 * implementaciones para realizar operaciones relacionadas con las cuentas en la
 * base de datos.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class CuentaDAO implements ICuentaDAO{
    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(CuentaDAO.class.getName());

    /**
    * Constructor de la clase CuentaDAO.
    *
    * @param conexionBD La conexión a la base de datos que se utilizará para realizar operaciones de persistencia.
    */
    public CuentaDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    
    /**
     * Agrega una nueva cuenta a la base de datos.
     *
     * @param cuentaNueva La información de la nueva cuenta a agregar.
     * @return La cuenta recién agregada.
     * @throws PersistenciaException Si ocurre un error durante la consulta a la base de datos.
     */
    @Override
    public Cuenta agregar(CuentaNuevaDTO cuentaNueva) throws PersistenciaException {
            String sentenciaSQL = """
                                  INSERT INTO cuentas (fecha_apertura, nombre_cuenta, numero_cuenta, saldo, id_cliente) 
                                  VALUES (?, ?, ?, ?, ?);
                              """;
        try (
            Connection conexion = this.conexionBD.obtenerConexion(); 
            PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);
        ) {
            //Insertar datos en el comando mySql
            java.sql.Date fechaHoy = java.sql.Date.valueOf(LocalDate.now());
            comando.setDate(1, fechaHoy);
            comando.setString(2, cuentaNueva.getNombreCuenta());
            comando.setString(3, cuentaNueva.getNumeroCuenta());
            comando.setDouble(4, Double.parseDouble(cuentaNueva.getSaldo()));
            comando.setLong(5, cuentaNueva.getIdCliente());

            // Se muestran los cambios de la base de datos
            int numeroRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agregaron {0} cuentas", numeroRegistrosInsertados);
            ResultSet filaGenerada = comando.getGeneratedKeys();
            filaGenerada.next();
            
            //Se insertan los datos de la cuenta a devolver
            Cuenta cuenta = new Cuenta(
                    filaGenerada.getLong(1),
                    LocalDate.now().toString(),
                    cuentaNueva.getNombreCuenta(),
                    cuentaNueva.getNumeroCuenta(),
                    Double.parseDouble(cuentaNueva.getSaldo()),
                    cuentaNueva.getIdCliente()
                );
            cuenta.toString();
            return cuenta;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "No se pudo guardar la cuenta.", e);
            throw new PersistenciaException("No se pudo guardar la cuenta.", e);
        }
    }

    /**
     * Actualiza el saldo de una cuenta existente.
     *
     * @param idCuenta El identificador único de la cuenta a actualizar.
     * @param nuevoSaldo El nuevo saldo a establecer para la cuenta.
     * @return La cuenta actualizada.
     * @throws PersistenciaException Si ocurre un error durante la actualización.
     */
    @Override
    public Cuenta actualizar(Long idCuenta,double nuevoSaldo) throws PersistenciaException {
        String sentenciaSQL = """
                                  UPDATE cuentas SET saldo = ? 
                              WHERE (id_cuenta = ?);
                              """;
        String sentenciaSQLTraerCuenta = """
                                         SELECT * FROM cuentas
                                         WHERE id_cuenta = ?;
                                         """;
        try (
            Connection conexion = this.conexionBD.obtenerConexion(); 
            PreparedStatement comando = conexion.prepareStatement(sentenciaSQL,Statement.RETURN_GENERATED_KEYS);
            PreparedStatement comandoSelect = conexion.prepareStatement(sentenciaSQLTraerCuenta);
        ) {
            comandoSelect.setLong(1, idCuenta);
    
                Cuenta cuenta = new Cuenta();
            try (ResultSet datosCuenta = comandoSelect.executeQuery()) {
                if (datosCuenta.next()) { // Mover el cursor al primer registro
                    logger.log(Level.INFO, "Se encontró la cuenta");
                    cuenta.setSaldo(datosCuenta.getDouble("saldo"));
                    cuenta.setFechaApertura(datosCuenta.getString("fecha_apertura"));
                    cuenta.setNumeroCuenta(datosCuenta.getString("numero_cuenta"));
                    cuenta.setIdCliente(datosCuenta.getLong("id_cliente"));
                } else {
                    throw new PersistenciaException("No se encontró la cuenta con ID: " + idCuenta);
                }
            }
            
            Double saldoActualizado = nuevoSaldo + cuenta.getSaldo();
            
            comando.setDouble(1, saldoActualizado);
            comando.setLong(2, idCuenta);
            
            int registrosActualizados = comando.executeUpdate();
            logger.log(Level.INFO, "Se actualizaron {0} cuentas", registrosActualizados);
            ResultSet idsGenerados = comando.getGeneratedKeys();
            idsGenerados.next();
//            cuenta.setSaldo(idsGenerados.getDouble("saldo"));
            return cuenta;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "No se pudo actualizar el socio.", e);
            throw new PersistenciaException("No se pudo actualizar el socio.", e);
        }
    }

    /**
     * Verifica si una cuenta con el identificador especificado existe en la base de datos.
     *
     * @param idCuenta El identificador único de la cuenta a verificar.
     * @return La cuenta si existe, null si no existe.
     * @throws PersistenciaException Si ocurre un error durante la verificación.
     */
    @Override
    public Cuenta existe(Long idCuenta) throws PersistenciaException {
        String sentenciaSQL = """
                             SELECT * FROM cuentas 
                               WHERE id_cuenta = ?;
                              """;
          try (
            Connection conexion = this.conexionBD.obtenerConexion(); 
            PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);
            
        ) {
              
            comando.setLong(1, idCuenta);
    
            try (ResultSet datosCuenta = comando.executeQuery()) {
                if (!datosCuenta.next()) {
                    logger.log(Level.INFO, "No se halló la cuenta con id {0}", idCuenta);
                    return null;
                }

                logger.log(Level.INFO, "Se encontró la cuenta");
                Cuenta cuenta = new Cuenta(
                    idCuenta,
                    datosCuenta.getString("fecha_apertura"),
                    datosCuenta.getString("nombre_cuenta"),
                    datosCuenta.getString("numero_cuenta"),
                    datosCuenta.getDouble("saldo"),
                    datosCuenta.getLong("id_cliente")
                );
                return cuenta;
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "No se pudo encontrar la cuenta.", e);
            throw new PersistenciaException("No se pudo encontrar la cuenta.", e);
        }
    }

    /**
     * Consulta todas las cuentas asociadas a un cliente específico.
     *
     * @param idCliente El identificador único del cliente cuyas cuentas se desean consultar.
     * @return Una lista de cuentas asociadas al cliente especificado.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    @Override
    public List<Cuenta> consultar(Long idCliente) throws PersistenciaException {
        String sentenciaSQL = """
                              SELECT * FROM cuentas 
                              WHERE id_cliente = ?;
                              """;
        
        List<Cuenta> listaCuentas = new LinkedList<>();
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); 
                PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);
                ) {
            comando.setLong(1, idCliente);
            try (ResultSet resultados = comando.executeQuery()) {
                while (resultados.next()) {
                    Long id = resultados.getLong("id_cuenta");
                    String fechaApertura = resultados.getString("fecha_apertura");
                    String numCuenta = resultados.getString("numero_cuenta");
                    String nombreCuenta = resultados.getString("nombre_cuenta");
                    double saldo = resultados.getDouble("saldo");
                    Cuenta cuenta = new Cuenta(id, fechaApertura,nombreCuenta, numCuenta, saldo,idCliente);
                    listaCuentas.add(cuenta);
                }
             }
            logger.log(Level.INFO,"Se consultaron {0} cuentas", listaCuentas.size());
            return listaCuentas;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudieron consultar las cuentas", ex);
            throw new PersistenciaException("No se pudieron consultar las cuentas",ex);
        }
    }
    
}
