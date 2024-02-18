package bancodelsoldominio;

import java.util.Objects;

/**
 * Representa un domicilio asociado a un cliente.
 * Esta clase almacena información sobre un domicilio, incluyendo la calle,
 * colonia, número exterior, código postal, ciudad y el ID del cliente asociado.
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class Domicilio {
    private Long idDomicilio;
    private String calle;
    private String colonia;
    private String numeroExterior;
    private String codigoPostal;
    private String ciudad;
    private Long idCliente;

    /**
     * Constructor por defecto de la clase Domicilio.
     */
    public Domicilio() {
    }

    /**
     * Constructor de la clase Domicilio que inicializa todos los campos excepto el ID del domicilio.
     * @param calle La calle del domicilio.
     * @param colonia La colonia del domicilio.
     * @param numeroExterior El número exterior del domicilio.
     * @param codigoPostal El código postal del domicilio.
     * @param ciudad La ciudad del domicilio.
     * @param idCliente El ID del cliente asociado al domicilio.
     */
    public Domicilio(String calle, String colonia, String numeroExterior, String codigoPostal, String ciudad, Long idCliente) {
        this.calle = calle;
        this.colonia = colonia;
        this.numeroExterior = numeroExterior;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.idCliente = idCliente;
    }

    /**
     * Constructor de la clase Domicilio que inicializa todos los campos.
     * @param idDomicilio El identificador único del domicilio.
     * @param calle La calle del domicilio.
     * @param colonia La colonia del domicilio.
     * @param numeroExterior El número exterior del domicilio.
     * @param codigoPostal El código postal del domicilio.
     * @param ciudad La ciudad del domicilio.
     * @param idCliente El ID del cliente asociado al domicilio.
     */
    public Domicilio(Long idDomicilio, String calle, String colonia, String numeroExterior, String codigoPostal, String ciudad, Long idCliente) {
        this.idDomicilio = idDomicilio;
        this.calle = calle;
        this.colonia = colonia;
        this.numeroExterior = numeroExterior;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.idCliente = idCliente;
    }

    /**
     * Obtiene la calle del domicilio.
     * @return La calle del domicilio.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle del domicilio.
     * @param calle La nueva calle del domicilio.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene la colonia del domicilio.
     * @return La colonia del domicilio.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece la colonia del domicilio.
     * @param colonia La nueva colonia del domicilio.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Obtiene el número exterior del domicilio.
     * @return El número exterior del domicilio.
     */
    public String getNumeroExterior() {
        return numeroExterior;
    }

    /**
     * Establece el número exterior del domicilio.
     * @param numeroExterior El nuevo número exterior del domicilio.
     */
    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    /**
     * Obtiene el código postal del domicilio.
     * @return El código postal del domicilio.
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Establece el código postal del domicilio.
     * @param codigoPostal El nuevo código postal del domicilio.
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Obtiene la ciudad del domicilio.
     * @return La ciudad del domicilio.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad del domicilio.
     * @param ciudad La nueva ciudad del domicilio.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene el ID del cliente asociado al domicilio.
     * @return El ID del cliente asociado al domicilio.
     */
    public Long getIdCliente() {
        return idCliente;
    }

    /**
     * Calcula el hash code del domicilio.
     * @return El hash code del domicilio.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.idDomicilio);
        return hash;
    }

    /**
     * Compara si este domicilio es igual a otro objeto dado.
     * @param obj El objeto a comparar.
     * @return true si este domicilio es igual al objeto dado, false en caso contrario.
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
        final Domicilio other = (Domicilio) obj;
        return Objects.equals(this.idDomicilio, other.idDomicilio);
    }

    /**
    * Devuelve una representación en formato de cadena del objeto Domicilio.
    * @return Una cadena que representa al objeto Domicilio.
    */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Domicilio{");
        sb.append("idDomicilio=").append(idDomicilio);
        sb.append(", calle=").append(calle);
        sb.append(", colonia=").append(colonia);
        sb.append(", numeroExterior=").append(numeroExterior);
        sb.append(", codigoPostal=").append(codigoPostal);
        sb.append(", ciudad=").append(ciudad);
        sb.append(", idCliente=").append(idCliente);
        sb.append('}');
        return sb.toString();
    }    
}
