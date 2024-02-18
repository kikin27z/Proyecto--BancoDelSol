package bancodelsol.validaciones;

import bancodelsol.dtos.ClienteNuevoDTO;
import bancodelsol.dtos.DomicilioNuevoDTO;
import bancodelsolpersistencia.excepciones.ValidacionDTOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author karim
 */
public class ValidadorCampos {

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

    private String extensionCadena(int longitud) {
        return "^[a-zA-Z\\s]{1," + longitud + "}$";
    }
}
