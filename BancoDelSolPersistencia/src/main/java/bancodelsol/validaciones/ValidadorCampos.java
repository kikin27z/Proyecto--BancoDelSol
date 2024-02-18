package bancodelsol.validaciones;

import bancodelsol.dtos.ClienteNuevoDTO;
import bancodelsol.dtos.CuentaNuevaDTO;
import bancodelsol.dtos.DomicilioNuevoDTO;
import bancodelsolpersistencia.excepciones.ValidacionDTOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que proporciona métodos para validar los campos de diferentes DTOs
 * utilizados en la aplicación.
 * Los métodos de esta clase lanzan excepciones de tipo ValidacionDTOException
 * en caso de que los datos proporcionados no cumplan con los criterios de
 * validación especificados.
 * 
 * Esta clase realiza validaciones como:
 *  - Longitud máxima y tipo de caracteres permitidos en nombres, apellidos,
 *    usuario, contraseña, calle, ciudad, colonia, número exterior, código postal,
 *    nombre de cuenta y saldo.
 *  - Formato de contraseña y saldo.
 *  - Rango de valores para el saldo de una cuenta.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class ValidadorCampos {

    /**
     * Valida los campos relacionados con los datos personales de un cliente
     * recibidos en un objeto ClienteNuevoDTO.
     * 
     * @param clienteDTO Objeto ClienteNuevoDTO que contiene los datos personales del cliente a validar.
     * @throws ValidacionDTOException Si los datos personales no cumplen con los criterios de validación.
     */
    public void validaSeccionDatosPersonales(ClienteNuevoDTO clienteDTO) throws ValidacionDTOException {
        String patronNombre = extensionCadena(50);
        String patronApellidos = extensionCadena(30);
        Pattern pattern = Pattern.compile(patronNombre);
        Pattern pattern2 = Pattern.compile(patronApellidos);

        Matcher matcher = pattern.matcher(clienteDTO.getNombres());

        if (!matcher.matches()) {
            throw new ValidacionDTOException("Campo de nombre inválido (debe ser menor a 50 cáracteres y contener únicamente letras)");
        }

        matcher = pattern2.matcher(clienteDTO.getApellidoPaterno());
        if (!matcher.matches()) {
            throw new ValidacionDTOException("Campo de apellido paterno inválido (debe ser menor a 30 cáracteres y contener únicamente letras)");
        }
        matcher = pattern2.matcher(clienteDTO.getApellidoMaterno());
        if (!matcher.matches()) {
            throw new ValidacionDTOException("Campo de apellido materno inválido (debe ser menor a 30 cáracteres y contener únicamente letras)");
        }
    }

    /**
     * Valida los campos relacionados con los datos de cuenta de un cliente
     * recibidos en un objeto ClienteNuevoDTO.
     * 
     * @param clienteDTO Objeto ClienteNuevoDTO que contiene los datos de cuenta del cliente a validar.
     * @throws ValidacionDTOException Si los datos de cuenta no cumplen con los criterios de validación.
     */
    public void validaSeccionDatosCuenta(ClienteNuevoDTO clienteDTO) throws ValidacionDTOException {
        String cadenaUsuario = "^[a-zA-Z0-9]{1,30}$";
        String cadenaContraseña = "^[\\S]{1,20}$";

        Pattern patronUsuario = Pattern.compile(cadenaUsuario);
        Pattern patronContraseña = Pattern.compile(cadenaContraseña);

        // Verifica el campo de usuario
        Matcher matcher = patronUsuario.matcher(clienteDTO.getUsuario());
        if (!matcher.matches()) {
            throw new ValidacionDTOException("Nombre de usuario inválido (debe ser menor a 30 cáracteres usando solo letras y números)");
        }

        // Verifica el campo de contraseña
        matcher = patronContraseña.matcher(clienteDTO.getContrasena());
        if (!matcher.matches()) {
            throw new ValidacionDTOException("Contraseña inválida (debe contar con máximo 20 cáracteres)");
        }

    }

     /**
     * Valida los campos relacionados con los datos de domicilio recibidos en
     * un objeto DomicilioNuevoDTO.
     * 
     * @param domicilioDTO Objeto DomicilioNuevoDTO que contiene los datos de domicilio a validar.
     * @throws ValidacionDTOException Si los datos de domicilio no cumplen con los criterios de validación.
     */
    public void validaSeccionDatosDomicilio(DomicilioNuevoDTO domicilioDTO) throws ValidacionDTOException {
        String cadenaCalle = extensionCadena(50);
        String cadenaCiudad = extensionCadena(20);
        String cadenaNumExterior = "^[a-zA-Z0-9]{1,10}$";
        String cadenaCodigoPostal = "^[0-9]{5}$";

        Pattern patronCalle = Pattern.compile(cadenaCalle);
        Pattern patronCiudad = Pattern.compile(cadenaCiudad);
        Pattern patronNumExterior = Pattern.compile(cadenaNumExterior);
        Pattern patronCodigoPostal = Pattern.compile(cadenaCodigoPostal);

        // Verifica el campo calle
        Matcher matcher = patronCalle.matcher(domicilioDTO.getCalle());
        if (!matcher.matches()) {
            throw new ValidacionDTOException("Campo de calle inválido (debe ser menor a 50 caracteres y contener letras)");
        }
        //Verifica el campo de colonia
        matcher = patronCalle.matcher(domicilioDTO.getColonia());
        if (!matcher.matches()) {
            throw new ValidacionDTOException("Campo de colonia inválido (debe ser menor a 50 caracteres y contener letras)");
        }
        //Verifica el campo de ciudad
        matcher = patronCiudad.matcher(domicilioDTO.getCiudad());
        if (!matcher.matches()) {
            throw new ValidacionDTOException("Campo de ciudad inválido (debe ser menor a 20 caracteres y contener letras)");
        }

        //Verifica el campo de numero exterior
        matcher = patronNumExterior.matcher(domicilioDTO.getNumeroExterior());
        if (!matcher.matches()) {
            throw new ValidacionDTOException("Campo de número exterior inválido (debe ser menor a 10 caracteres y contener exclusivamente letras o números)");
        }

        //Verifica el campo de codigo postal
        matcher = patronCodigoPostal.matcher(domicilioDTO.getCodigoPostal());
        if (!matcher.matches()) {
            throw new ValidacionDTOException("Campo de código postal inválido (debe ser de 5 caracteres y contener exclusivamente números)");
        }

    }
    
    /**
     * Valida los campos relacionados con una nueva cuenta recibidos en un
     * objeto CuentaNuevaDTO.
     * 
     * @param cuentaDTO Objeto CuentaNuevaDTO que contiene los datos de la nueva cuenta a validar.
     * @throws ValidacionDTOException Si los datos de la nueva cuenta no cumplen con los criterios de validación.
     */
    public void validaCuenta(CuentaNuevaDTO cuentaDTO) throws ValidacionDTOException {
        String cadenaNombreCuenta = "^[a-zA-Z0-9\\s]{1,15}$";
        String cadenaSaldoCuenta = "^[\\d]{1,5}([.][\\d]{1,2})?$";

        Pattern patronCalle = Pattern.compile(cadenaNombreCuenta);
        Pattern patronSaldo = Pattern.compile(cadenaSaldoCuenta);

        // Verifica el campo calle
        Matcher matcher = patronCalle.matcher(cuentaDTO.getNombreCuenta());
        if (!matcher.matches()) {
            throw new ValidacionDTOException("Campo de nombre de cuenta inválido (debe ser menor a 16 caracteres y contener letras o números)");
        }
        matcher = patronSaldo.matcher(cuentaDTO.getSaldo());
        if (!matcher.matches()) {
            throw new ValidacionDTOException("Formato de saldo inválido, no se aceptan numeros negativos o cualquier otro simbolo formato deseado Ejemplo: 00000.00");
        }
        
        double saldo = Double.parseDouble(cuentaDTO.getSaldo());
        if(saldo > 10000 || saldo < 100){
            throw new ValidacionDTOException("El saldo máximo posible a agregar es de $10,000.00 MXN y el minimo son $100.00 MXN");

        }
    }

    /**
     * Genera un patrón de expresión regular para validar la longitud de una cadena.
     * 
     * @param longitud La longitud máxima permitida para la cadena.
     * @return Un patrón de expresión regular para validar la longitud de una cadena.
     */
    private String extensionCadena(int longitud) {
        return "^[a-zA-Z\\s]{1," + longitud + "}$";
    }
    
    
}
