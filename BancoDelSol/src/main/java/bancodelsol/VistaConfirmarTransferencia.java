/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package bancodelsol;

/**
 *
 * @author karim
 */
public class VistaConfirmarTransferencia extends javax.swing.JPanel {

    /**
     * Creates new form VistaConfirmarTransferencia
     */
    public VistaConfirmarTransferencia() {
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

        lblTransferenciaInfo = new javax.swing.JLabel();
        lblFecha1 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblMonto = new javax.swing.JLabel();
        lblCuentaDestino = new javax.swing.JLabel();
        lblCuentaDestinoInfo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblConfirmar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTransferenciaInfo.setFont(new java.awt.Font("Amazon Ember", 1, 48)); // NOI18N
        lblTransferenciaInfo.setForeground(new java.awt.Color(143, 143, 143));
        lblTransferenciaInfo.setText("Transferencia exitosa");
        add(lblTransferenciaInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 163, -1, -1));

        lblFecha1.setFont(new java.awt.Font("Amazon Ember", 1, 20)); // NOI18N
        lblFecha1.setForeground(new java.awt.Color(143, 143, 143));
        lblFecha1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFecha1.setText("*************2677");
        add(lblFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 378, 305, -1));

        lblFecha.setFont(new java.awt.Font("Amazon Ember", 1, 20)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(143, 143, 143));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setText("Transferencia exitosa");
        add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 237, 305, -1));

        lblMonto.setFont(new java.awt.Font("Amazon Ember", 1, 40)); // NOI18N
        lblMonto.setForeground(new java.awt.Color(180, 154, 102));
        lblMonto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMonto.setText("$27.00 MXN");
        add(lblMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 271, 437, -1));

        lblCuentaDestino.setFont(new java.awt.Font("Amazon Ember", 1, 20)); // NOI18N
        lblCuentaDestino.setForeground(new java.awt.Color(143, 143, 143));
        lblCuentaDestino.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCuentaDestino.setText("*************2677");
        add(lblCuentaDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 378, 305, -1));

        lblCuentaDestinoInfo.setFont(new java.awt.Font("Amazon Ember", 1, 20)); // NOI18N
        lblCuentaDestinoInfo.setForeground(new java.awt.Color(143, 143, 143));
        lblCuentaDestinoInfo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCuentaDestinoInfo.setText("Cuenta destino:");
        add(lblCuentaDestinoInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 378, -1, -1));

        jPanel1.setBackground(new java.awt.Color(34, 33, 33));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Amazon Ember", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(157, 134, 90));
        jLabel1.setText("BANCO DEL SOL");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 17, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 80));

        lblConfirmar.setBackground(new java.awt.Color(180, 154, 102));
        lblConfirmar.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        lblConfirmar.setText("Confirmar");
        lblConfirmar.setBorderPainted(false);
        lblConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblConfirmarActionPerformed(evt);
            }
        });
        add(lblConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, 142, 45));
    }// </editor-fold>//GEN-END:initComponents

    private void lblConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblConfirmarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton lblConfirmar;
    private javax.swing.JLabel lblCuentaDestino;
    private javax.swing.JLabel lblCuentaDestinoInfo;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFecha1;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblTransferenciaInfo;
    // End of variables declaration//GEN-END:variables
}
