package bancodelsol.validaciones;

import bancodelsol.dtos.ClienteNuevoDTO;
import bancodelsol.dtos.DomicilioNuevoDTO;
import bancodelsolpersistencia.excepciones.ValidacionDTOException;
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



    private String extensionCadena(int longitud) {
        return "^[a-zA-Z\\s]{1," + longitud + "}$";
    }
}
