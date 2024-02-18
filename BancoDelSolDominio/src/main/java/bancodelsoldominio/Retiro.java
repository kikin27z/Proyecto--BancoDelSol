package bancodelsoldominio;

import java.util.Objects;

/**
 * Representa una transacción de retiro en el sistema bancario.
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class Retiro extends Transaccion{
    private Long idRetiro;
    private String folio;
    private String contrasena;

    /**
     * Constructor por defecto de la clase Retiro.
     */
    public Retiro() {
    }

    /**
     * Constructor de la clase Retiro que inicializa los campos del retiro y de la transacción.
     * @param folio El folio del retiro.
     * @param contrasena La contraseña asociada al retiro.
     * @param idTransaccion El identificador único de la transacción.
     * @param fecha La fecha de la transacción.
     * @param monto El monto de la transacción.
     * @param idCuenta El identificador único de la cuenta asociada a la transacción.
     */
    public Retiro(String folio, String contrasena, Long idTransaccion, String fecha, double monto, Long idCuenta) {
        super(idTransaccion, fecha, monto, idCuenta);
        this.folio = folio;
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el folio del retiro.
     * @return El folio del retiro.
     */
    public String getFolio() {
        return folio;
    }

    /**
     * Establece el folio del retiro.
     * @param folio El nuevo folio del retiro.
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * Obtiene la contraseña asociada al retiro.
     * @return La contraseña asociada al retiro.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña asociada al retiro.
     * @param contrasena La nueva contraseña asociada al retiro.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Calcula el hash code del retiro.
     * @return El hash code del retiro.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.idRetiro);
        return hash;
    }

    /**
     * Compara si este retiro es igual a otro objeto dado.
     * @param obj El objeto a comparar.
     * @return true si este retiro es igual al objeto dado, false en caso contrario.
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
        final Retiro other = (Retiro) obj;
        return Objects.equals(this.idRetiro, other.idRetiro);
    }

    /**
     * Devuelve una representación en formato de cadena del retiro.
     * @return Una cadena que representa el retiro.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Retiro{");
        sb.append("id=").append(idRetiro);
        sb.append(", folio=").append(folio);
        sb.append(", contrasena=").append(contrasena);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
