package bancodelsol;

import bancodelsoldominio.Cliente;

/**
 *
 * @author karim
 */
public class Ventana extends javax.swing.JFrame {
    private Cliente cliente;
    /**
     * Creates new form Ventana
     */
    public Ventana() {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 580));
        setMinimumSize(new java.awt.Dimension(1000, 580));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void cambiarVistaCliente(){
       
        VistaCliente vistaClienta = new VistaCliente(this);
        
        this.add(vistaClienta);
        vistaClienta.setBounds(0, 0, 1000, 580);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void cambiarVistaCuenta(Long idCuenta){
       
        VistaCuenta vistaCuenta = new VistaCuenta(this,idCuenta);
        
        this.add(vistaCuenta);
        vistaCuenta.setBounds(0, 0, 1000, 580);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void cambiarVistaTransferir(Long idCuenta){
       
        VistaTransferir vistaTransferencia = new VistaTransferir(this,idCuenta);
        
        this.add(vistaTransferencia);
        vistaTransferencia.setBounds(0, 0, 1000, 580);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void limpiarFrame(){
         this.removeAll();

        // Actualizar la interfaz gráfica
            this.revalidate();
        this.repaint();
    }
}
