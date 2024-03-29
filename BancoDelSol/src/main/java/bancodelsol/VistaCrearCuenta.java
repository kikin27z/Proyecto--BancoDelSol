package bancodelsol;

import bancodelsol.dtos.CuentaNuevaDTO;
import bancodelsol.validaciones.ValidadorCampos;
import bancodelsoldominio.Cliente;
import bancodelsoldominio.Cuenta;
import bancodelsolpersistencia.daos.CuentaDAO;
import bancodelsolpersistencia.daos.ICuentaDAO;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import bancodelsolpersistencia.excepciones.ValidacionDTOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase VistaCrearCuenta es un panel de interfaz de usuario que representa
 * la vista para crear una cuenta en la aplicación bancaria.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class VistaCrearCuenta extends javax.swing.JPanel {

    private Ventana ventana;
    private Cliente clienteActual;
    private CuentaNuevaDTO cuentaNueva;
    private boolean camposValidados;

    /**
     * Constructor de la clase VistaCrearCuenta.
     *
     * @param ventana La ventana principal de la aplicación.
     */
    public VistaCrearCuenta(Ventana ventana) {
        this.ventana = ventana;
        this.clienteActual = ventana.getCliente();
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
        lblUsuario = new javax.swing.JLabel();
        txtNombreCuenta = new javax.swing.JTextField();
        lblUsuario2 = new javax.swing.JLabel();
        lblUsuario3 = new javax.swing.JLabel();
        lblUsuario1 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
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
        btnVolver = new javax.swing.JButton();
        btnCrearCuenta = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Amazon Ember", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(149, 120, 64));
        lblTitulo.setText("Creando cuenta");
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 284, 43));

        lblUsuario.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(157, 134, 90));
        lblUsuario.setText("Nombre de la cuenta:");
        add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 182, -1, 24));

        txtNombreCuenta.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        txtNombreCuenta.setForeground(new java.awt.Color(143, 143, 143));
        txtNombreCuenta.setBorder(null);
        add(txtNombreCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 214, 387, 36));

        lblUsuario2.setFont(new java.awt.Font("Amazon Ember Light", 0, 12)); // NOI18N
        lblUsuario2.setForeground(new java.awt.Color(157, 134, 90));
        lblUsuario2.setText("**menor a 15 caracteres**");
        add(lblUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, -1, 24));

        lblUsuario3.setFont(new java.awt.Font("Amazon Ember Light", 0, 12)); // NOI18N
        lblUsuario3.setForeground(new java.awt.Color(157, 134, 90));
        lblUsuario3.setText("**cifras positivas**");
        add(lblUsuario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, -1, 24));

        lblUsuario1.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        lblUsuario1.setForeground(new java.awt.Color(157, 134, 90));
        lblUsuario1.setText("Saldo:");
        add(lblUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 290, -1, 24));

        txtSaldo.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        txtSaldo.setForeground(new java.awt.Color(143, 143, 143));
        txtSaldo.setBorder(null);
        add(txtSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 322, 387, 36));

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

        btnVolver.setBackground(new java.awt.Color(180, 154, 102));
        btnVolver.setFont(new java.awt.Font("Amazon Ember", 0, 18)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.setBorderPainted(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 142, 45));

        btnCrearCuenta.setBackground(new java.awt.Color(180, 154, 102));
        btnCrearCuenta.setFont(new java.awt.Font("Amazon Ember", 0, 18)); // NOI18N
        btnCrearCuenta.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearCuenta.setText("Crear");
        btnCrearCuenta.setBorderPainted(false);
        btnCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCuentaActionPerformed(evt);
            }
        });
        add(btnCrearCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, 142, 45));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVistaCrearCuenta.png"))); // NOI18N
        fondo.setToolTipText("");
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 580));
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Cambia la vista actual a la vista principal del cliente.
    *
    * @param evt El evento de acción que desencadena este método.
    */
    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        if(ventana.mostrarConfirmacion("¿Saldrás de crear la cuenta?", "¿Desea continuar?")){
            ventana.cambiarVistaHistorial();
        }
    }//GEN-LAST:event_btnInicioActionPerformed
    
    /**
    * Cambia la vista del perfil del cliente.
    *
    * @param evt El evento de acción que desencadena este método.
    */
    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        if(ventana.mostrarConfirmacion("¿Saldrás de crear la cuenta?", "¿Desea continuar?")){
//            ventana.cambiarVistaHistorial();
        }
    }//GEN-LAST:event_btnPerfilActionPerformed

    /**
    * Cambia la vista del historial de operaciones totales.
    *
    * @param evt El evento de acción que desencadena este método.
    */
    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        if(ventana.mostrarConfirmacion("¿Saldrás de crear la cuenta?", "¿Desea continuar?")){
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
    * Cambia la vista actual a la vista principal del cliente.
    *
    * @param evt El evento de acción que desencadena este método.
    */
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        ventana.cambiarVistaCliente();
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
    * Guarda los datos ingresados por el usuario, los valida, y si son válidos,
    * confirma la creación de la nueva cuenta y la registra en la base de datos.
    * Finalmente, cambia la vista actual a la vista principal del cliente.
    *
    * @param evt El evento de acción que desencadena este método.
    */
    private void btnCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCuentaActionPerformed
        guardarDatos();
        validarDatos();
        if (camposValidados) {
            if(ventana.mostrarConfirmacion("¿Desea crear la cuenta nueva?", "Ha un paso de abrir una nueva cuenta")){
                registrarCuenta();
                ventana.cambiarVistaCliente();
            }
        }
    }//GEN-LAST:event_btnCrearCuentaActionPerformed

    /**
    * Guarda los datos ingresados por el usuario en un objeto CuentaNuevaDTO.
    * Los datos se toman de los campos de texto txtNombreCuenta y txtSaldo.
    */
    private void guardarDatos() {
        cuentaNueva = new CuentaNuevaDTO();
        cuentaNueva.setNombreCuenta(txtNombreCuenta.getText());
        cuentaNueva.setSaldo(txtSaldo.getText());
    }
    
    /**
    * Valida los datos ingresados por el usuario.
    * Utiliza un objeto ValidadorCampos para realizar las validaciones necesarias.
    * Si los datos son válidos, genera un número de cuenta aleatorio y establece
    * el ID del cliente actual en el objeto CuentaNuevaDTO.
    * En caso de error, muestra un mensaje de advertencia en la ventana.
    */
    public void validarDatos() {
           ValidadorCampos valida = new ValidadorCampos();
           try {
               cuentaNueva.esValido();
               valida.validaCuenta(cuentaNueva);
               cuentaNueva.setNumeroCuenta(generaNumeroCuenta());
               cuentaNueva.setIdCliente(clienteActual.getIdCliente());
               camposValidados = true;
           } catch (ValidacionDTOException ex) {
               camposValidados = false;
               ventana.mostrarAviso(ex.getMessage());
   //            Logger.getLogger(VistaRegistro.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
    
    /**
    * Registra la nueva cuenta en la base de datos.
    * Utiliza un objeto ICuentaDAO para interactuar con la capa de persistencia.
    * Muestra un mensaje informativo en la ventana cuando la cuenta se ha creado
    * exitosamente. En caso de error, registra un mensaje de error en el registro.
    */
    private void registrarCuenta(){
           try {
               ICuentaDAO cuentaDAO = new CuentaDAO(ventana.getConexion());
               Cuenta cuentaCreada = cuentaDAO.agregar(cuentaNueva);

               ventana.mostrarInformacion("La cuenta "+ cuentaCreada.getNombreCuenta()+" ha sido agregada", TOOL_TIP_TEXT_KEY);
           } catch (PersistenciaException ex) {
               Logger.getLogger(VistaCrearCuenta.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
 
    /**
     * Método que genera un número de cuenta aleatorio asegurando que ya no exista
     * en la base datos .
     * @return La cadena que representa el número de cuenta generado.
     */
    private String generaNumeroCuenta() throws ValidacionDTOException{
            Random random = new Random();
            int numeroAleatorio = random.nextInt(100000); // Genera un número entre 0 y 99999
            String numeroAleatorioStr = String.format("%05d", numeroAleatorio); // Asegura que tenga cuatro dígitos
            // Construir el número con el prefijo "2710"
            String numeroCuenta = "2710" + numeroAleatorioStr;
            
            return numeroCuenta;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnCrearCuenta;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel iconAjustes;
    private javax.swing.JLabel iconCerrarSesion;
    private javax.swing.JLabel iconHistorial;
    private javax.swing.JLabel iconInicio;
    private javax.swing.JLabel iconLogo;
    private javax.swing.JLabel iconPerfil;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JLabel lblUsuario2;
    private javax.swing.JLabel lblUsuario3;
    private javax.swing.JTextField txtNombreCuenta;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}
