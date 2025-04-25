package vista;

import controlador.UsuarioControlador;
import modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtClave;
    private UsuarioControlador controlador;

    public LoginFrame() {
        controlador = new UsuarioControlador();
        setTitle("Login - Restaurante Casa Grande");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelCampos = new JPanel(new GridLayout(3, 2, 10, 10));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblUsuario = new JLabel("Usuario:");
        JLabel lblClave = new JLabel("Clave:");

        txtUsuario = new JTextField();
        txtClave = new JPasswordField();

        JButton btnLogin = new JButton("Iniciar Sesión");
        btnLogin.addActionListener(this::iniciarSesion);

        panelCampos.add(lblUsuario);
        panelCampos.add(txtUsuario);
        panelCampos.add(lblClave);
        panelCampos.add(txtClave);
        panelCampos.add(new JLabel());  // espacio vacío
        panelCampos.add(btnLogin);

        add(panelCampos, BorderLayout.CENTER);
    }

    private void iniciarSesion(ActionEvent e) {
        String usuario = txtUsuario.getText();
        String clave = new String(txtClave.getPassword());

        Usuario u = controlador.autenticar(usuario, clave);

        if (u != null) {
            JOptionPane.showMessageDialog(this, "Bienvenido, " + u.getNombre() + " (" + u.getRol() + ")");
            new VentanaPrincipal(u).setVisible(true);
            this.dispose();  // Cerrar login
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o clave incorrectos.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}

