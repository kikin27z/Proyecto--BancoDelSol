package bancodelsol;


/**
 *
 * @author karim
 */
public class VistaRegistro2 extends javax.swing.JPanel {

    /**
     * Creates new form VistaRegistro
     */
    private  Ventana ventana;
    /**
     * Creates new form VistaCliente
     */
    public VistaRegistro2(Ventana ventana ) {
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
        txtColonia = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();
        txtCalle = new javax.swing.JTextField();
        txtNumExterior = new javax.swing.JTextField();
        txtCodigoPostal = new javax.swing.JTextField();
        lblCodigoPostal = new javax.swing.JLabel();
        lblIndicador1 = new javax.swing.JLabel();
        lblIndicador2 = new javax.swing.JLabel();
        lblIndicador3 = new javax.swing.JLabel();
        lblCalle = new javax.swing.JLabel();
        lblNumExterior = new javax.swing.JLabel();
        lblColonia = new javax.swing.JLabel();
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

        txtColonia.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        txtColonia.setForeground(new java.awt.Color(143, 143, 143));
        txtColonia.setBorder(null);
        add(txtColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 375, 296, 36));

        txtCiudad.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        txtCiudad.setForeground(new java.awt.Color(143, 143, 143));
        txtCiudad.setBorder(null);
        add(txtCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 375, 296, 36));

        txtCalle.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        txtCalle.setForeground(new java.awt.Color(143, 143, 143));
        txtCalle.setBorder(null);
        add(txtCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 287, 208, 36));

        txtNumExterior.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        txtNumExterior.setForeground(new java.awt.Color(143, 143, 143));
        txtNumExterior.setBorder(null);
        add(txtNumExterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 287, 179, 36));

        txtCodigoPostal.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        txtCodigoPostal.setForeground(new java.awt.Color(143, 143, 143));
        txtCodigoPostal.setBorder(null);
        add(txtCodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 287, 177, 36));

        lblCodigoPostal.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        lblCodigoPostal.setForeground(new java.awt.Color(157, 134, 90));
        lblCodigoPostal.setText("Código postal:");
        add(lblCodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(626, 260, -1, 24));

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

        lblCalle.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        lblCalle.setForeground(new java.awt.Color(157, 134, 90));
        lblCalle.setText("Calle:");
        add(lblCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, -1, 24));

        lblNumExterior.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        lblNumExterior.setForeground(new java.awt.Color(157, 134, 90));
        lblNumExterior.setText("# exterior:");
        add(lblNumExterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 260, -1, 24));

        lblColonia.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        lblColonia.setForeground(new java.awt.Color(157, 134, 90));
        lblColonia.setText("Colonia:");
        add(lblColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 343, -1, 24));

        lblApellidoMaterno.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        lblApellidoMaterno.setForeground(new java.awt.Color(157, 134, 90));
        lblApellidoMaterno.setText("Ciudad:");
        add(lblApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 343, -1, 24));

        lblTitulo.setFont(new java.awt.Font("Amazon Ember", 1, 54)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(143, 143, 143));
        lblTitulo.setText("Domicilio");
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 130, -1, -1));

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

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgRegistrarse2.png"))); // NOI18N
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
    private javax.swing.JLabel lblBanco;
    private javax.swing.JLabel lblCalle;
    private javax.swing.JLabel lblCodigoPostal;
    private javax.swing.JLabel lblColonia;
    private javax.swing.JLabel lblIndicador1;
    private javax.swing.JLabel lblIndicador2;
    private javax.swing.JLabel lblIndicador3;
    private javax.swing.JLabel lblNumExterior;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtCodigoPostal;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextField txtNumExterior;
    // End of variables declaration//GEN-END:variables


    
}
