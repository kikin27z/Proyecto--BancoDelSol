package bancodelsoldominio;

import java.util.Objects;

/**
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class Retiro extends Transaccion{
    private Long idRetiro;
    private String folio;
    private String contrasena;

    public Retiro() {
    }

    public Retiro(String folio, String contrasena, Long idTransaccion, String fecha, double monto, Long idCuenta) {
        super(idTransaccion, fecha, monto, idCuenta);
        this.folio = folio;
        this.contrasena = contrasena;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.idRetiro);
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
        final Retiro other = (Retiro) obj;
        return Objects.equals(this.idRetiro, other.idRetiro);
    }

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
