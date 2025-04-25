package vista;

import controlador.UsuarioControlador;
import modelo.Usuario;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        UsuarioControlador controlador = new UsuarioControlador();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Sistema Restaurante Casa Grande ===");

        // 1. Crear un nuevo usuario de prueba
        Usuario nuevo = new Usuario();
        nuevo.setNombre("Juan Pérez");
        nuevo.setUsuario("juanp");
        nuevo.setClave("1234");
        nuevo.setRol("Mesero");
        nuevo.setEstado(true);
        nuevo.setCorreo("juanperez@email.com");
        if (controlador.insertarUsuario(nuevo)) {
            System.out.println("✅ Usuario insertado exitosamente.");
        }

        // 2. Autenticación
        System.out.print("Usuario: ");
        String usr = sc.nextLine();
        System.out.print("Clave: ");
        String pwd = sc.nextLine();

        Usuario logueado = controlador.autenticar(usr, pwd);
        if (logueado != null) {
            System.out.println("✅ Bienvenido, " + logueado.getNombre() + " (Rol: " + logueado.getRol() + ")");
        } else {
            System.out.println("❌ Usuario o clave incorrectos.");
        }

        // 3. Consulta de usuario ID=1
        Usuario u = controlador.obtenerUsuario(1);
        if (u != null) {
            System.out.println("Usuario encontrado: " + u.getNombre() + " - " + u.getCorreo());
        }

        sc.close();
    }
}
