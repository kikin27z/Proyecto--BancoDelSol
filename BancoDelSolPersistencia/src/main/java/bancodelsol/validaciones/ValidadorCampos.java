package bancodelsol.validaciones;

import bancodelsol.dtos.ClienteNuevoDTO;
import bancodelsol.dtos.CuentaNuevaDTO;
import bancodelsol.dtos.DomicilioNuevoDTO;
import bancodelsolpersistencia.excepciones.TransaccionException;
import bancodelsolpersistencia.excepciones.ValidacionDTOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que proporciona métodos para validar los campos de diferentes DTOs
 * utilizados en la aplicación. Los métodos de esta clase lanzan excepciones de
 * tipo ValidacionDTOException en caso de que los datos proporcionados no
 * cumplan con los criterios de validación especificados.
 *
 * Esta clase realiza validaciones como: - Longitud máxima y tipo de caracteres
 * permitidos en nombres, apellidos, usuario, contraseña, calle, ciudad,
 * colonia, número exterior, código postal, nombre de cuenta y saldo. - Formato
 * de contraseña y saldo. - Rango de valores para el saldo de una cuenta.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class ValidadorCampos {

    /**
     * Valida los campos relacionados con los datos personales de un cliente
     * recibidos en un objeto ClienteNuevoDTO.
     *
     * @param clienteDTO Objeto ClienteNuevoDTO que contiene los datos
     * personales del cliente a validar.
     * @throws ValidacionDTOException Si los datos personales no cumplen con los
     * criterios de validación.
     */
    public void validaSeccionDatosPersonales(ClienteNuevoDTO clienteDTO) throws ValidacionDTOException {
        String patronNombre = extensionCadena(50);
        String patronApellidos = extensionCadena(30);
        Pattern pattern = Pattern.compile(patronNombre);
        Pattern pattern2 = Pattern.compile(patronApellidos);
//        Calendar fechaNacimiento = Calendar.getInstance();
//        Calendar fechaMenos18 = Calendar.getInstance();
//        Calendar fechaMas120 = Calendar.getInstance();

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
//        fechaMenos18.setTime(new Date());
//        fechaMenos18.add(Calendar.YEAR, -18);
//        fechaMas120.setTime(new Date());
//        fechaMas120.add(Calendar.YEAR, -120);
//        fechaNacimiento.setTime(obtenerFecha(clienteDTO.getFecha()));
//        if (fechaNacimiento.getTimeInMillis() > fechaMenos18.getTimeInMillis()) {
//            throw new ValidacionDTOException("Campo de fecha inválido (debes ser mayor de edad)");
//        }

    }

    /**
     * Valida los campos relacionados con los datos de cuenta de un cliente
     * recibidos en un objeto ClienteNuevoDTO.
     *
     * @param clienteDTO Objeto ClienteNuevoDTO que contiene los datos de cuenta
     * del cliente a validar.
     * @throws ValidacionDTOException Si los datos de cuenta no cumplen con los
     * criterios de validación.
     */
//    public void validaSeccionDatosCuenta(ClienteNuevoDTO clienteDTO) throws ValidacionDTOException {
//        String cadenaUsuario = "^[a-zA-Z0-9]{1,30}$";
//        String cadenaContraseña = "^[\\S]{1,20}$";
//
//        Pattern patronUsuario = Pattern.compile(cadenaUsuario);
//        Pattern patronContraseña = Pattern.compile(cadenaContraseña);
//
//        // Verifica el campo de usuario
//        Matcher matcher = patronUsuario.matcher(clienteDTO.getUsuario());
//        if (!matcher.matches()) {
//            throw new ValidacionDTOException("Nombre de usuario inválido (debe ser menor a 30 cáracteres usando solo letras y números)");
//        }
//
//        // Verifica el campo de contraseña
//        matcher = patronContraseña.matcher(clienteDTO.getContrasena());
//        if (!matcher.matches()) {
//            throw new ValidacionDTOException("Contraseña inválida (debe contar con máximo 20 cáracteres)");
//        }
//
//    }

    public void validaSeccionDatosCuenta(String usuario, String contrasena) throws ValidacionDTOException {
        String cadenaUsuario = "^[a-zA-Z0-9]{1,30}$";
        String cadenaContrasena = "^[\\S]{1,20}$";

        Pattern patronUsuario = Pattern.compile(cadenaUsuario);
        Pattern patronContrasena = Pattern.compile(cadenaContrasena);

        // Verifica el campo de usuario
        Matcher matcherUsuario = patronUsuario.matcher(usuario);
        if (!matcherUsuario.matches()) {
            throw new ValidacionDTOException("Nombre de usuario inválido (debe ser menor a 30 caracteres usando solo letras y números)");
        }

        // Verifica el campo de contraseña
        Matcher matcherContrasena = patronContrasena.matcher(contrasena);
        if (!matcherContrasena.matches()) {
            throw new ValidacionDTOException("Contraseña inválida (debe contar con máximo 20 caracteres)");
        }
    }

    /**
     * Valida los campos relacionados con los datos de domicilio recibidos en un
     * objeto DomicilioNuevoDTO.
     *
     * @param domicilioDTO Objeto DomicilioNuevoDTO que contiene los datos de
     * domicilio a validar.
     * @throws ValidacionDTOException Si los datos de domicilio no cumplen con
     * los criterios de validación.
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

    public Date obtenerFecha(String fecha) {
        String format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(ValidadorCampos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }

    /**
     * Valida los campos relacionados con una nueva cuenta recibidos en un
     * objeto CuentaNuevaDTO.
     *
     * @param cuentaDTO Objeto CuentaNuevaDTO que contiene los datos de la nueva
     * cuenta a validar.
     * @throws ValidacionDTOException Si los datos de la nueva cuenta no cumplen
     * con los criterios de validación.
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
        if (saldo > 10000 || saldo < 100) {
            throw new ValidacionDTOException("El saldo máximo posible a agregar es de $10,000.00 MXN y el minimo son $100.00 MXN");

        }
    }

    /**
     * Genera un patrón de expresión regular para validar la longitud de una
     * cadena.
     *
     * @param longitud La longitud máxima permitida para la cadena.
     * @return Un patrón de expresión regular para validar la longitud de una
     * cadena.
     */
    private String extensionCadena(int longitud) {
        return "^[a-zA-Z\\s]{1," + longitud + "}$";
    }

    /**
     * Valida los número de cuenta.
     *
     * @param numeroCuenta Número de cuenta de una cuenta.
     * @throws ValidacionDTOException Si los datos del número de cuenta no
     * cumplen con los criterios de validación.
     */
    public void validaNumeroCuenta(String numeroCuenta) throws ValidacionDTOException {
        if (numeroCuenta.length() != 9) {
            throw new ValidacionDTOException("El número de cuenta debe ser 9 números iniciando con el prefijo \"2710\"");
        }

        String cadenaNumeroCuenta = "^2710[\\d]{5}$";

        Pattern patronNumeroCuenta = Pattern.compile(cadenaNumeroCuenta);

        // Verifica el campo calle
        Matcher matcher = patronNumeroCuenta.matcher(numeroCuenta);
        if (!matcher.matches()) {
            throw new ValidacionDTOException("Número de cuenta inválido debe iniciar con el prefijo \"2710\" y luego 5 digitos");
        }
    }

    public void validaGenerarRetiro(String monto) throws TransaccionException {
        String cadenaMonto = "^[0-9]{1,6}(\\.[0-9]{1,2})?$";
        Pattern patronMonto = Pattern.compile(cadenaMonto);
        Matcher matcher = patronMonto.matcher(monto);
        if (!matcher.matches()) {
            throw new TransaccionException("El campo de monto solo debe contener números");
        }

    }
}
