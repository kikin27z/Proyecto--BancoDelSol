/**
 * Excepción personalizada para representar errores relacionados con transacciones en el sistema.
 * Esta excepción se puede lanzar en situaciones donde ocurren problemas durante la realización
 * de transacciones en la persistencia de datos del sistema.
 */
package bancodelsolpersistencia.excepciones;

public class TransaccionException extends Exception {

    /**
     * Construye una nueva excepción TransaccionException sin mensaje detallado.
     * @author José Karim Franco Valencia - 245138
     * @author Jesús Roberto García Armenta - 244913
     */
    public TransaccionException() {
    }

    /**
     * Construye una nueva excepción TransaccionException con el mensaje
     * detallado especificado.
     *
     * @param message el mensaje detallado (que posteriormente se puede
     * recuperar a través del método getMessage())
     */
    public TransaccionException(String message) {
        super(message);
    }

    /**
     * Construye una nueva excepción TransaccionException con el mensaje
     * detallado y la causa especificados.
     *
     * @param message el mensaje detallado (que posteriormente se puede
     * recuperar a través del método getMessage())
     * @param cause la causa (que posteriormente se puede recuperar a través del
     * método getCause())
     */
    public TransaccionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construye una nueva excepción TransaccionException con la causa
     * especificada y un mensaje detallado predeterminado ("null").
     *
     * @param cause la causa (que posteriormente se puede recuperar a través del
     * método getCause())
     */
    public TransaccionException(Throwable cause) {
        super(cause);
    }

    /**
     * Construye una nueva excepción TransaccionException con el mensaje
     * detallado, la causa, la capacidad de supresión de habilitación o
     * deshabilitación y la capacidad de rastreo de pila habilitación o
     * deshabilitación especificados.
     *
     * @param message el mensaje detallado (que posteriormente se puede
     * recuperar a través del método getMessage())
     * @param cause la causa (que posteriormente se puede recuperar a través del
     * método getCause())
     * @param enableSuppression si la supresión está habilitada o no
     * @param writableStackTrace si la pila de seguimiento debe ser o no
     * rastreable
     */
    public TransaccionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
