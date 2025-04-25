package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/restaurante_casa_grande";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = ""; // Déjalo vacío si no usas contraseña

    public static Connection conectar() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("✅ Conexión exitosa a la base de datos");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("❌ Error al conectar a la base de datos: " + e.getMessage());
        }
        return conexion;
    }
}
