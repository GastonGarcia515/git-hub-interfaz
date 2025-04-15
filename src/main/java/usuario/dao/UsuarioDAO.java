package usuario.dao;

import java.sql.*;

public class UsuarioDAO {
    public static boolean validarUsuario(String usuario, String password, String rol) {
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND password = ? AND rol = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            stmt.setString(2, password);
            stmt.setString(3, rol);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // True si hay coincidencia
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}