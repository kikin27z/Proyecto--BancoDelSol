package bancodelsolpersistencia.daos;

import bancodelsol.dtos.DomicilioNuevoDTO;
import bancodelsoldominio.Cliente;
import bancodelsoldominio.Domicilio;
import bancodelsolpersistencia.conexion.IConexion;
import static bancodelsolpersistencia.daos.ClienteDAO.logger;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karim
 */
public class DomicilioDAO implements IDomicilioDAO{

    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(DomicilioDAO.class.getName());

    public DomicilioDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }

    
    @Override
    public Domicilio agregar(DomicilioNuevoDTO domicilioNuevo, Long idCliente) throws PersistenciaException {
        String sentenciaSQL = """
                             INSERT INTO domicilios (calle, colonia, codigo_postal, numero_exterior, ciudad, id_cliente) 
                              VALUES (?, ?, ?, ?, ?, ?);
                              """;
        try (
            Connection conexion = this.conexionBD.obtenerConexion(); 
            PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);
        ) {
            comando.setString(1, domicilioNuevo.getCalle());
            comando.setString(2, domicilioNuevo.getColonia());
            comando.setString(3, domicilioNuevo.getCodigoPostal());
            comando.setString(4, domicilioNuevo.getNumeroExterior());
            comando.setString(5, domicilioNuevo.getCiudad());
            comando.setLong(6, idCliente);
            
            int numeroRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agregaron {0} domicilios", numeroRegistrosInsertados);
            ResultSet idsGenerados = comando.getGeneratedKeys();
            idsGenerados.next();
            Domicilio domicilio = new Domicilio(idsGenerados.getLong(1), domicilioNuevo.getCalle(), domicilioNuevo.getColonia(), domicilioNuevo.getNumeroExterior(),domicilioNuevo.getCodigoPostal(),domicilioNuevo.getCiudad(),idCliente);
            return domicilio;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "No se pudo guardar el domicilio.", e);
            throw new PersistenciaException("No se pudo guardar el domicilio.", e);
        }
    }
    
}
