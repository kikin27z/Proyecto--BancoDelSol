package bancodelsol;

import bancodelsol.validaciones.ValidadorCampos;
import bancodelsoldominio.Cliente;
import bancodelsolpersistencia.daos.ClienteDAO;
import bancodelsolpersistencia.daos.DomicilioDAO;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import bancodelsolpersistencia.excepciones.ValidacionDTOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa la tercera ventana de registro de clientes. En la
 * sección de datos la cuenta del cliente.
 *
 * @author José Karim Franco Valencia - 245138
 */
public class VistaRegistro3 extends javax.swing.JPanel {

    private Ventana ventana;
    private Boolean camposValidos = false;

    /**
     * Constructor de la vista de registro 3.
     *
     * @param ventana JFrame donde se colocará este JPanel.
     */
    public VistaRegistro3(Ventana ventana) {
        this.ventana = ventana;
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

        lblBanco = new javax.swing.JLabel();
        txtConfirmarContrasena = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JTextField();
        lblContrasena = new javax.swing.JLabel();
        lblIndicador1 = new javax.swing.JLabel();
        lblIndicador2 = new javax.swing.JLabel();
        lblIndicador3 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblConfirmar = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        lblIcon = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBanco.setFont(new java.awt.Font("TrajanusBricks", 0, 36)); // NOI18N
        lblBanco.setForeground(new java.awt.Color(149, 120, 64));
        lblBanco.setText("banco del sol");
        add(lblBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 14, -1, -1));

