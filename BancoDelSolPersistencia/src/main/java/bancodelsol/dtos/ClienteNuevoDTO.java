package bancodelsol.dtos;

import bancodelsolpersistencia.excepciones.ValidacionDTOException;

/**
 * Esta clase representa un DTO (Data Transfer Object) para un cliente nuevo.
 * Contiene información básica sobre el cliente, como nombres, apellidos, fecha de nacimiento, usuario y contraseña.
 * También incluye un método para verificar la validez de los datos ingresados.
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

    /**
     * Obtiene los nombres del cliente.
     * @return Los nombres del cliente.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece los nombres del cliente.
     * @param nombres Los nombres del cliente.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtiene el apellido paterno del cliente.
     * @return El apellido paterno del cliente.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del cliente.
     * @param apellidoPaterno El apellido paterno del cliente.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del cliente.
     * @return El apellido materno del cliente.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del cliente.
     * @param apellidoMaterno El apellido materno del cliente.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene la fecha de nacimiento del cliente.
     * @return La fecha de nacimiento del cliente.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de nacimiento del cliente.
     * @param fecha La fecha de nacimiento del cliente.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el nombre de usuario del cliente.
     * @return El nombre de usuario del cliente.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario del cliente.
     * @param usuario El nombre de usuario del cliente.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la contraseña del cliente.
     * @return La contraseña del cliente.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del cliente.
     * @param contrasena La contraseña del cliente.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    /**
     * Verifica que todos los campos de la sección de datos personales no estén vacíos o solo existan espacios en blanco
     * @return Devuelve true si todos los campos son válidos y no son solo 
     * espacios en blanco.
     * @throws ValidacionDTOException   Si algún dato del cliente es inválido o vacio.
     */
    public boolean esValido() throws ValidacionDTOException {
        if (this.nombres == null || this.nombres.isBlank()
                || this.apellidoPaterno == null || this.apellidoPaterno.isBlank()
                || this.apellidoMaterno == null || this.apellidoMaterno.isBlank()
                || this.fecha == null || this.fecha.isBlank()) {
            throw new ValidacionDTOException("Llene todos los campos");
        }
        return true;
    }
    /**
     * Verifica que todos los campos de la sección de la cuenta no estén vacíos o solo existan espacios en blanco
     * @return Devuelve true si todos los campos son válidos y no son solo 
     * espacios en blanco.
     * @throws ValidacionDTOException Si algún dato del cliente es inválido o vacio.
     */
    public boolean esValido2() throws ValidacionDTOException{
        if (this.usuario == null || this.usuario.isBlank()
                || this.contrasena == null || this.contrasena.isBlank()) {
            throw new ValidacionDTOException("Llene todos los campos");
        }
        
        return true;
    }
}
