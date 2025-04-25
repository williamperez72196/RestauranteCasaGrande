package controlador;

import modelo.Usuario;
import conexion.ConexionDB;
import java.sql.*;

public class UsuarioControlador {

    // Insertar un usuario
    public boolean insertarUsuario(Usuario usuario) {
        try (Connection con = ConexionDB.conectar()) {
            String sql = "INSERT INTO usuarios (nombre, usuario, clave, rol, estado, correo) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getClave());
            ps.setString(4, usuario.getRol());
            ps.setBoolean(5, usuario.isEstado());
            ps.setString(6, usuario.getCorreo());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener usuario por ID
    public Usuario obtenerUsuario(int id) {
        try (Connection con = ConexionDB.conectar()) {
            String sql = "SELECT * FROM usuarios WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("usuario"),
                    rs.getString("clave"),
                    rs.getString("rol"),
                    rs.getBoolean("estado"),
                    rs.getString("correo")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Actualizar usuario
    public boolean actualizarUsuario(Usuario usuario) {
        try (Connection con = ConexionDB.conectar()) {
            String sql = "UPDATE usuarios SET nombre = ?, usuario = ?, clave = ?, rol = ?, estado = ?, correo = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getClave());
            ps.setString(4, usuario.getRol());
            ps.setBoolean(5, usuario.isEstado());
            ps.setString(6, usuario.getCorreo());
            ps.setInt(7, usuario.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar usuario
    public boolean eliminarUsuario(int id) {
        try (Connection con = ConexionDB.conectar()) {
            String sql = "DELETE FROM usuarios WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Autenticar usuario (login)
    public Usuario autenticar(String usuario, String clave) {
        try (Connection con = ConexionDB.conectar()) {
            String sql = "SELECT * FROM usuarios WHERE usuario = ? AND clave = ? AND estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("usuario"),
                    rs.getString("clave"),
                    rs.getString("rol"),
                    rs.getBoolean("estado"),
                    rs.getString("correo")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

