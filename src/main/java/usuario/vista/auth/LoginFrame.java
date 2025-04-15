package usuario.vista.auth;

import usuario.dao.UsuarioDAO;
import usuario.vista.empleado.EmpleadoMenuFrame;
import usuario.vista.gerente.GerenteMenuFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {
    private JComboBox<String> rolComboBox;
    private JTextField usuarioField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("Login - Bar System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.add(new JLabel("Rol:"));
        rolComboBox = new JComboBox<>(new String[]{"Gerente", "Empleado"});
        panel.add(rolComboBox);

        panel.add(new JLabel("Usuario:"));
        usuarioField = new JTextField();
        panel.add(usuarioField);

        panel.add(new JLabel("Contraseña:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginButton = new JButton("Ingresar");
        loginButton.addActionListener(this::handleLogin);
        panel.add(loginButton);

        add(panel);
    }

    private void handleLogin(ActionEvent e) {
        String usuario = usuarioField.getText();
        String password = new String(passwordField.getPassword());
        String rol = (String) rolComboBox.getSelectedItem();

        if (UsuarioDAO.validarUsuario(usuario, password, rol)) {
            if (rol.equals("Gerente")) {
                new GerenteMenuFrame().setVisible(true);
            } else {
                new EmpleadoMenuFrame().setVisible(true);
            }
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales inválidas");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}