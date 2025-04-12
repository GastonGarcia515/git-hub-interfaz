import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroEmpleados extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public RegistroEmpleados() {
        setTitle("Registro de Empleados");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiquetas y campos
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nombre de Usuario:"), gbc);

        gbc.gridx = 1;
        usernameField = new JTextField(15);
        panel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Contraseña:"), gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField(15);
        panel.add(passwordField, gbc);

        // Botón de registro
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Ocupa dos columnas
        JButton registerButton = new JButton("Registrar");
        registerButton.setPreferredSize(new Dimension(100, 30)); // Tamaño del botón
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarEmpleado();
            }
        });
        panel.add(registerButton, gbc);

        // Botón de iniciar sesión
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // Ocupa dos columnas
        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();
            }
        });
        panel.add(loginButton, gbc);

        // Agregar panel a la ventana
        add(panel);
    }

    private void registrarEmpleado() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Aquí puedes agregar la lógica para registrar al empleadooo
        System.out.println("Registrando usuario: " + username);
        // Por ejemplo, guardar en una base de datos o archivo
    }

    private void iniciarSesion() {
        // Lógica para manejar el inicio de sesión
        JOptionPane.showMessageDialog(this, "Funcionalidad de inicio de sesión no implementada.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RegistroEmpleados registro = new RegistroEmpleados();
            registro.setVisible(true);
        });
    }
}