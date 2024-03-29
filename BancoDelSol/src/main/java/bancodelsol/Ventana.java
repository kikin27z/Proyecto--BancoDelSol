package bancodelsol;

import bancodelsol.dtos.ClienteNuevoDTO;
import bancodelsol.dtos.DomicilioNuevoDTO;
import bancodelsoldominio.Cliente;
import bancodelsoldominio.Cuenta;
import bancodelsoldominio.Domicilio;
import bancodelsoldominio.Retiro;
import bancodelsoldominio.Transferencia;
import bancodelsolpersistencia.conexion.IConexion;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * La clase Ventana representa la ventana principal de la aplicación bancaria.
 * Se encarga de gestionar la navegación entre diferentes vistas de la interfaz
 * de usuario, así como de interactuar con el usuario mediante ventanas
 * emergentes. También mantiene instancias de DTOs y una conexión a la base de
 * datos.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class Ventana extends javax.swing.JFrame {

    private Cliente cliente;
    private Cuenta cuenta;
    private Domicilio domicilio;
    private Transferencia transferencia;
    private Retiro retiro;
    private ClienteNuevoDTO clienteDTO;
    private DomicilioNuevoDTO domicilioDTO;
    private JPanel panelActual;
    private IConexion conexion;

    /**
     * Constructor de la clase Ventana.
     *
     * @param conexion Objeto que representa la conexión a la base de datos.
     */
    public Ventana(IConexion conexion) {
        this.conexion = conexion;
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
        setTitle("Banco del Sol");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
    /**
     * Método para limpiar el contenido de la ventana. Si hay un panel
     * actualmente mostrado, lo elimina de la ventana.
     */
    public void limpiarFrame() {
        if (panelActual != null) {
            this.remove(panelActual);
            panelActual = null;
        }
    }

    /**
     * Método para cambiar a la vista de inicio del banco. Este método elimina
     * el panel actual y muestra la vista de inicio del banco.
     */
    public void cambiarVistaInicio() {
        limpiarFrame();
        VistaInicio vistaInicio = new VistaInicio(this);
        ponerEnJFrame(vistaInicio);
        panelActual = vistaInicio;
    }

    /**
     * Método para cambiar a la vista del cliente. Este método elimina el panel
     * actual y muestra la vista a la pantalla del cliente.
     */
    public void cambiarVistaCliente() {
        limpiarFrame();
        VistaCliente vistaClienta = new VistaCliente(this);
        ponerEnJFrame(vistaClienta);
        panelActual = vistaClienta;
    }

    /**
     * Método para cambiar a la vista de una cuenta en especifico del cliente.
     * Este método elimina el panel actual y muestra la vista a la pantalla de
     * la cuenta del cliente.
     */
    public void cambiarVistaCuenta() {
        this.limpiarFrame();
        VistaCuenta vistaCuenta = new VistaCuenta(this);
        ponerEnJFrame(vistaCuenta);
        panelActual = vistaCuenta;
    }

    /**
     * Método para cambiar a la vista del apartado de transferencias. Este
     * método elimina el panel actual y muestra el apartado de transferencias.
     */
    public void cambiarVistaTransferir() {
        this.limpiarFrame();
        VistaTransferir vistaTransferencia = new VistaTransferir(this);
        ponerEnJFrame(vistaTransferencia);
        panelActual = vistaTransferencia;
    }

    /**
     * Método para cambiar a la vista de inicio de sesión. Este método elimina
     * el panel actual y muestra la vista de inicio de sesión en su lugar.
     */
    public void cambiarVistaInicioSesion() {
        limpiarFrame();
        VistaInicioSesion vistaInicioSesion = new VistaInicioSesion(this);
        ponerEnJFrame(vistaInicioSesion);
        panelActual = vistaInicioSesion;
    }

    /**
     * Método para cambiar a la vista de registro. Este método inicializa los
     * DTOs necesarios y cambia a la vista de registro inicial.
     */
    public void cambiarVistaRegistro() {
        this.clienteDTO = new ClienteNuevoDTO();
        this.domicilioDTO = new DomicilioNuevoDTO();
        cambiarVistaRegistrarse();
    }

    /**
     * Método para cambiar a la vista de registro del cliente. Este método
     * elimina el panel actual y muestra la vista de registro en su lugar.
     */
    public void cambiarVistaRegistrarse() {
        limpiarFrame();
        VistaRegistro vistaRegistro = new VistaRegistro(this);
        ponerEnJFrame(vistaRegistro);
        panelActual = vistaRegistro;
    }

    /**
     * Método para cambiar a la segunda parte del registro de cliente. Este
     * método elimina el panel actual y muestra la segunda vista de registro en
     * su lugar.
     */
    public void cambiarVistaRegistrarse2() {
        limpiarFrame();
        VistaRegistro2 vistaRegistro = new VistaRegistro2(this);
        ponerEnJFrame(vistaRegistro);
        panelActual = vistaRegistro;
    }

    /**
     * Método para cambiar a la tercera parte del registro de cliente. Este
     * método elimina el panel actual y muestra la tercera vista de registro en
     * su lugar.
     */
    public void cambiarVistaRegistrarse3() {
        limpiarFrame();
        VistaRegistro3 vistaRegistro = new VistaRegistro3(this);
        ponerEnJFrame(vistaRegistro);
        panelActual = vistaRegistro;
    }
    /**
     * Método para cambiar a la ventana para crear una cuenta de un cliente.
    * Este método elimina el panel actual y muestra la pestaña de crear una nueva cuenta.
     */
    public void cambiarVistaCrearCuenta() {
        limpiarFrame();
        VistaCrearCuenta vistaCrearCuenta = new VistaCrearCuenta(this);
        ponerEnJFrame(vistaCrearCuenta);
        panelActual = vistaCrearCuenta;
    }
    /**
    * Método para cambiar a la ventana del historial de operaciones del cliente.
    * Este método elimina el panel actual y muestra la pestaña de historial de operaciones.
     */
    public void cambiarVistaHistorial() {
        limpiarFrame();
        VistaHistorial vistaHistorial = new VistaHistorial(this);
        ponerEnJFrame(vistaHistorial);
        panelActual = vistaHistorial;
    }
    /**
    * Método para cambiar a la ventana de editar perfil del cliente.
    * Este método elimina el panel actual y muestra la pestaña de historial de operaciones.
     */
    public void cambiarVistaEditarPerfil() {
        limpiarFrame();
        VistaEditarPerfil vistaEditarPerfil = new VistaEditarPerfil(this);
        ponerEnJFrame(vistaEditarPerfil);
        panelActual = vistaEditarPerfil;
    }
    /**
    * Método para cambiar a la ventana muestra la información completa de la transfencia.
    * Este método elimina el panel actual y muestra la pestaña de historial de operaciones.
     */
    public void cambiarVistaTransferenciaExitosa() {
        limpiarFrame();
        VistaTransferenciaExitosa vistaTransferenciaExitosa = new VistaTransferenciaExitosa(this);
        ponerEnJFrame(vistaTransferenciaExitosa);
        panelActual = vistaTransferenciaExitosa;
    }

    /**
     * Método para cambiar a la ventana de generar un retiro sin cuenta Este
     * método elimina el panel actual y muestra la pestaña de historial de
     * operaciones.
     */
    public void cambiarVistaGenerarRetiro() {
        limpiarFrame();
        VistaGenerarRetiro vistaGenerarRetiro = new VistaGenerarRetiro(this);
        ponerEnJFrame(vistaGenerarRetiro);
        panelActual = vistaGenerarRetiro;
    }

    /**
     * Método para cambiar a la ventana de generar un retiro sin cuenta Este
     * método elimina el panel actual y muestra la pestaña de historial de
     * operaciones.
     */
    public void cambiarVistaConfirmarRetiro() {
        limpiarFrame();
        VistaCofirmarRetiro vistaConfirmarRetiro = new VistaCofirmarRetiro(this);
        ponerEnJFrame(vistaConfirmarRetiro);
        panelActual = vistaConfirmarRetiro;
    }
    /**
    * Método para cambiar a la ventana de nosotros del banco.
    * Este método elimina el panel actual y muestra la pestaña de historial de operaciones.
    */
    public void cambiarVistaNosotros(){
        limpiarFrame();
        VistaNosotros vistaNosotros = new  VistaNosotros(this);
        ponerEnJFrame(vistaNosotros);
        panelActual = vistaNosotros;
    }
    
    /**
     * Método para cambiar a la ventana de generar un retiro sin cuenta Este
     * método elimina el panel actual y muestra la pestaña de historial de
     * operaciones.
     */
    public void cambiarVistaMostrarDatosRegistro() {
        limpiarFrame();
        vistaMostrarDatosRetiro vistaMostrarDatosRetiro = new vistaMostrarDatosRetiro(this);
        ponerEnJFrame(vistaMostrarDatosRetiro);
        panelActual = vistaMostrarDatosRetiro;
    }
    
    /**
     * Método para cambiar a la ventana de generar un retiro sin cuenta Este
     * método elimina el panel actual y muestra la pestaña de historial de
     * operaciones.
     */
    public void cambiarVistaEfectuarRetiro() {
        limpiarFrame();
        VistaEfectuarRetiro vistaEfectuarRetiro = new VistaEfectuarRetiro(this);
        ponerEnJFrame(vistaEfectuarRetiro);
        panelActual = vistaEfectuarRetiro;
    }
    
    /**
     * Método para cambiar a la ventana de generar un retiro sin cuenta Este
     * método elimina el panel actual y muestra la pestaña de historial de
     * operaciones.
     */
    public void cambiarVistaConfirmarEfectuarRetiro() {
        limpiarFrame();
        VistaConfirmarEfectuarRetiro vistaConfirmarEfectuarRetiro = new VistaConfirmarEfectuarRetiro(this);
        ponerEnJFrame(vistaConfirmarEfectuarRetiro);
        panelActual = vistaConfirmarEfectuarRetiro;
    }

    /**
     * Método para cambiar a la vista del cliente. Este método elimina el panel
     * actual y muestra la vista a la pantalla del cliente.
     */
    public void cambiarVistaInformacionRetiro() {
        limpiarFrame();
        VistaInformacionRetiro vistaInformacionRetiro = new VistaInformacionRetiro(this);
        ponerEnJFrame(vistaInformacionRetiro);
        panelActual = vistaInformacionRetiro;
    }
    
    /**
     * Método para agregar un panel a la ventana. Este método agrega el panel
     * especificado a la ventana, lo posiciona y ajusta su tamaño
     * automáticamente.
     *
     * @param panel El panel que se va a agregar a la ventana.
     */
    public void ponerEnJFrame(JPanel panel) {
        this.add(panel);
        panel.setBounds(0, 0, 1000, 580);
        this.setLocationRelativeTo(null);
        this.pack();  // Ajustar el tamaño automáticamente
    }

    /**
     * Método para mostrar un aviso al usuario mediante una ventana emergente.
     *
     * @param mensaje El mensaje a mostrar en el aviso.
     */
    public void mostrarAviso(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Aviso", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Método para mostrar una ventana emergente de confirmación al usuario.
     *
     * @param mensaje El mensaje a mostrar en la ventana de confirmación.
     * @param titulo El título de la ventana de confirmación.
     * @return true si el usuario selecciona "OK", false si selecciona
     * "Cancelar".
     */
    public boolean mostrarConfirmacion(String mensaje, String titulo) {
        int respuesta = JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.OK_CANCEL_OPTION);
        return respuesta == JOptionPane.OK_OPTION;
    }

    /**
     * Método para mostrar una ventana emergente de información al usuario.
     *
     * @param mensaje El mensaje a mostrar en la ventana de información.
     * @param titulo El título de la ventana de información.
     */
    public void mostrarInformacion(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método para obtener la conexión a la base de datos.
     *
     * @return La conexión a la base de datos.
     */
    public IConexion getConexion() {
        return conexion;
    }

    /**
     * Método para obtener el cliente actual.
     *
     * @return El cliente actual.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Método para establecer el cliente actual.
     *
     * @param cliente El cliente actual a establecer.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Método para obtener la cuenta actual del cliente.
     *
     * @return La cuenta actual.
     */
    public Cuenta getCuenta() {
        return cuenta;
    }

    /**
     * Método para establecer el cuenta actual del cliente.
     *
     * @param cuenta El cuanta actual a establecer.
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Método para obtener el DTO del cliente.
     *
     * @return El DTO del cliente.
     */
    public ClienteNuevoDTO getClienteDTO() {
        return clienteDTO;
    }

    /**
     * Método para establecer el DTO del cliente.
     *
     * @param clienteDTO El DTO del cliente a establecer.
     */
    public void setClienteDTO(ClienteNuevoDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }

    /**
     * Método para obtener el DTO del domicilio.
     *
     * @return El DTO del domicilio.
     */
    public DomicilioNuevoDTO getDomicilioDTO() {
        return domicilioDTO;
    }

    /**
     * Método para establecer el DTO del domicilio.
     *
     * @param domicilioDTO El DTO del domicilio a establecer.
     */
    public void setDomicilioDTO(DomicilioNuevoDTO domicilioDTO) {
        this.domicilioDTO = domicilioDTO;
    }

    /**
     * Devuelve la transferencia asociada a esta instancia.
     *
     * @return la transferencia asociada
     */
    public Transferencia getTransferencia() {
        return transferencia;
    }

    /**
     * Establece la transferencia asociada a esta instancia.
     *
     * @param transferencia la transferencia a establecer
     */
    public void setTransferencia(Transferencia transferencia) {
        this.transferencia = transferencia;
    }

    /**
     * Devuelve el domicilio asociado a esta instancia.
     *
     * @return el domicilio asociado
     */
    public Domicilio getDomicilio() {
        return domicilio;
    }

    /**
     * Establece el domicilio asociado a esta instancia.
     *
     * @param domicilio el domicilio a establecer
     */
    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * Establece el retiro asociado a esta instancia.
     *
     * @param retiro el retiro a establecer
     */
    public void setRetiro(Retiro retiro) {
        this.retiro = retiro;
    }

    /**
     * Devuelve el retiro asociado a esta instancia.
     *
     * @return el retiro asociado
     */
    public Retiro getRetiro() {
        return retiro;
    }

}
