package bancodelsolpersistencia.daos;

import bancodelsol.dtos.TransferenciaNuevaDTO;
import bancodelsoldominio.Transferencia;
import bancodelsolpersistencia.conexion.IConexion;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class TransferenciaDAO implements ITransferenciaDAO{
    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(TransferenciaDAO.class.getName());
    
    public TransferenciaDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Transferencia agregar(TransferenciaNuevaDTO transferenciaNueva) throws PersistenciaException {
        String sentenciaSQLCrearTransaccion = """
                              
                              """;
        return null;
    }

    @Override
    public List<Transferencia> consultar() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Transferencia eliminar(Integer id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
