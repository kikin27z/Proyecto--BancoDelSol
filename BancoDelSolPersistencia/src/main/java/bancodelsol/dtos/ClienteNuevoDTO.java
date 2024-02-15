package bancodelsol.dtos;

import bancodelsolpersistencia.excepciones.ValidacionDTOException;

/**
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class ClienteNuevoDTO {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fecha;
    private String usuario;
    private String contrasena;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public boolean esValido() throws ValidacionDTOException {
        if (this.nombres == null || this.nombres.isBlank() || this.nombres.length() > 50) {
            throw new ValidacionDTOException("Llene el campo de nombre menos de 50 caracteres");

        }
        if(this.apellidoPaterno == null || this.apellidoPaterno.isBlank() || this.apellidoPaterno.trim().length() > 30 ){
            throw new ValidacionDTOException("Campo apellido paterno inválido"); 
        }
        if(this.apellidoMaterno == null || this.apellidoMaterno.isBlank() || this.apellidoMaterno.trim().length() > 30 ){
            throw new ValidacionDTOException("Campo apellido materno inválido"); 
        }
        
        if(this.usuario == null || this.usuario.isBlank() || this.usuario.trim().length() > 30 ){
            throw new ValidacionDTOException("Campo usuario es inválido"); 
        }
        if(this.contrasena == null || this.contrasena.isBlank() || this.contrasena.trim().length() > 20 ){
            throw new ValidacionDTOException("Campo contrasena es inválido"); 
        }
        
        return true;

    }
}
