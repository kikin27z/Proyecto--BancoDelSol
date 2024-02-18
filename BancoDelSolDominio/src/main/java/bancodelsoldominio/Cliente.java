package bancodelsoldominio;

import java.util.Objects;

/**
 * Representa un cliente del banco.
 * Esta clase almacena información sobre un cliente,
 * incluyendo su nombre, apellidos, usuario, contraseña, fecha de nacimiento, y un identificador único.
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class Cliente {
    private Long idCliente;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String usuario;
    private String contrasena;
    private String fechaNacimiento;

    /**
     * Constructor por defecto de la clase Cliente.
     */
    public Cliente() {
    }

     /**
     * Constructor de la clase Cliente que inicializa el nombre, apellidos, usuario, contraseña y fecha de nacimiento.
     * @param nombre El nombre del cliente.
     * @param apellidoPaterno El apellido paterno del cliente.
     * @param apellidoMaterno El apellido materno del cliente.
     * @param usuario El nombre de usuario del cliente.
     * @param contrasena La contraseña del cliente.
     * @param fechaNacimiento La fecha de nacimiento del cliente.
     */
    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, String usuario, String contrasena, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Constructor de la clase Cliente que inicializa todos los campos.
     * @param idCliente El identificador único del cliente.
     * @param nombre El nombre del cliente.
     * @param apellidoPaterno El apellido paterno del cliente.
     * @param apellidoMaterno El apellido materno del cliente.
     * @param usuario El nombre de usuario del cliente.
     * @param contrasena La contraseña del cliente.
     * @param fechaNacimiento La fecha de nacimiento del cliente.
     */
    public Cliente(Long idCliente, String nombre, String apellidoPaterno, String apellidoMaterno, String usuario, String contrasena, String fechaNacimiento) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.fechaNacimiento = fechaNacimiento;
    }


   /**
     * Obtiene el identificador único del cliente.
     * @return El identificador único del cliente.
     */
    public Long getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el identificador único del cliente.
     * @param idCliente El nuevo identificador único del cliente.
     */
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Obtiene el nombre del cliente.
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     * @param nombre El nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * @param apellidoPaterno El nuevo apellido paterno del cliente.
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
     * @param apellidoMaterno El nuevo apellido materno del cliente.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
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
     * @param usuario El nuevo nombre de usuario del cliente.
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
     * @param contrasena La nueva contraseña del cliente.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene la fecha de nacimiento del cliente.
     * @return La fecha de nacimiento del cliente.
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del cliente.
     * @param fechaNacimiento La nueva fecha de nacimiento del cliente.
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Calcula el hash code del cliente.
     * @return El hash code del cliente.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idCliente);
        return hash;
    }

    /**
     * Compara si este cliente es igual a otro objeto dado.
     * @param obj El objeto a comparar.
     * @return true si este cliente es igual al objeto dado, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        return Objects.equals(this.idCliente, other.idCliente);
    }

    /**
    * Devuelve una representación en formato de cadena del objeto Cliente.
    * @return Una cadena que representa al objeto Cliente.
    */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("id=").append(idCliente);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellidoPaterno=").append(apellidoPaterno);
        sb.append(", apellidoMaterno=").append(apellidoMaterno);
        sb.append(", usuario=").append(usuario);
        sb.append(", contrasena=").append(contrasena);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append('}');
        return sb.toString();
    }
    
    
}
