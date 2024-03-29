package bancodelsol;

import bancodelsol.validaciones.IValidacion;
import bancodelsol.validaciones.Validacion;
import bancodelsol.validaciones.ValidadorCampos;
import bancodelsoldominio.Cliente;
import bancodelsolpersistencia.excepciones.ValidacionDTOException;

/**
 * Esta clase representa la vista de inicio de sesión en la interfaz gráfica del banco.
 * Permite a los usuarios iniciar sesión proporcionando su nombre de usuario y contraseña.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class VistaInicioSesion extends javax.swing.JPanel {
    private Ventana ventana;
    private IValidacion validacion;
    private boolean loginValido;
    private Cliente cliente;
    private ValidadorCampos validador;

    /**
     * Constructor de la clase VistaInicioSesion.
     * 
     * @param ventana La ventana principal de la aplicación.
     */
    public VistaInicioSesion(Ventana ventana) {
        this.ventana = ventana;
        this.validacion = new Validacion(ventana.getConexion());
        this.validador = new ValidadorCampos();
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

        txtUsuario = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JTextField();
        lblBanco = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblContrasena = new javax.swing.JLabel();
        btnInicioSesion = new javax.swing.JButton();
        btnInicio = new javax.swing.JButton();
        lblHazteCliente = new javax.swing.JLabel();
        lblIcon = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuario.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(143, 143, 143));
        txtUsuario.setBorder(null);
        add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 240, 447, 37));

        txtContrasena.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        txtContrasena.setForeground(new java.awt.Color(143, 143, 143));
        txtContrasena.setBorder(null);
        txtContrasena.setInheritsPopupMenu(true);
        add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 327, 447, 37));
        txtContrasena.getAccessibleContext().setAccessibleName("");
        txtContrasena.getAccessibleContext().setAccessibleDescription("");

        lblBanco.setFont(new java.awt.Font("TrajanusBricks", 0, 36)); // NOI18N
        lblBanco.setForeground(new java.awt.Color(149, 120, 64));
        lblBanco.setText("banco del sol");
        add(lblBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 14, -1, -1));

        lblTitulo.setFont(new java.awt.Font("Amazon Ember", 1, 54)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(143, 143, 143));
        lblTitulo.setText("Inicio Sesión");
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 130, -1, -1));

        lblUsuario.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(157, 134, 90));
        lblUsuario.setText("Usuario:");
        add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 212, -1, 24));

        lblContrasena.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        lblContrasena.setForeground(new java.awt.Color(157, 134, 90));
        lblContrasena.setText("Contrasena");
        add(lblContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 299, -1, 24));

        btnInicioSesion.setBackground(new java.awt.Color(180, 154, 102));
        btnInicioSesion.setFont(new java.awt.Font("Amazon Ember", 0, 18)); // NOI18N
        btnInicioSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnInicioSesion.setText("Inicio Sesión");
        btnInicioSesion.setBorderPainted(false);
        btnInicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioSesionActionPerformed(evt);
            }
        });
        add(btnInicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 400, 142, 45));

        btnInicio.setBackground(new java.awt.Color(180, 154, 102));
        btnInicio.setFont(new java.awt.Font("Amazon Ember", 0, 18)); // NOI18N
        btnInicio.setForeground(new java.awt.Color(255, 255, 255));
        btnInicio.setText("Volver");
        btnInicio.setBorderPainted(false);
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 142, 45));

        lblHazteCliente.setFont(new java.awt.Font("Amazon Ember", 0, 16)); // NOI18N
        lblHazteCliente.setForeground(new java.awt.Color(143, 143, 143));
        lblHazteCliente.setText("¿No eres cliente y quieres serlo?");
        lblHazteCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHazteClienteMouseClicked(evt);
            }
        });
        add(lblHazteCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, -1, -1));

        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconLogo(2).png"))); // NOI18N
        add(lblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgInicioSesion.png"))); // NOI18N
        fondo.setMaximumSize(new java.awt.Dimension(1000, 580));
        fondo.setMinimumSize(new java.awt.Dimension(1000, 580));
        fondo.setPreferredSize(new java.awt.Dimension(1000, 580));
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 580));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que se ejecuta al hacer clic en el botón "Iniciar Sesión".
     * Realiza la validación de los campos de inicio de sesión y realiza el inicio de sesión si los campos son válidos.
     * En caso contrario, muestra un mensaje de aviso.
     * 
     * @param evt El evento de acción que desencadena este método (en este caso, hacer clic en el botón "Iniciar Sesión").
     */
    private void btnInicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioSesionActionPerformed
        validarInicioSesion();
        if (cliente == null) {
            ventana.mostrarAviso("Usuario inválido");
        }else{
            ventana.setCliente(cliente);
            ventana.cambiarVistaCliente();
        }
    }//GEN-LAST:event_btnInicioSesionActionPerformed

    /**
     * Método que se ejecuta al hacer clic en el botón "Volver".
     * Cambia la vista actual a la vista de inicio.
     * 
     * @param evt El evento de acción que desencadena este método (en este caso, hacer clic en el botón "Volver").
     */
    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        ventana.cambiarVistaInicio();
    }//GEN-LAST:event_btnInicioActionPerformed

    /**
     * Método que se ejecuta al hacer clic en el texto "¿No eres cliente y quieres serlo?".
     * Cambia la vista actual a la vista de registro.
     * 
     * @param evt El evento de acción que desencadena este método (en este caso, hacer clic en el texto "¿No eres cliente y quieres serlo?").
     */
    private void lblHazteClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHazteClienteMouseClicked
        // TODO add your handling code here:
        ventana.cambiarVistaRegistro();
    }//GEN-LAST:event_lblHazteClienteMouseClicked

    /**
     * Valida el inicio de sesión verificando los campos de usuario y contraseña.
     * Muestra un mensaje de aviso si los campos no son válidos.
     */
    private void validarInicioSesion() {
        
        try {
            verificaCampos();
            validador.validaSeccionDatosCuenta(txtUsuario.getText(), txtContrasena.getText());
            cliente = validacion.clienteValido(txtUsuario.getText(), txtContrasena.getText());
        } catch (ValidacionDTOException e) {
            ventana.mostrarAviso(e.getMessage());
        }
    }

    /**
     * Verifica que los campos de usuario y contraseña no estén vacíos y cumplen con las longitudes permitidas.
     * Muestra un mensaje de aviso si los campos no son válidos.
     * 
     * @throws ValidacionDTOException Si los campos no son válidos.
     */
    private void verificaCampos() throws ValidacionDTOException {
        if (txtUsuario.getText().isBlank() || txtContrasena.getText().isBlank()) {
            throw new ValidacionDTOException("Llene todos los campos");
        }

        // Verifica la longitud del usuario
        if (txtUsuario.getText().length() > 30) {
            throw new ValidacionDTOException("El nombre de usuario debe tener como máximo 30 caracteres");
        }

        // Verifica la longitud de la contraseña
        if (txtContrasena.getText().length() > 20) {
            throw new ValidacionDTOException("La contraseña debe tener como máximo 20 caracteres");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnInicioSesion;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel lblBanco;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblHazteCliente;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}
