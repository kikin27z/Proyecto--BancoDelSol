package bancodelsol.dtos;

import bancodelsolpersistencia.excepciones.ValidacionDTOException;

/**
 * Clase que representa un DTO (Data Transfer Object) para una nueva transferencia.
 * Contiene información sobre la fecha, monto, motivo y cuenta de destino de la transferencia.
 * Además, implementa un método para validar los datos de la transferencia.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class TransferenciaNuevaDTO {
    private String fecha;
    private String montoCadena;
    private double monto;
    private String motivo;
    private Long idCuenta;
    private String cuentaDestino;

     /**
     * Obtiene la fecha de la transferencia.
     * @return La fecha de la transferencia.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la transferencia.
     * @param fecha La fecha de la transferencia.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el monto de la transferencia.
     * @return El monto de la transferencia.
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Establece el monto de la transferencia.
     * @param monto El monto de la transferencia.
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    /**
     * Obtiene el motivo de la transferencia.
     * @return El motivo de la transferencia.
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Obtiene el monto de la transferencia.
     * @return El monto de la transferencia.
     */
    public String getMontoCadena() {
        return montoCadena;
    }

    /**
     * Establece el monto de la transferencia.
     * @param montoCadena  El monto de la transferencia.
     */
    public void setMontoCadena(String montoCadena) {
        this.montoCadena = montoCadena;
    }

    /**
     * Obtiene el id de la cuenta que realizo la transferencia.
     */
    public Long getIdCuenta() {
        return idCuenta;
    }

    /**
     * Establece el id de la cuenta que realizo la transferencia.
     * @param idCuenta  El id de la cuenta que realizo la transferencia.
     */
    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }
    
    

    /**
     * Establece el motivo de la transferencia.
     * @param motivo El motivo de la transferencia.
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Obtiene el número de cuenta destino de la transferencia.
     * @return El número de cuenta destino de la transferencia.
     */
    public String getCuentaDestino() {
        return cuentaDestino;
    }

    /**
     * Establece el número de cuenta destino de la transferencia.
     * @param cuentaDestino El número de cuenta destino de la transferencia.
     */
    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }
    
    /**
     * Verifica que los datos de la transferencia sean válidos.
     * @throws ValidacionDTOException Si algún dato de la transferencia es inválido o vacio.
     */
    public void esValido() throws ValidacionDTOException {
        if (this.motivo == null || this.motivo.isBlank() || this.motivo.length() > 50) {
            throw new ValidacionDTOException("Motivo de la transferencia inválida, no debe superar los 50 caracteres");

        }
        try {
            this.monto = Double.parseDouble(this.montoCadena);
            if(monto <= 0 ){
                throw new ValidacionDTOException("El monto debe ser mayor a 0");
            }
        } catch (NumberFormatException e) {
            throw new ValidacionDTOException("El campo de monto no es un número");
        }
    }
}
