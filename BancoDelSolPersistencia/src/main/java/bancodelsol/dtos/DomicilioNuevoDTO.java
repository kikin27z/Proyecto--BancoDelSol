package bancodelsol.dtos;

import bancodelsolpersistencia.excepciones.ValidacionDTOException;

/**
 * Clase que representa un DTO (Data Transfer Object) para un nuevo domicilio.
 * Contiene información básica sobre un domicilio, como calle, colonia, código postal, ciudad y número exterior.
 * También incluye un método para validar los datos del domicilio.
 * Además, implementa un método toString() para representar el objeto como una cadena de texto.
 * 
 * @author José Karim Franco Valencia - 245138
 */
public class DomicilioNuevoDTO {
    private String calle;
    private String colonia;
    private String codigoPostal;
    private String ciudad;
    private String numeroExterior;

    /**
     * Obtiene el nombre de la calle del domicilio.
     * @return El nombre de la calle del domicilio.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece el nombre de la calle del domicilio.
     * @param calle El nombre de la calle del domicilio.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene el nombre de la colonia del domicilio.
     * @return El nombre de la colonia del domicilio.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece el nombre de la colonia del domicilio.
     * @param colonia El nombre de la colonia del domicilio.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
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
     * @param codigoPostal El código postal del domicilio.
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
     * @param ciudad La ciudad del domicilio.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    /**
     * Verifica que todos los campos de la sección de datos personales no estén vacíos o solo existan espacios en blanco
     * @return Devuelve true si todos los campos son válidos y no son solo 
     * espacios en blanco.
     * @throws ValidacionDTOException 
     */
    public boolean esValido() throws ValidacionDTOException {
        if (this.calle == null || this.calle.isBlank()
                || this.colonia == null || this.colonia.isBlank()
                || this.codigoPostal == null || this.codigoPostal.isBlank()
                || this.ciudad == null || this.ciudad.isBlank()
                || this.numeroExterior == null || this.numeroExterior.isBlank()) {
            throw new ValidacionDTOException("Llene todos los campos");
        }
        return true;
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
     * @param numeroExterior El número exterior del domicilio.
     */
    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DomicilioNuevoDTO{");
        sb.append("calle=").append(calle);
        sb.append(", colonia=").append(colonia);
        sb.append(", codigoPostal=").append(codigoPostal);
        sb.append(", ciudad=").append(ciudad);
        sb.append(", numeroExterior=").append(numeroExterior);
        sb.append('}');
        return sb.toString();
    }
    
    
}
