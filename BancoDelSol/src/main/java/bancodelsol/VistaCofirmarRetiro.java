/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package bancodelsol;

/**
 *
 * @author rover
 */
public class VistaCofirmarRetiro extends javax.swing.JPanel {

    /**
     * Creates new form VistaCofirmarRetiro
     */
    public VistaCofirmarRetiro() {
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

        lblConfirmar = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblConfirmar.setFont(new java.awt.Font("Amazon Ember", 1, 40)); // NOI18N
        lblConfirmar.setForeground(new java.awt.Color(143, 143, 143));
        lblConfirmar.setText("Confirmar");
        add(lblConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgConfirmarRetiroSinCuenta.png"))); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel lblConfirmar;
    // End of variables declaration//GEN-END:variables
}