        txtConfirmarContrasena.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        txtConfirmarContrasena.setForeground(new java.awt.Color(143, 143, 143));
        txtConfirmarContrasena.setBorder(null);
        txtConfirmarContrasena.setName(""); // NOI18N
        txtConfirmarContrasena.setOpaque(true);
        add(txtConfirmarContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 375, 296, 36));

        txtUsuario.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(143, 143, 143));
        txtUsuario.setBorder(null);
        add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 287, 300, 36));

        txtContrasena.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        txtContrasena.setForeground(new java.awt.Color(143, 143, 143));
        txtContrasena.setBorder(null);
        add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 287, 300, 36));

        lblContrasena.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        lblContrasena.setForeground(new java.awt.Color(157, 134, 90));
        lblContrasena.setText("Contraseña:");
        add(lblContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 260, -1, 24));

        lblIndicador1.setFont(new java.awt.Font("Amazon Ember", 1, 20)); // NOI18N
        lblIndicador1.setForeground(new java.awt.Color(255, 255, 255));
        lblIndicador1.setText("1");
        add(lblIndicador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 220, -1, -1));

        lblIndicador2.setFont(new java.awt.Font("Amazon Ember", 1, 20)); // NOI18N
        lblIndicador2.setForeground(new java.awt.Color(255, 255, 255));
        lblIndicador2.setText("2");
        add(lblIndicador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(483, 220, -1, -1));

        lblIndicador3.setFont(new java.awt.Font("Amazon Ember", 1, 20)); // NOI18N
        lblIndicador3.setForeground(new java.awt.Color(255, 255, 255));
        lblIndicador3.setText("3");
        add(lblIndicador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 220, -1, -1));

        lblUsuario.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(157, 134, 90));
        lblUsuario.setText("Usuario:");
        add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, -1, 24));

        lblConfirmar.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        lblConfirmar.setForeground(new java.awt.Color(157, 134, 90));
        lblConfirmar.setText("Confirmar contraseña:");
        add(lblConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 343, -1, 24));

        lblTitulo.setFont(new java.awt.Font("Amazon Ember", 1, 54)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(143, 143, 143));
        lblTitulo.setText("Datos cuenta");
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 130, -1, -1));

        btnVolver.setBackground(new java.awt.Color(143, 143, 143));
        btnVolver.setFont(new java.awt.Font("Amazon Ember", 0, 18)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.setBorderPainted(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 430, 142, 45));

        btnRegistrar.setBackground(new java.awt.Color(180, 154, 102));
        btnRegistrar.setFont(new java.awt.Font("Amazon Ember", 0, 18)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrarse");
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 430, 142, 45));

        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconLogo(2).png"))); // NOI18N
        add(lblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgRegistrarse3.png"))); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 580));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Redirige a la pantalla de registro en la sección de domicilio.
     *
     * @param evt Evento de un clic en un botón.
     */
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        ventana.getClienteDTO().setUsuario(null);
        ventana.getClienteDTO().setContrasena(null);
        ventana.cambiarVistaRegistrarse2();

    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * Redirige a la pantalla de inicio sesión confirmando que se registro el
     * cliente al banco.
     *
     * @param evt Evento de un clic en un botón.
     */
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        ventana.getClienteDTO().setContrasena(txtContrasena.getText());
        ventana.getClienteDTO().setUsuario(txtUsuario.getText());
        validarDatos();
        if (camposValidos) {
            if (ventana.mostrarConfirmacion("¿Desea confirmar su registro?", "Está a un paso de ser cliente")) {
                guardarDatosCliente();
                registrarCliente();
                ventana.setClienteDTO(null);
                ventana.setDomicilioDTO(null);
                ventana.cambiarVistaInicioSesion();
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    /**
     * Método que registra cliente a la base de datos con uso de la clase
     * ClienteDAO
     */
    private void registrarCliente() {
        ClienteDAO clienteDAO = new ClienteDAO(ventana.getConexion());
        DomicilioDAO domicilioDAO = new DomicilioDAO(ventana.getConexion());
        Cliente clienteAgregado;
        try {
            clienteAgregado = clienteDAO.agregar(ventana.getClienteDTO());
            domicilioDAO.agregar(ventana.getDomicilioDTO(), clienteAgregado.getIdCliente());

            ventana.mostrarInformacion("!!!Ya eres cliente!!!", "Bienvenido");
        } catch (PersistenciaException ex) {
            Logger.getLogger(VistaRegistro3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que valida los datos y en caso de que un campo no sea apto
     * muestra un mensaje en pantalla.
     */
    public void validarDatos() {
        ValidadorCampos valida = new ValidadorCampos();
        try {
            verificaCampos();
            valida.validaSeccionDatosCuenta(txtUsuario.getText(), txtContrasena.getText());
            ClienteDAO clienteDAO = new ClienteDAO(ventana.getConexion());
            camposValidos = true;
        } catch (ValidacionDTOException ex) {
            camposValidos = false;
            ventana.mostrarAviso(ex.getMessage());
//            Logger.getLogger(VistaRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que guarda los datos del cliente en una variable auxiliar que
     * sirve en caso de volver a esta parte del formulario y insertar los datos
     * en su correspondiente campo.
     */
    public void guardarDatosCliente() {
        ventana.getClienteDTO().setUsuario(txtUsuario.getText());
        ventana.getClienteDTO().setContrasena(txtContrasena.getText());
    }

    /**
     * Método que verifica que los campos no sean vacios o solo espacios.
     * @throws ValidacionDTOException Error que señala que existe un campo inválido.
     */
    private void verificaCampos() throws ValidacionDTOException {
        if (txtConfirmarContrasena.getText() == null || txtConfirmarContrasena.getText().isBlank()
                || txtContrasena.getText() == null || txtContrasena.getText().isBlank()
                || txtUsuario.getText() == null || txtUsuario.getText().isBlank()) {
            throw new ValidacionDTOException("Llene todos los campos");
        }
        if (!txtContrasena.getText().equals(txtConfirmarContrasena.getText())) {
            throw new ValidacionDTOException("Las contraseñas no coinciden");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel lblBanco;
    private javax.swing.JLabel lblConfirmar;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblIndicador1;
    private javax.swing.JLabel lblIndicador2;
    private javax.swing.JLabel lblIndicador3;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtConfirmarContrasena;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}
