package bancodelsol;

import bancodelsol.dtos.TransferenciaNuevaDTO;
import bancodelsol.validaciones.IValidacion;
import bancodelsol.validaciones.Validacion;
import bancodelsol.validaciones.ValidadorCampos;
import bancodelsoldominio.Cuenta;
import bancodelsoldominio.Transferencia;
import bancodelsolpersistencia.daos.ITransaccionDAO;
import bancodelsolpersistencia.daos.TransaccionDAO;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import bancodelsolpersistencia.excepciones.ValidacionDTOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase representa una interfaz gráfica de usuario para realizar transferencias bancarias.
 * Permite al usuario ingresar los detalles de la transferencia, como la cuenta de destino, el monto y el motivo.
 * Una vez que se ingresan los detalles y se valida la información, se puede realizar la transferencia.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class VistaTransferir extends javax.swing.JPanel {
    private Ventana ventana;
    Cuenta cuenta;
    Transferencia transferenciaActual;
    boolean cuentaDestinoValidada;
    boolean camposValidados;
    
    /**
     * Constructor de la clase VistaTransferir.
     * @param ventana La ventana principal de la aplicación.
     */
    public VistaTransferir(Ventana ventana ) {
        this.ventana = ventana;
        cuenta = ventana.getCuenta();
        transferenciaActual = ventana.getTransferencia();
        initComponents();
        cargarDatos();
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
        lblNombreCuentaInfo = new javax.swing.JLabel();
        lblSaldoInfo = new javax.swing.JLabel();
        lblNumCuentaInfo = new javax.swing.JLabel();
        lblNombreCuenta = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        lblNumCuenta = new javax.swing.JLabel();
        lblCuentaDestino = new javax.swing.JLabel();
        txtCuentaDestino = new javax.swing.JTextField();
        lblMonto = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnBuscarCuenta = new javax.swing.JButton();
        btnTransferir = new javax.swing.JButton();
        iconAjustes = new javax.swing.JLabel();
        btnInicio = new javax.swing.JButton();
        iconInicio = new javax.swing.JLabel();
        btnPerfil = new javax.swing.JButton();
        iconPerfil = new javax.swing.JLabel();
        btnHistorial = new javax.swing.JButton();
        iconHistorial = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        iconCerrarSesion = new javax.swing.JLabel();
        txtMotivo = new javax.swing.JTextField();
        lblMotivo = new javax.swing.JLabel();
        iconLogo = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Amazon Ember", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(149, 120, 64));
        lblTitulo.setText("Transferir");
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 34, 180, 43));

        lblNombreCuentaInfo.setFont(new java.awt.Font("Amazon Ember", 1, 22)); // NOI18N
        lblNombreCuentaInfo.setForeground(new java.awt.Color(168, 163, 154));
        lblNombreCuentaInfo.setText("Cuenta:");
        add(lblNombreCuentaInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 105, 80, 26));

        lblSaldoInfo.setFont(new java.awt.Font("Amazon Ember", 1, 22)); // NOI18N
        lblSaldoInfo.setForeground(new java.awt.Color(168, 163, 154));
        lblSaldoInfo.setText("Saldo actual:");
        add(lblSaldoInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 105, -1, 26));

        lblNumCuentaInfo.setFont(new java.awt.Font("Amazon Ember", 1, 22)); // NOI18N
        lblNumCuentaInfo.setForeground(new java.awt.Color(168, 163, 154));
        lblNumCuentaInfo.setText("# de cuenta:");
        add(lblNumCuentaInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(718, 105, -1, 26));

        lblNombreCuenta.setFont(new java.awt.Font("Amazon Ember", 1, 22)); // NOI18N
        lblNombreCuenta.setForeground(new java.awt.Color(180, 154, 102));
        lblNombreCuenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreCuenta.setText("Cuenta:");
        lblNombreCuenta.setToolTipText("");
        add(lblNombreCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 132, 190, 26));

        lblSaldo.setFont(new java.awt.Font("Amazon Ember", 1, 36)); // NOI18N
        lblSaldo.setForeground(new java.awt.Color(180, 154, 102));
        lblSaldo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaldo.setText("$112.00 MXN");
        add(lblSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 133, 305, 43));

        lblNumCuenta.setFont(new java.awt.Font("Amazon Ember", 1, 22)); // NOI18N
        lblNumCuenta.setForeground(new java.awt.Color(180, 154, 102));
        lblNumCuenta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNumCuenta.setText("1111222211112222");
        add(lblNumCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(714, 132, 230, 26));

        lblCuentaDestino.setFont(new java.awt.Font("Amazon Ember Light", 1, 20)); // NOI18N
        lblCuentaDestino.setForeground(new java.awt.Color(180, 154, 102));
        lblCuentaDestino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCuentaDestino.setText("Num. Cuenta Destino:");
        add(lblCuentaDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, -1, -1));

        txtCuentaDestino.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        txtCuentaDestino.setForeground(new java.awt.Color(143, 143, 143));
        add(txtCuentaDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 406, 40));

        lblMonto.setFont(new java.awt.Font("Amazon Ember Light", 1, 20)); // NOI18N
        lblMonto.setForeground(new java.awt.Color(180, 154, 102));
        lblMonto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMonto.setText("Monto:");
        add(lblMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, -1, -1));

        txtMonto.setEditable(false);
        txtMonto.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        txtMonto.setForeground(new java.awt.Color(143, 143, 143));
        add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 407, 41));

        btnCancelar.setBackground(new java.awt.Color(180, 154, 102));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorderPainted(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 470, 142, 45));

        btnBuscarCuenta.setBackground(new java.awt.Color(180, 154, 102));
        btnBuscarCuenta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBuscarCuenta.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarCuenta.setText("Buscar cuenta");
        btnBuscarCuenta.setBorderPainted(false);
        btnBuscarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCuentaActionPerformed(evt);
            }
        });
        add(btnBuscarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 217, 160, 30));

        btnTransferir.setBackground(new java.awt.Color(149, 120, 64));
        btnTransferir.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnTransferir.setForeground(new java.awt.Color(34, 33, 33));
        btnTransferir.setText("Transferir");
        btnTransferir.setBorderPainted(false);
        btnTransferir.setEnabled(false);
        btnTransferir.setFocusable(false);
        btnTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferirActionPerformed(evt);
            }
        });
        add(btnTransferir, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 470, 142, 45));

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

        txtMotivo.setEditable(false);
        txtMotivo.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        txtMotivo.setForeground(new java.awt.Color(143, 143, 143));
        add(txtMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 407, 41));

        lblMotivo.setFont(new java.awt.Font("Amazon Ember Light", 1, 20)); // NOI18N
        lblMotivo.setForeground(new java.awt.Color(180, 154, 102));
        lblMotivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMotivo.setText("Motivo:");
        add(lblMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, -1, -1));

        iconLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconLogo.png"))); // NOI18N
        add(iconLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 538, 35, 35));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVistaTransferir.png"))); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 580));
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Este método se ejecuta cuando el usuario hace clic en el botón "Buscar cuenta".
    * Valida la cuenta de destino ingresada por el usuario y habilita los campos de motivo y monto
    * si la cuenta es válida.
    * @param evt El evento de acción que desencadena este método.
    */
    private void btnBuscarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCuentaActionPerformed
        validarCuentaDestino();
        if(cuentaDestinoValidada){
            btnBuscarCuenta.setEnabled(false);
            btnTransferir.setEnabled(true);
            txtCuentaDestino.setEditable(false);
            txtMotivo.setEditable(true);
            txtMonto.setEditable(true);
        }
        
    }//GEN-LAST:event_btnBuscarCuentaActionPerformed

    /**
    * Este método se ejecuta cuando el usuario hace clic en el botón "Transferir".
    * Valida los campos de motivo y monto, y si son válidos, muestra una confirmación al usuario
    * para realizar la transferencia. Luego realiza la transferencia y cambia la vista a la vista
    * de transferencia exitosa.
    * @param evt El evento de acción que desencadena este método.
    */
    private void btnTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferirActionPerformed
        // TODO add your handling code here:
        
        validarCampos();
        if(camposValidados){
            if(ventana.mostrarConfirmacion("¿Quiere realizar la transferencia?", "Ha un paso de transferir")){
                realizarTransferencia();
                ventana.cambiarVistaTransferenciaExitosa();
            }
        }
    }//GEN-LAST:event_btnTransferirActionPerformed

    /**
    * Cambia la vista actual a la vista principal del cliente.
    *
    * @param evt El evento de acción que desencadena este método.
    */
    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        if(ventana.mostrarConfirmacion("¿Cancelaras la transferencia?", "¿Desea continuar?")){
            ventana.setCuenta(null);
            ventana.cambiarVistaHistorial();
        }
    }//GEN-LAST:event_btnInicioActionPerformed

    /**
    * Cambia la vista del perfil del cliente.
    *
    * @param evt El evento de acción que desencadena este método.
    */
    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        if(ventana.mostrarConfirmacion("¿Cancelaras la transferencia?", "¿Desea continuar?")){
            ventana.cambiarVistaEditarPerfil();
        }
    }//GEN-LAST:event_btnPerfilActionPerformed

    /**
    * Cambia la vista del historial de operaciones totales.
    *
    * @param evt El evento de acción que desencadena este método.
    */
    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        if(ventana.mostrarConfirmacion("¿Cancelaras la transferencia?", "¿Desea continuar?")){
            ventana.cambiarVistaHistorial();
        }
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

    /**
     * Método que cancela la transferencia y se dirige a la pantalla de vista de la cuenta.
     * @param evt El evento de acción que desencadena este método.
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if(ventana.mostrarConfirmacion("¿Cancelaras la transferencia?", "¿Desea continuar?")){
            ventana.cambiarVistaCuenta();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
    * Valida la cuenta de destino ingresada por el usuario.
    * Comprueba si la cuenta existe y si es válida para realizar la transferencia.
    */
    private void validarCuentaDestino(){
        ValidadorCampos valida = new ValidadorCampos();
        IValidacion validador = new Validacion(ventana.getConexion());
           try {
               
               
               valida.validaNumeroCuenta(txtCuentaDestino.getText());
               validador.existeCuenta(txtCuentaDestino.getText());
               if(cuenta.getNumeroCuenta().equals(txtCuentaDestino.getText())){
                   throw new ValidacionDTOException("No es posible transferirse a la misma cuenta");
               }else if(cuenta.getEstadoCuenta().equals("Inactiva")){
                   throw new ValidacionDTOException("No es posible transferirle a una cuenta inactiva");
               }
               cuentaDestinoValidada = true;
           } catch (ValidacionDTOException ex) {
               cuentaDestinoValidada = false;
               ventana.mostrarAviso(ex.getMessage());
           }
    }
    
    /**
    * Valida los campos de monto y motivo antes de realizar la transferencia.
    * Comprueba si el monto es válido y si la cuenta tiene saldo suficiente.
    */
    private void validarCampos(){
        TransferenciaNuevaDTO transferenciaNueva = new TransferenciaNuevaDTO();
        transferenciaNueva.setMontoCadena(txtMonto.getText());
        transferenciaNueva.setMotivo(txtMotivo.getText());
        
        try {
            transferenciaNueva.esValido();
            double monto = Double.parseDouble(txtMonto.getText());
            if(cuenta.getSaldo() - monto < 0){
                throw new ValidacionDTOException("El monto es superior al saldo de la cuenta");
            }
            camposValidados = true;
        } catch (ValidacionDTOException ex) {
            camposValidados = false;
            ventana.mostrarAviso(ex.getMessage());
        }
    }
    
    /**
    * Realiza la transferencia bancaria una vez que se han validado los campos y la cuenta de destino.
    * Crea un objeto TransferenciaNuevaDTO con los detalles de la transferencia y lo guarda en la base de datos.
    */
    private void realizarTransferencia(){
        try {
            ITransaccionDAO transaccionDAO = new TransaccionDAO(ventana.getConexion());
            
            transferenciaActual = transaccionDAO.realizarTransferencia(
                    cuenta.getIdCuenta(),
                    txtCuentaDestino.getText(),
                    txtMotivo.getText(),
                    Double.parseDouble(txtMonto.getText())
            );
            ventana.setTransferencia(transferenciaActual);
        } catch (PersistenciaException ex) {
            Logger.getLogger(VistaTransferir.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Este método se encarga de cargar los datos de la cuenta en la interfaz gráfica. 
     * Establece el nombre de la cuenta, el número de cuenta y el saldo actual en los 
     * respectivos campos de la interfaz.
     */
    private void cargarDatos(){
        lblNombreCuenta.setText(cuenta.getNombreCuenta());
        lblNumCuenta.setText(cuenta.getNumeroCuenta());
        String numeroFormateado = String.format("%.2f", cuenta.getSaldo());
        
        lblSaldo.setText("$"+ numeroFormateado+ " MXN");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCuenta;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnTransferir;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel iconAjustes;
    private javax.swing.JLabel iconCerrarSesion;
    private javax.swing.JLabel iconHistorial;
    private javax.swing.JLabel iconInicio;
    private javax.swing.JLabel iconLogo;
    private javax.swing.JLabel iconPerfil;
    private javax.swing.JLabel lblCuentaDestino;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblMotivo;
    private javax.swing.JLabel lblNombreCuenta;
    private javax.swing.JLabel lblNombreCuentaInfo;
    private javax.swing.JLabel lblNumCuenta;
    private javax.swing.JLabel lblNumCuentaInfo;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblSaldoInfo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCuentaDestino;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtMotivo;
    // End of variables declaration//GEN-END:variables
}
