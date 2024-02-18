package bancodelsol;

import bancodelsoldominio.Cuenta;
import bancodelsolpersistencia.daos.CuentaDAO;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase VistaCuenta es un panel de interfaz de usuario que representa
 * la vista de una cuenta  con su información en la aplicación bancaria.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class VistaCuenta extends javax.swing.JPanel {
    Cuenta cuenta;
    Long idCuenta;
    private  Ventana ventana;
    
    /**
     * Constructor de la clase VistaCuenta.
     *
     * @param ventana La ventana principal de la aplicación.
     */
    public VistaCuenta(Ventana ventana, Long idCuenta ) {
        this.ventana = ventana;
        this.idCuenta = idCuenta;
        initComponents();
        cargarDatosCuenta();
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
        lblNombreCuenta = new javax.swing.JLabel();
        lblMontoActual = new javax.swing.JLabel();
        lblSaldoInfo = new javax.swing.JLabel();
        lblNumCuentaInfo = new javax.swing.JLabel();
        lblFechaAperturaInfo = new javax.swing.JLabel();
        lblNumCuenta = new javax.swing.JLabel();
        lblFechaApertura = new javax.swing.JLabel();
        lblOperacionInfo = new javax.swing.JLabel();
        lblTransferencia = new javax.swing.JLabel();
        lblRetiro = new javax.swing.JLabel();
        lblTipoInfo = new javax.swing.JLabel();
        lblMontoInfo = new javax.swing.JLabel();
        lblFechaInfo = new javax.swing.JLabel();
        lblTipo1 = new javax.swing.JLabel();
        lblTipo2 = new javax.swing.JLabel();
        lblTipo3 = new javax.swing.JLabel();
        lblMonto1 = new javax.swing.JLabel();
        lblMonto2 = new javax.swing.JLabel();
        lblMonto3 = new javax.swing.JLabel();
        lblFecha1 = new javax.swing.JLabel();
        lblFecha2 = new javax.swing.JLabel();
        lblFecha3 = new javax.swing.JLabel();
        iconAjustes = new javax.swing.JLabel();
        btnInicio = new javax.swing.JButton();
        iconInicio = new javax.swing.JLabel();
        btnPerfil = new javax.swing.JButton();
        iconPerfil = new javax.swing.JLabel();
        btnHistorial = new javax.swing.JButton();
        iconHistorial = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        iconCerrarSesion = new javax.swing.JLabel();
        iconLogo = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Amazon Ember", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(149, 120, 64));
        lblTitulo.setText("Cuenta");
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 21, -1, -1));

        lblNombreCuenta.setFont(new java.awt.Font("Amazon Ember", 0, 40)); // NOI18N
        lblNombreCuenta.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreCuenta.setText("Cuenta");
        add(lblNombreCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 95, 460, -1));

        lblMontoActual.setFont(new java.awt.Font("Amazon Ember", 1, 40)); // NOI18N
        lblMontoActual.setForeground(new java.awt.Color(255, 255, 255));
        lblMontoActual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMontoActual.setText("$100.00 MXN");
        add(lblMontoActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 150, 358, -1));

        lblSaldoInfo.setFont(new java.awt.Font("Amazon Ember", 0, 30)); // NOI18N
        lblSaldoInfo.setForeground(new java.awt.Color(255, 255, 255));
        lblSaldoInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaldoInfo.setText("Saldo actual:");
        add(lblSaldoInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 210, 184, -1));

        lblNumCuentaInfo.setFont(new java.awt.Font("Amazon Ember", 0, 24)); // NOI18N
        lblNumCuentaInfo.setForeground(new java.awt.Color(255, 255, 255));
        lblNumCuentaInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumCuentaInfo.setText("Num. de cuenta:");
        add(lblNumCuentaInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 99, 184, -1));

        lblFechaAperturaInfo.setFont(new java.awt.Font("Amazon Ember", 0, 24)); // NOI18N
        lblFechaAperturaInfo.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaAperturaInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFechaAperturaInfo.setText("Num. de cuenta:");
        add(lblFechaAperturaInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 170, 184, -1));

        lblNumCuenta.setFont(new java.awt.Font("Amazon Ember Light", 0, 24)); // NOI18N
        lblNumCuenta.setForeground(new java.awt.Color(255, 255, 255));
        lblNumCuenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumCuenta.setText("4444555566667777");
        add(lblNumCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 130, 240, -1));

        lblFechaApertura.setFont(new java.awt.Font("Amazon Ember Light", 0, 24)); // NOI18N
        lblFechaApertura.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaApertura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFechaApertura.setText("12/07/2004");
        add(lblFechaApertura, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 200, 184, -1));

        lblOperacionInfo.setFont(new java.awt.Font("Amazon Ember", 0, 24)); // NOI18N
        lblOperacionInfo.setForeground(new java.awt.Color(143, 143, 143));
        lblOperacionInfo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblOperacionInfo.setText("Operaciones");
        add(lblOperacionInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 275, 184, -1));

        lblTransferencia.setFont(new java.awt.Font("Amazon Ember", 0, 20)); // NOI18N
        lblTransferencia.setForeground(new java.awt.Color(255, 255, 255));
        lblTransferencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTransferencia.setText("Transferencia");
        lblTransferencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTransferenciaMouseClicked(evt);
            }
        });
        add(lblTransferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 310, 200, 45));

        lblRetiro.setFont(new java.awt.Font("Amazon Ember", 0, 20)); // NOI18N
        lblRetiro.setForeground(new java.awt.Color(255, 255, 255));
        lblRetiro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRetiro.setText("Retiro sin cuenta");
        add(lblRetiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 310, 200, 45));

        lblTipoInfo.setFont(new java.awt.Font("Amazon Ember", 0, 20)); // NOI18N
        lblTipoInfo.setForeground(new java.awt.Color(186, 180, 168));
        lblTipoInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipoInfo.setText("Tipo");
        add(lblTipoInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 430, 122, 22));

        lblMontoInfo.setFont(new java.awt.Font("Amazon Ember", 0, 18)); // NOI18N
        lblMontoInfo.setForeground(new java.awt.Color(186, 180, 168));
        lblMontoInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMontoInfo.setText("Monto");
        add(lblMontoInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, 54, 22));

        lblFechaInfo.setFont(new java.awt.Font("Amazon Ember", 0, 18)); // NOI18N
        lblFechaInfo.setForeground(new java.awt.Color(186, 180, 168));
        lblFechaInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFechaInfo.setText("Fecha y hora");
        add(lblFechaInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 430, 110, 22));

        lblTipo1.setFont(new java.awt.Font("Amazon Ember", 0, 18)); // NOI18N
        lblTipo1.setForeground(new java.awt.Color(186, 180, 168));
        lblTipo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipo1.setText("Retiro");
        add(lblTipo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 460, 122, 22));

        lblTipo2.setFont(new java.awt.Font("Amazon Ember", 0, 18)); // NOI18N
        lblTipo2.setForeground(new java.awt.Color(186, 180, 168));
        lblTipo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipo2.setText("Retiro");
        add(lblTipo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 485, 122, 22));

        lblTipo3.setFont(new java.awt.Font("Amazon Ember", 0, 18)); // NOI18N
        lblTipo3.setForeground(new java.awt.Color(186, 180, 168));
        lblTipo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipo3.setText("Retiro");
        add(lblTipo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 510, 122, 22));

        lblMonto1.setFont(new java.awt.Font("Amazon Ember", 0, 18)); // NOI18N
        lblMonto1.setForeground(new java.awt.Color(186, 180, 168));
        lblMonto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMonto1.setText("Retiro");
        add(lblMonto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 460, 122, 22));

        lblMonto2.setFont(new java.awt.Font("Amazon Ember", 0, 18)); // NOI18N
        lblMonto2.setForeground(new java.awt.Color(186, 180, 168));
        lblMonto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMonto2.setText("Retiro");
        add(lblMonto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 485, 122, 22));

        lblMonto3.setFont(new java.awt.Font("Amazon Ember", 0, 18)); // NOI18N
        lblMonto3.setForeground(new java.awt.Color(186, 180, 168));
        lblMonto3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMonto3.setText("Retiro");
        add(lblMonto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 510, 122, 22));

        lblFecha1.setFont(new java.awt.Font("Amazon Ember", 0, 18)); // NOI18N
        lblFecha1.setForeground(new java.awt.Color(186, 180, 168));
        lblFecha1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha1.setText("03/06/2004 12:03:22");
        add(lblFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(586, 460, 200, 22));

        lblFecha2.setFont(new java.awt.Font("Amazon Ember", 0, 18)); // NOI18N
        lblFecha2.setForeground(new java.awt.Color(186, 180, 168));
        lblFecha2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha2.setText("03/06/2004 12:03:22");
        add(lblFecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(586, 485, 200, 22));

        lblFecha3.setFont(new java.awt.Font("Amazon Ember", 0, 18)); // NOI18N
        lblFecha3.setForeground(new java.awt.Color(186, 180, 168));
        lblFecha3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha3.setText("03/06/2004 12:03:22");
        add(lblFecha3, new org.netbeans.lib.awtextra.AbsoluteConstraints(586, 510, 200, 22));

        iconAjustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconAjustes.png"))); // NOI18N
        add(iconAjustes, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 10, 35, 35));

        btnInicio.setBorderPainted(false);
        btnInicio.setContentAreaFilled(false);
        btnInicio.setFocusPainted(false);
        btnInicio.setFocusable(false);
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 58, 35, 35));

        iconInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconInicio.png"))); // NOI18N
        add(iconInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 58, 35, 35));

        btnPerfil.setBorderPainted(false);
        btnPerfil.setContentAreaFilled(false);
        btnPerfil.setFocusPainted(false);
        btnPerfil.setFocusable(false);
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });
        add(btnPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 111, 35, 35));

        iconPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconPerfil.png"))); // NOI18N
        add(iconPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 111, 35, 35));

        btnHistorial.setBorderPainted(false);
        btnHistorial.setContentAreaFilled(false);
        btnHistorial.setFocusPainted(false);
        btnHistorial.setFocusable(false);
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });
        add(btnHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 164, 35, 35));

        iconHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconHistorial.png"))); // NOI18N
        add(iconHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 164, 35, 35));

        btnCerrarSesion.setBorderPainted(false);
        btnCerrarSesion.setContentAreaFilled(false);
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.setFocusable(false);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 213, 35, 35));

        iconCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconCerrarSesion.png"))); // NOI18N
        add(iconCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 213, 35, 35));

        iconLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconLogo.png"))); // NOI18N
        add(iconLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 538, 35, 35));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVistaCuenta.png"))); // NOI18N
        add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 580));
    }// </editor-fold>//GEN-END:initComponents

    private void lblTransferenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTransferenciaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTransferenciaMouseClicked

    /**
    * Cambia la vista actual a la vista principal del cliente.
    *
    * @param evt El evento de acción que desencadena este método.
    */
    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed

    }//GEN-LAST:event_btnInicioActionPerformed

    /**
    * Cambia la vista del perfil del cliente.
    *
    * @param evt El evento de acción que desencadena este método.
    */
    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPerfilActionPerformed

    /**
    * Cambia la vista del historial de operaciones totales.
    *
    * @param evt El evento de acción que desencadena este método.
    */
    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHistorialActionPerformed

    /**
    * Cambia la vista actual a la pantalla de inicio del banco.
    *
    * @param evt El evento de acción que desencadena este método.
    */
    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        if(ventana.mostrarConfirmacion("¿Seguro que querer cerrar sesión?", "Cerrar sesión")){
            ventana.setCliente(null);
            ventana.setCuenta(null);
            ventana.cambiarVistaInicio();
        }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JLabel iconAjustes;
    private javax.swing.JLabel iconCerrarSesion;
    private javax.swing.JLabel iconHistorial;
    private javax.swing.JLabel iconInicio;
    private javax.swing.JLabel iconLogo;
    private javax.swing.JLabel iconPerfil;
    private javax.swing.JLabel lblFecha1;
    private javax.swing.JLabel lblFecha2;
    private javax.swing.JLabel lblFecha3;
    private javax.swing.JLabel lblFechaApertura;
    private javax.swing.JLabel lblFechaAperturaInfo;
    private javax.swing.JLabel lblFechaInfo;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblMonto1;
    private javax.swing.JLabel lblMonto2;
    private javax.swing.JLabel lblMonto3;
    private javax.swing.JLabel lblMontoActual;
    private javax.swing.JLabel lblMontoInfo;
    private javax.swing.JLabel lblNombreCuenta;
    private javax.swing.JLabel lblNumCuenta;
    private javax.swing.JLabel lblNumCuentaInfo;
    private javax.swing.JLabel lblOperacionInfo;
    private javax.swing.JLabel lblRetiro;
    private javax.swing.JLabel lblSaldoInfo;
    private javax.swing.JLabel lblTipo1;
    private javax.swing.JLabel lblTipo2;
    private javax.swing.JLabel lblTipo3;
    private javax.swing.JLabel lblTipoInfo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTransferencia;
    // End of variables declaration//GEN-END:variables

    public void cargarDatosCuenta(){
        try {
            CuentaDAO cuentaDAO = new CuentaDAO(ventana.getConexion());
            this.cuenta = cuentaDAO.existe(this.idCuenta);
            
            if(cuenta != null){
                lblNombreCuenta.setText("Hogar");
                this.lblMontoActual.setText("$"+this.cuenta.getSaldo()+" MXN");
                lblFechaApertura.setText(cuenta.getFechaApertura());
                lblNumCuenta.setText(cuenta.getNumeroCuenta());
            }
            } catch (PersistenciaException ex) {
                ventana.setCuenta(null);
                Logger.getLogger(VistaCuenta.class.getName()).log(Level.SEVERE, null, ex);
                ventana.mostrarAviso(ex.getMessage());
            }

    }

}
