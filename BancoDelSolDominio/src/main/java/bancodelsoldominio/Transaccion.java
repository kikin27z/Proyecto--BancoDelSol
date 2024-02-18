package bancodelsoldominio;

import java.util.Objects;

/**
 * Representa una transacción bancaria.
 * Esta clase almacena información sobre una transacción bancaria,
 * incluyendo su fecha, monto y el ID de la cuenta asociada.
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class Transaccion {
    private Long idTransaccion;
    private String fecha;
    private double monto;
    private Long idCuenta;

    /**
     * Constructor por defecto de la clase Transaccion.
     */
    public Transaccion() {
    }

    /**
     * Constructor de la clase Transaccion que inicializa la fecha, el monto y el ID de la cuenta asociada.
     * @param fecha La fecha de la transacción.
     * @param monto El monto de la transacción.
     * @param idCuenta El ID de la cuenta asociada a la transacción.
     */
    public Transaccion(String fecha, double monto, Long idCuenta) {
        this.fecha = fecha;
        this.monto = monto;
        this.idCuenta = idCuenta;
    }

    /**
     * Constructor de la clase Transaccion que inicializa todos los campos.
     * @param idTransaccion El identificador único de la transacción.
     * @param fecha La fecha de la transacción.
     * @param monto El monto de la transacción.
     * @param idCuenta El ID de la cuenta asociada a la transacción.
     */
    public Transaccion(Long idTransaccion, String fecha, double monto, Long idCuenta) {
        this.idTransaccion = idTransaccion;
        this.fecha = fecha;
        this.monto = monto;
        this.idCuenta = idCuenta;
    }

    /**
     * Obtiene la fecha de la transacción.
     * @return La fecha de la transacción.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la transacción.
     * @param fecha La nueva fecha de la transacción.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el monto de la transacción.
     * @return El monto de la transacción.
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Establece el monto de la transacción.
     * @param monto El nuevo monto de la transacción.
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * Obtiene el ID de la cuenta asociada a la transacción.
     * @return El ID de la cuenta asociada a la transacción.
     */
    public Long getIdCuenta() {
        return idCuenta;
    }

    /**
     * Establece el ID de la cuenta asociada a la transacción.
     * @param idCuenta El nuevo ID de la cuenta asociada a la transacción.
     */
    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }

    /**
     * Obtiene el identificador único de la transacción.
     * @return El identificador único de la transacción.
     */
    public Long getIdTransaccion() {
        return idTransaccion;
    }
    
    
    /**
     * Calcula el hash code de la transacción.
     * @return El hash code de la transacción.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.idTransaccion);
        return hash;
    }
    
    
    /**
     * Compara si esta transacción es igual a otro objeto dado.
     * @param obj El objeto a comparar.
     * @return true si esta transacción es igual al objeto dado, false en caso contrario.
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
        final Transaccion other = (Transaccion) obj;
        return Objects.equals(this.idTransaccion, other.idTransaccion);
    }

    /**
     * Devuelve una representación en formato de cadena de la transacción.
     * @return Una cadena que representa la transacción.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaccion{");
        sb.append("id=").append(idTransaccion);
        sb.append(", fecha=").append(fecha);
        sb.append(", monto=").append(monto);
        sb.append(", idCuenta=").append(idCuenta);
        sb.append('}');
        return sb.toString();
    }
    
    
}
