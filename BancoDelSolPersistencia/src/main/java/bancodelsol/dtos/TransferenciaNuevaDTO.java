package bancodelsol.dtos;

import bancodelsolpersistencia.excepciones.ValidacionDTOException;

/**
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class TransferenciaNuevaDTO {
    private String fecha;
    private double monto;
     private String motivo;
    private String cuentaDestino;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }
    
    public boolean esValido() throws ValidacionDTOException {
        if (this.motivo == null || this.motivo.isBlank() || this.motivo.length() > 30) {
            throw new ValidacionDTOException("Motivo de la transferencia inválida");

        }
        if(this.cuentaDestino == null || this.cuentaDestino.isBlank() || this.cuentaDestino.trim().length() == 16 ){
            throw new ValidacionDTOException("Número de cuenta destino inválido"); 
        }
        
        if(this.monto < 0){
            throw new ValidacionDTOException("Monto negativo inválido");
        }
        return false;

    }
}
