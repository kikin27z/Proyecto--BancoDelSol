package bancodelsol.extras;

import bancodelsol.dtos.ClienteNuevoDTO;
import bancodelsol.dtos.DomicilioNuevoDTO;
import bancodelsolpersistencia.excepciones.ValidacionDTOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author karim
 */
public class Validador {

    public void validaSeccionDatosPersonales(ClienteNuevoDTO clienteDTO) throws ValidacionDTOException {
//        String patronNombre = "^[a-zA-Z\\s]{1,50}$";
//        String patronApellidos = "^[a-zA-Z\\s]{1,30}$";
        String patronNombre = extensionCadena(50);
        String patronApellidos = extensionCadena(30);
        Pattern pattern = Pattern.compile(patronNombre);
        Pattern pattern2 = Pattern.compile(patronApellidos);

        Matcher matcher = pattern.matcher(clienteDTO.getNombres());

        if (!matcher.matches()) {
            throw new ValidacionDTOException("Campo de nombre inválido (debe ser menor a 50 caracteres y contener letras)");
        }
        
        matcher = pattern2.matcher(clienteDTO.getApellidoPaterno());
        if (!matcher.matches()) {
            throw new ValidacionDTOException("Campo de apellido paterno inválido (debe ser menor a 30 caracteres y contener letras)");
        }
        matcher = pattern2.matcher(clienteDTO.getApellidoMaterno());
        if (!matcher.matches()) {
            throw new ValidacionDTOException("Campo de apellido materno inválido (debe ser menor a 30 caracteres y contener letras)");
        }
    }
    public void validaSeccionDatosCuenta(ClienteNuevoDTO clienteDTO) throws ValidacionDTOException {
        String patronNombre = extensionCadena(50);
        String patronApellidos = extensionCadena(30);
        Pattern pattern = Pattern.compile(patronNombre);
        Pattern pattern2 = Pattern.compile(patronApellidos);

        Matcher matcher = pattern.matcher(clienteDTO.getNombres());

        if (!matcher.matches()) {
            throw new ValidacionDTOException("Campo de nombre inválido (debe ser menor a 50 caracteres y contener letras)");
        }
        
        matcher = pattern2.matcher(clienteDTO.getApellidoPaterno());
        if (!matcher.matches()) {
            throw new ValidacionDTOException("Campo de apellido paterno inválido (debe ser menor a 30 caracteres y contener letras)");
        }
        matcher = pattern2.matcher(clienteDTO.getApellidoMaterno());
        if (!matcher.matches()) {
            throw new ValidacionDTOException("Campo de apellido materno inválido (debe ser menor a 30 caracteres y contener letras)");
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
            throw new ValidacionDTOException("Campo de calle (debe ser menor a 50 caracteres y contener letras)");
        }
        //Verifica el campo de colonia
        matcher = patronCalle.matcher(domicilioDTO.getColonia());
        if (!matcher.matches()) {
            throw new ValidacionDTOException("Campo de colonia (debe ser menor a 50 caracteres y contener letras)");
        }
        //Verifica el campo de ciudad
        matcher = patronCiudad.matcher(domicilioDTO.getCiudad());
        if (!matcher.matches()) {
            throw new ValidacionDTOException("Campo de ciudad (debe ser menor a 20 caracteres y contener letras)");
        }
        
        //Verifica el campo de numero exterior
        matcher = patronNumExterior.matcher(domicilioDTO.getNumeroExterior());
        if (!matcher.matches()) {
            throw new ValidacionDTOException("Campo de número exterior (debe ser menor a 10 caracteres y contener exclusivamente letras o números)");
        }
        
        //Verifica el campo de codigo postal
        matcher = patronCodigoPostal.matcher(domicilioDTO.getCodigoPostal());
        if (!matcher.matches()) {
            throw new ValidacionDTOException("Campo de código postal (debe ser de 5 caracteres y contener exclusivamente números)");
        }
        
    }
    
    private String extensionCadena(int longitud){
        return "^[a-zA-Z\\s]{1,"+longitud+"}$";
    }
}
