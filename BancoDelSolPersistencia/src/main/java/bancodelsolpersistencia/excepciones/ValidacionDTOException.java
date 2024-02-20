package bancodelsolpersistencia.excepciones;

/**
 * Excepción personalizada para manejar errores relacionados con la validación de objetos DTO.
 * Esta excepción se utiliza para indicar problemas durante el proceso de validación de los objetos DTO.
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class ValidacionDTOException extends Exception{
    
    /**
     * Constructor por defecto de la excepción.
     */
    public ValidacionDTOException() {
    }

    /**
     * Constructor que recibe un mensaje descriptivo del error.
     * @param message Mensaje descriptivo del error.
     */
    public ValidacionDTOException(String message) {
        super(message);
    }

    /**
     * Constructor que recibe un mensaje descriptivo del error y una causa subyacente.
     * @param message Mensaje descriptivo del error.
     * @param cause Causa subyacente del error.
     */
    public ValidacionDTOException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que recibe una causa subyacente del error.
     * @param cause Causa subyacente del error.
     */
    public ValidacionDTOException(Throwable cause) {
        super(cause);
    }

     /**
     * Constructor que recibe un mensaje descriptivo del error, una causa subyacente, 
     * y especifica si la supresión de la pila de la excepción y la capacidad de ser escrita en la pila están habilitadas o no.
     * @param message Mensaje descriptivo del error.
     * @param cause Causa subyacente del error.
     * @param enableSuppression Si la supresión de la pila de la excepción está habilitada o no.
     * @param writableStackTrace Si la excepción se puede escribir en la pila o no.
     */
    public ValidacionDTOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
