package vista;

import modelo.Usuario;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal(Usuario usuario) {
        setTitle("Sistema Restaurante Casa Grande");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        JLabel lblBienvenida = new JLabel("Bienvenido " + usuario.getNombre() + " - Rol: " + usuario.getRol(), SwingConstants.CENTER);
        lblBienvenida.setFont(new Font("Arial", Font.BOLD, 18));

        add(lblBienvenida);
    }
}
