package bancodelsol.dtos;

/**
 * Representa un objeto de transferencia de datos (DTO) para una nueva cuenta.
 * Esta clase almacena información sobre una nueva cuenta bancaria,
 * incluyendo su número, nombre, saldo, fecha de apertura y el ID del cliente asociado.
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class CuentaNuevaDTO {
    private String numeroCuenta;
    private String nombreCuenta;
    private double saldo;
    private String fechaApertura;
    private Long idCliente;

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
}
