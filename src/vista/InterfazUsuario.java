package vista;

import controlador.UsuarioControlador;
import modelo.Usuario;
import java.util.Scanner;

public class InterfazUsuario {

    private static Scanner scanner = new Scanner(System.in);
    private static UsuarioControlador controlador = new UsuarioControlador();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    consultarUsuario();
                    break;
                case 3:
                    actualizarUsuario();
                    break;
                case 4:
                    eliminarUsuario();
                    break;
                case 5:
                    autenticarUsuario();
                    break;
                case 6:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private static void mostrarMenu() {
        System.out.println("\n=== Menú de Opciones ===");
        System.out.println("1. Registrar Usuario");
        System.out.println("2. Consultar Usuario");
        System.out.println("3. Actualizar Usuario");
        System.out.println("4. Eliminar Usuario");
        System.out.println("5. Autenticar Usuario");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void registrarUsuario() {
        System.out.println("\n=== Registrar Usuario ===");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Clave: ");
        String clave = scanner.nextLine();
        System.out.print("Rol (Administrador, Mesero, Cocinero): ");
        String rol = scanner.nextLine();
        System.out.print("Correo: ");
        String correo = scanner.nextLine();

        Usuario nuevoUsuario = new Usuario(0, nombre, usuario, clave, rol, true, correo);
        if (controlador.insertarUsuario(nuevoUsuario)) {
            System.out.println("Usuario registrado exitosamente.");
        } else {
            System.out.println("Error al registrar el usuario.");
        }
    }

    private static void consultarUsuario() {
        System.out.println("\n=== Consultar Usuario ===");
        System.out.print("Ingrese ID del usuario: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer del scanner

        Usuario usuario = controlador.obtenerUsuario(id);
        if (usuario != null) {
            System.out.println("Usuario encontrado:");
            System.out.println("ID: " + usuario.getId());
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Usuario: " + usuario.getUsuario());
            System.out.println("Rol: " + usuario.getRol());
            System.out.println("Correo: " + usuario.getCorreo());
        } else {
            System.out.println("No se encontró el usuario.");
        }
    }

    private static void actualizarUsuario() {
        System.out.println("\n=== Actualizar Usuario ===");
        System.out.print("Ingrese ID del usuario a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer del scanner

        Usuario usuarioExistente = controlador.obtenerUsuario(id);
        if (usuarioExistente != null) {
            System.out.println("Usuario encontrado: " + usuarioExistente.getNombre());
            System.out.print("Nuevo nombre (deja en blanco para no cambiar): ");
            String nombre = scanner.nextLine();
            if (nombre.isEmpty()) nombre = usuarioExistente.getNombre();

            System.out.print("Nuevo usuario (deja en blanco para no cambiar): ");
            String usuario = scanner.nextLine();
            if (usuario.isEmpty()) usuario = usuarioExistente.getUsuario();

            System.out.print("Nueva clave (deja en blanco para no cambiar): ");
            String clave = scanner.nextLine();
            if (clave.isEmpty()) clave = usuarioExistente.getClave();

            System.out.print("Nuevo rol (deja en blanco para no cambiar): ");
            String rol = scanner.nextLine();
            if (rol.isEmpty()) rol = usuarioExistente.getRol();

            System.out.print("Nuevo correo (deja en blanco para no cambiar): ");
            String correo = scanner.nextLine();
            if (correo.isEmpty()) correo = usuarioExistente.getCorreo();

            usuarioExistente.setNombre(nombre);
            usuarioExistente.setUsuario(usuario);
            usuarioExistente.setClave(clave);
            usuarioExistente.setRol(rol);
            usuarioExistente.setCorreo(correo);

            if (controlador.actualizarUsuario(usuarioExistente)) {
                System.out.println("Usuario actualizado exitosamente.");
            } else {
                System.out.println("Error al actualizar el usuario.");
            }
        } else {
            System.out.println("No se encontró el usuario.");
        }
    }

    private static void eliminarUsuario() {
        System.out.println("\n=== Eliminar Usuario ===");
        System.out.print("Ingrese ID del usuario a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer del scanner

        if (controlador.eliminarUsuario(id)) {
            System.out.println("Usuario eliminado exitosamente.");
        } else {
            System.out.println("Error al eliminar el usuario.");
        }
    }

    private static void autenticarUsuario() {
        System.out.println("\n=== Autenticar Usuario ===");
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Clave: ");
        String clave = scanner.nextLine();

        Usuario usuarioAutenticado = controlador.autenticar(usuario, clave);
        if (usuarioAutenticado != null) {
            System.out.println("Bienvenido, " + usuarioAutenticado.getNombre() + " (Rol: " + usuarioAutenticado.getRol() + ")");
        } else {
            System.out.println("Usuario o clave incorrectos.");
        }
    }
}
