package bancodelsoldominio;

import java.util.Objects;

/**
 * Representa una cuenta bancaria.
 * Esta clase almacena información sobre una cuenta bancaria,
 * incluyendo su fecha de apertura, nombre, número, saldo y el ID del cliente asociado.
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class Cuenta {
    private Long idCuenta;
    private String fechaApertura;
    private String nombreCuenta;
    private String numeroCuenta;
    private double saldo;
    private Long idCliente;

    /**
     * Constructor por defecto de la clase Cuenta.
     */
    public Cuenta() {
    }

    /**
     * Constructor de la clase Cuenta que inicializa la fecha de apertura,
     * el nombre de la cuenta, el número de cuenta y el saldo.
     * @param fechaApertura La fecha de apertura de la cuenta.
     * @param nombreCuenta El nombre de la cuenta.
     * @param numeroCuenta El número de la cuenta.
     * @param saldo El saldo de la cuenta.
     */
    public Cuenta(String fechaApertura, String nombreCuenta, String numeroCuenta, double saldo) {
        this.fechaApertura = fechaApertura;
        this.nombreCuenta = nombreCuenta;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    /**
     * Constructor de la clase Cuenta que inicializa la fecha de apertura,
     * el nombre de la cuenta, el número de cuenta, el saldo y el ID del cliente asociado.
     * @param fechaApertura La fecha de apertura de la cuenta.
     * @param nombreCuenta El nombre de la cuenta.
     * @param numeroCuenta El número de la cuenta.
     * @param saldo El saldo de la cuenta.
     * @param idCliente El ID del cliente asociado a la cuenta.
     */
    public Cuenta(String fechaApertura, String nombreCuenta, String numeroCuenta, double saldo, Long idCliente) {
        this.fechaApertura = fechaApertura;
        this.nombreCuenta = nombreCuenta;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.idCliente = idCliente;
    }
    
    /**
     * Constructor de la clase Cuenta que inicializa todos los campos.
     * @param idCuenta El identificador único de la cuenta.
     * @param fechaApertura La fecha de apertura de la cuenta.
     * @param nombreCuenta El nombre de la cuenta.
     * @param numeroCuenta El número de la cuenta.
     * @param saldo El saldo de la cuenta.
     * @param idCliente El ID del cliente asociado a la cuenta.
     */
    public Cuenta(Long idCuenta, String fechaApertura, String nombreCuenta, String numeroCuenta, double saldo, Long idCliente) {
        this.idCuenta = idCuenta;
        this.fechaApertura = fechaApertura;
        this.nombreCuenta = nombreCuenta;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.idCliente = idCliente;
    }
    
    
    /**
     * Obtiene la fecha de apertura de la cuenta.
     * @return La fecha de apertura de la cuenta.
     */
    public String getFechaApertura() {
        return fechaApertura;
    }

    /**
     * Establece la fecha de apertura de la cuenta.
     * @param fechaApertura La nueva fecha de apertura de la cuenta.
     */
    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    /**
     * Obtiene el número de la cuenta.
     * @return El número de la cuenta.
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Establece el número de la cuenta.
     * @param numeroCuenta El nuevo número de la cuenta.
     */
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * Obtiene el saldo de la cuenta.
     * @return El saldo de la cuenta.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Establece el saldo de la cuenta.
     * @param saldo El nuevo saldo de la cuenta.
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Obtiene el ID del cliente asociado a la cuenta.
     * @return El ID del cliente asociado a la cuenta.
     */
    public Long getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el ID del cliente asociado a la cuenta.
     * @param idCliente El nuevo ID del cliente asociado a la cuenta.
     */
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Obtiene el nombre de la cuenta.
     * @return El nombre de la cuenta.
     */
    public String getNombreCuenta() {
        return nombreCuenta;
    }

    /**
     * Establece el nombre de la cuenta.
     * @param nombreCuenta El nuevo nombre de la cuenta.
     */
    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }
    
    
    /**
     * Calcula el hash code de la cuenta.
     * @return El hash code de la cuenta.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.idCuenta);
        return hash;
    }

    /**
     * Compara si esta cuenta es igual a otro objeto dado.
     * @param obj El objeto a comparar.
     * @return true si esta cuenta es igual al objeto dado, false en caso contrario.
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
        final Cuenta other = (Cuenta) obj;
        return Objects.equals(this.idCuenta, other.idCuenta);
    }

    /**
     * Devuelve una representación en formato de cadena de la cuenta.
     * @return Una cadena que representa la cuenta.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuenta{");
        sb.append("idCuenta=").append(idCuenta);
        sb.append(", fechaApertura=").append(fechaApertura);
        sb.append(", nombreCuenta=").append(nombreCuenta);
        sb.append(", numeroCuenta=").append(numeroCuenta);
        sb.append(", saldo=").append(saldo);
        sb.append(", idCliente=").append(idCliente);
        sb.append('}');
        return sb.toString();
    }

   
    
    
    
}
