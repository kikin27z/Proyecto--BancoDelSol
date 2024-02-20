package bancodelsoldominio;

import java.util.Objects;

/**
 * Representa una transacción de transferencia en el sistema bancario.
 * Extiende la clase Transaccion y agrega campos específicos para la transferencia, como el motivo y la cuenta de destino.
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class Transferencia extends Transaccion{
    private Long idTransferencia;
    private String motivo;
    private String cuentaDestino;

    /**
     * Constructor por defecto de la clase Transferencia.
     */
    public Transferencia() {
    }

    /**
     * Constructor de la clase Transferencia que inicializa los campos de la transferencia y de la transacción.
     * @param motivo El motivo de la transferencia.
     * @param cuentaDestino La cuenta de destino de la transferencia.
     * @param idTransaccion El identificador único de la transacción.
     * @param fecha La fecha de la transacción.
     * @param monto El monto de la transacción.
     * @param tipo el tipo de transacción.
     * @param idTransferencia  El identificador único de la transferencia.
     * @param idCuenta El identificador único de la cuenta asociada a la transacción.
     */
    public Transferencia(String motivo, String cuentaDestino, String fecha, double monto,String tipo, Long idTransaccion,Long idTransferencia, Long idCuenta) {
        super(idTransaccion, fecha, monto,tipo, idCuenta);
        this.motivo = motivo;
        this.cuentaDestino = cuentaDestino;
        this.idTransferencia = idTransferencia;
    }

    /**
     * Obtiene el motivo de la transferencia.
     * @return El motivo de la transferencia.
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Establece el motivo de la transferencia.
     * @param motivo El nuevo motivo de la transferencia.
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Obtiene la cuenta de destino de la transferencia.
     * @return La cuenta de destino de la transferencia.
     */
    public String getCuentaDestino() {
        return cuentaDestino;
    }

    /**
     * Establece la cuenta de destino de la transferencia.
     * @param cuentaDestino La nueva cuenta de destino de la transferencia.
     */
    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

     /**
     * Obtiene el identificador de la transferencia.
     * @return El identificador de la transferencia.
     */
    public Long getIdTransferencia() {
        return idTransferencia;
    }

    /**
     * Establece el identificador de la transferencia.
     * @param idTransferencia  El identificador de la transferencia.
     */
    public void setIdTransferencia(Long idTransferencia) {
        this.idTransferencia = idTransferencia;
    }
    
    
    

    /**
     * Calcula el hash code de la transferencia.
     * @return El hash code de la transferencia.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.idTransferencia);
        return hash;
    }

    /**
     * Compara si esta transferencia es igual a otro objeto dado.
     * @param obj El objeto a comparar.
     * @return true si esta transferencia es igual al objeto dado, false en caso contrario.
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
        final Transferencia other = (Transferencia) obj;
        return Objects.equals(this.idTransferencia, other.idTransferencia);
    }

    /**
     * Devuelve una representación en formato de cadena de la transferencia.
     * @return Una cadena que representa la transferencia.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transferencia{");
        sb.append("id=").append(idTransferencia);
        sb.append(", motivo=").append(motivo);
        sb.append(", cuentaDestino=").append(cuentaDestino);
        sb.append('}');
        return sb.toString();
    }
    
    
}
