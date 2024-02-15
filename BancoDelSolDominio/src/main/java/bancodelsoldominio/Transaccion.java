package bancodelsoldominio;

import java.util.Objects;

/**
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class Transaccion {
    private Long idTransaccion;
    private String fecha;
    private double monto;
    private Long idCuenta;

    public Transaccion() {
    }

    public Transaccion(String fecha, double monto, Long idCuenta) {
        this.fecha = fecha;
        this.monto = monto;
        this.idCuenta = idCuenta;
    }

    public Transaccion(Long idTransaccion, String fecha, double monto, Long idCuenta) {
        this.idTransaccion = idTransaccion;
        this.fecha = fecha;
        this.monto = monto;
        this.idCuenta = idCuenta;
    }

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

    public Long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Long getIdTransaccion() {
        return idTransaccion;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.idTransaccion);
        return hash;
    }
    
    

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
