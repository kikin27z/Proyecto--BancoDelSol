package bancodelsol;

import bancodelsol.validaciones.ValidadorCampos;
import bancodelsolpersistencia.excepciones.ValidacionDTOException;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;

/**
 * Clase que representa la primera ventana de registro de clientes. En la
 * sección de datos personales.
 *
 * @author José Karim Franco Valencia - 245138
 */
public class VistaRegistro extends javax.swing.JPanel {

    private Ventana ventana;
    private Boolean camposValidos = false;

    /**
     * Constructor de la vista de registro.
     *
     * @param ventana JFrame donde se colocará este JPanel.
     */
    public VistaRegistro(Ventana ventana) {
        this.ventana = ventana;
        initComponents();
        cargarDatos();
        restriccionEdad();
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
        txtApellidoPaterno = new javax.swing.JTextField();
        txtApellidoMaterno = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        lblIndicador1 = new javax.swing.JLabel();
        lblIndicador2 = new javax.swing.JLabel();
        lblIndicador3 = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        lblFechaNacimiento = new javax.swing.JLabel();
        lblApellidoPaterno = new javax.swing.JLabel();
        lblApellidoMaterno = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        lblIcon = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBanco.setFont(new java.awt.Font("TrajanusBricks", 0, 36)); // NOI18N
        lblBanco.setForeground(new java.awt.Color(149, 120, 64));
        lblBanco.setText("banco del sol");
        add(lblBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 14, -1, -1));

        txtApellidoPaterno.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        txtApellidoPaterno.setForeground(new java.awt.Color(143, 143, 143));
        txtApellidoPaterno.setBorder(null);
        add(txtApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 375, 296, 36));

        txtApellidoMaterno.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        txtApellidoMaterno.setForeground(new java.awt.Color(143, 143, 143));
        txtApellidoMaterno.setBorder(null);
        add(txtApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 375, 296, 36));

        txtNombre.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(143, 143, 143));
        txtNombre.setBorder(null);
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 287, 297, 36));

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

        lblNombres.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        lblNombres.setForeground(new java.awt.Color(157, 134, 90));
        lblNombres.setText("Nombres:");
        add(lblNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, -1, 24));

        lblFechaNacimiento.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        lblFechaNacimiento.setForeground(new java.awt.Color(157, 134, 90));
        lblFechaNacimiento.setText("Fecha de nacimiento:");
        add(lblFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, -1, 24));

        lblApellidoPaterno.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        lblApellidoPaterno.setForeground(new java.awt.Color(157, 134, 90));
        lblApellidoPaterno.setText("Apellido paterno:");
        add(lblApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 343, -1, 24));

        lblApellidoMaterno.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        lblApellidoMaterno.setForeground(new java.awt.Color(157, 134, 90));
        lblApellidoMaterno.setText("Apellido materno:");
        add(lblApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 343, -1, 24));

        lblTitulo.setFont(new java.awt.Font("Amazon Ember", 1, 54)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(143, 143, 143));
        lblTitulo.setText("Datos personales");
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, -1, -1));

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
        add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 430, 142, 45));

        jdcFecha.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        jdcFecha.setMaxSelectableDate(new java.util.Date(253370793714000L));
        jdcFecha.setMinSelectableDate(new java.util.Date(-62135740686000L));
        add(jdcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 288, 302, 34));

        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconLogo(2).png"))); // NOI18N
        add(lblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgRegistrarse1(2).png"))); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 580));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Redirige a la pantalla de inicio del banco.
     *
     * @param evt Evento de un clic en un botón.
     */
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        ventana.setClienteDTO(null);
        ventana.setDomicilioDTO(null);
        ventana.cambiarVistaInicio();
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * Redirige a la pantalla de registro en la sección de datos del domicilio.
     *
     * @param evt Evento de un clic en un botón.
     */
    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        guardarDatosCliente();
        validarDatos();
        if (camposValidos) {
            ventana.cambiarVistaRegistrarse2();
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel fondo;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JLabel lblApellidoMaterno;
    private javax.swing.JLabel lblApellidoPaterno;
    private javax.swing.JLabel lblBanco;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblIndicador1;
    private javax.swing.JLabel lblIndicador2;
    private javax.swing.JLabel lblIndicador3;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    public void validarDatos() {
        ValidadorCampos valida = new ValidadorCampos();
        try {
            ventana.getClienteDTO().esValido();
            valida.validaSeccionDatosPersonales(ventana.getClienteDTO());
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
        ventana.getClienteDTO().setNombres(txtNombre.getText());
        ventana.getClienteDTO().setApellidoPaterno(txtApellidoPaterno.getText());
        ventana.getClienteDTO().setApellidoMaterno(txtApellidoMaterno.getText());
        if (jdcFecha.getDate() != null) {
            java.sql.Date fechaNacimiento = new java.sql.Date(jdcFecha.getDate().getTime());
            ventana.getClienteDTO().setFecha(fechaNacimiento.toString());
        }
    }

    /**
     * Método que carga los datos del formulario y los inserta en los campos, en
     * caso de volver a una página anterior.
     */
    public void cargarDatos() {
        // Obtener el campo de texto asociado al JDateChooser
        JFormattedTextField textField = ((JFormattedTextField) jdcFecha.getDateEditor().getUiComponent());
        textField.setBackground(new Color(253, 253, 253));
        textField.setForeground(new Color(0,0,0));
        // Deshabilitar la edición del campo de texto
        textField.setEditable(false);
//        textField.setText("");
        if (ventana.getClienteDTO() != null && ventana.getClienteDTO().getNombres() != null) {
            txtNombre.setText(ventana.getClienteDTO().getNombres());
            txtApellidoPaterno.setText(ventana.getClienteDTO().getApellidoPaterno());
            txtApellidoMaterno.setText(ventana.getClienteDTO().getApellidoMaterno());

            String format = "yyyy-MM-dd";

            SimpleDateFormat sdf = new SimpleDateFormat(format);

            Date date = null;
            try {
                date = sdf.parse(ventana.getClienteDTO().getFecha());
            } catch (ParseException ex) {
                Logger.getLogger(VistaRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }
            jdcFecha.setDate(date);
        }
    }

    public final void restriccionEdad() {
        Calendar calendar = Calendar.getInstance();
        Date fechaActual = calendar.getTime();

        // Calcular la fecha mínima (hace 120 años desde la fecha actual)
        calendar.add(Calendar.YEAR, -120);
        Date fechaMinima = calendar.getTime();

        // Calcular la fecha máxima (hace 18 años desde la fecha actual)
        calendar.setTime(fechaActual);
        calendar.add(Calendar.YEAR, -18);
        Date fechaMaxima = calendar.getTime();

        // Establece el rango de fechas permitidas en el JDateChooser
        jdcFecha.setSelectableDateRange(fechaMinima, fechaMaxima);
    }
}
