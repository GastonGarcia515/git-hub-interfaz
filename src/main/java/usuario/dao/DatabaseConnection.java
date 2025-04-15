package usuario.dao;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try (InputStream input = DatabaseConnection.class
                    .getResourceAsStream("/db/config.properties")) { // ¡Ruta corregida!

                Properties prop = new Properties();
                prop.load(input);

                String url = prop.getProperty("supabase.url");
                String user = prop.getProperty("supabase.user");
                String password = prop.getProperty("supabase.password");

                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage());
            }
        }
        return connection;
    }
}