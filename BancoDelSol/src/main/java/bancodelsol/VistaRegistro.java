package bancodelsol;

import org.jdatepicker.JDatePanel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Properties;

/**
 *
 * @author karim
 */
public class VistaRegistro extends javax.swing.JPanel {

    /**
     * Creates new form VistaRegistro
     */
    private  Ventana ventana;
    /**
     * Creates new form VistaCliente
     */
    public VistaRegistro(Ventana ventana ) {
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
        fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBanco.setFont(new java.awt.Font("TrajanusBricks", 0, 36)); // NOI18N
        lblBanco.setForeground(new java.awt.Color(149, 120, 64));
        lblBanco.setText("BANCO DEL SOL");
        add(lblBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 21, -1, -1));

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

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgRegistrarse1.png"))); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 580));
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel lblApellidoMaterno;
    private javax.swing.JLabel lblApellidoPaterno;
    private javax.swing.JLabel lblBanco;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblIndicador1;
    private javax.swing.JLabel lblIndicador2;
    private javax.swing.JLabel lblIndicador3;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables


    public void ponerCalendario(){
        UtilDateModel model = new UtilDateModel();
        Properties properties = new Properties();
        properties.put("text.today", "Today");
        properties.put("text.month", "Month");
        properties.put("text.year", "Year");

//        JDatePanel datePanel = new JDatePanel(model, properties);
        JDatePanel datePanel = new JDatePanel(model);
        this.add(datePanel);
    }
}
