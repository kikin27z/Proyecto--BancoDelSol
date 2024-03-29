package bancodelsol;

import bancodelsoldominio.Cuenta;
import bancodelsoldominio.Retiro;
import bancodelsolpersistencia.daos.IRetiroDAO;
import bancodelsolpersistencia.daos.ITransaccionDAO;
import bancodelsolpersistencia.daos.RetiroDAO;
import bancodelsolpersistencia.daos.TransaccionDAO;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import bancodelsolpersistencia.excepciones.ValidacionDTOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Panel para realizar un retiro sin cuenta asociada. Permite al usuario
 * ingresar el folio y contraseña para realizar un retiro sin cuenta.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class VistaEfectuarRetiro extends javax.swing.JPanel {

    Cuenta cuenta;
    private final IRetiroDAO retiroDAO;
    private final Ventana ventana;
    private Retiro retiro;
    private final ITransaccionDAO transaccionDAO;

    private boolean retiroValido;

    /**
     * Crea un nuevo panel de VistaGenerarRetiro.
     *
     * @param ventana la ventana de enlace
     */
    public VistaEfectuarRetiro(Ventana ventana) {
        this.ventana = ventana;
        this.cuenta = new Cuenta();
        retiro = new Retiro();
        this.retiroDAO = new RetiroDAO(ventana.getConexion());
        this.transaccionDAO = new TransaccionDAO(ventana.getConexion());
        retiroValido = false;
        ventana.setCuenta(cuenta);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblContrasena = new javax.swing.JLabel();
        txtFolio = new javax.swing.JTextField();
        lblMonto = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JTextField();
        bntAtras = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Amazon Ember", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(149, 120, 64));
        lblTitulo.setText("Realizar retiro sin cuenta");
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 45, -1, -1));

        lblContrasena.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        lblContrasena.setForeground(new java.awt.Color(157, 134, 90));
        lblContrasena.setText("Folio:");
        add(lblContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 117, 80, 24));

        txtFolio.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        txtFolio.setForeground(new java.awt.Color(143, 143, 143));
        txtFolio.setBorder(null);
        add(txtFolio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 400, 36));

        lblMonto.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        lblMonto.setForeground(new java.awt.Color(157, 134, 90));
        lblMonto.setText("Contraseña:");
        add(lblMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 208, 150, 24));

        txtContraseña.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        txtContraseña.setForeground(new java.awt.Color(143, 143, 143));
        txtContraseña.setBorder(null);
        add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 400, 36));

        bntAtras.setBackground(new java.awt.Color(180, 154, 102));
        bntAtras.setFont(new java.awt.Font("Amazon Ember", 0, 18)); // NOI18N
        bntAtras.setForeground(new java.awt.Color(255, 255, 255));
        bntAtras.setText("Atras");
        bntAtras.setBorderPainted(false);
        bntAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAtrasActionPerformed(evt);
            }
        });
        add(bntAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 142, 45));

        btnSiguiente.setBackground(new java.awt.Color(180, 154, 102));
        btnSiguiente.setFont(new java.awt.Font("Amazon Ember", 0, 18)); // NOI18N
        btnSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente.setText("Siguiente");
        btnSiguiente.setBorderPainted(false);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 142, 45));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgRetiroSinCuenta.png"))); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed

        validarRetiro();
        if (retiro != null) {
            if (verificarEstadoRetiro()) {
                ventana.setRetiro(retiro);
                obtenerCuentaMonto();
                ventana.cambiarVistaConfirmarEfectuarRetiro();
            }
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void bntAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAtrasActionPerformed
        ventana.cambiarVistaInicio();
    }//GEN-LAST:event_bntAtrasActionPerformed

    /**
     * Valida el retiro de fondos ingresado por el usuario antes de procesar la
     * transacción. Verifica que se hayan completado todos los campos requeridos
     * y que el monto del retiro sea válido. Si se detectan problemas durante la
     * validación, se lanzan excepciones específicas para informar al usuario
     * sobre los errores encontrados.
     */
    public void validarRetiro() {
        try {
            retiro = transaccionDAO.buscarRetiro(txtFolio.getText(), txtContraseña.getText());

        } catch (PersistenciaException ex) {
            ventana.mostrarAviso(ex.getMessage());
        }
    }

    public boolean verificarEstadoRetiro() {
        if (retiro.getEstado().equalsIgnoreCase("caducado") || retiro.getEstado().equalsIgnoreCase("realizado")) {
            ventana.mostrarAviso("El retiro ya fue cobrado");
            return false;
        }
        return true;
    }

    public void obtenerCuentaMonto() {
        Object[] datos;
        try {
            datos = retiroDAO.consultarRetiroSinCuenta(txtFolio.getText(), txtContraseña.getText());
            double monto = (double) datos[0];
            String numCuenta = String.valueOf(datos[1]);
            ventana.getRetiro().setMonto(monto);
            ventana.getCuenta().setNumeroCuenta(numCuenta);
        } catch (PersistenciaException ex) {
            ventana.mostrarAviso(ex.getMessage());
        }
    }

    /**
     * Verifica si los campos de monto y contraseña están completos antes de
     * proceder con la validación del retiro. Si alguno de los campos está en
     * blanco, lanza una excepción de ValidacionDTOException con un mensaje
     * indicando al usuario que todos los campos deben ser completados.
     *
     * @throws ValidacionDTOException si alguno de los campos está en blanco
     */
    public void verificaCampos() throws ValidacionDTOException {
        if (txtFolio.getText().isBlank() || txtContraseña.getText().isBlank()) {
            throw new ValidacionDTOException("Llene todos los campos");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAtras;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtFolio;
    // End of variables declaration//GEN-END:variables
}
