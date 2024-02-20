package bancodelsolpersistencia.daos;

import bancodelsoldominio.Cuenta;
import bancodelsoldominio.Retiro;
import bancodelsolpersistencia.excepciones.PersistenciaException;

/**
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public interface IRetiroDAO {

    double consultarSaldo(Cuenta cuenta, double saldo) throws PersistenciaException;

    boolean existeFolio(String folio) throws PersistenciaException;
    
    boolean generarRegistroRetiro(Retiro retiro) throws PersistenciaException;
}
