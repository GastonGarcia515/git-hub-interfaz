import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class InterfazBartender extends JFrame {

    private Usuario usuario;
    private List<Producto> productos;

    public InterfazBartender(Usuario usuario, List<Producto> productos) {
        this.usuario = usuario;
        this.productos = productos;

        setTitle("Menú del Bartender");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout principal
        setLayout(new BorderLayout());

        // Panel de productos
        JPanel panelProductos = new JPanel(new GridLayout(0, 3, 10, 10));
        for (Producto p : productos) {
            panelProductos.add(crearPanelProducto(p));
        }

        // Scroll para el panel de productos
        JScrollPane scrollPane = new JScrollPane(panelProductos);
        add(scrollPane, BorderLayout.CENTER);

        // Panel superior derecho (usuario y cerrar sesión)
        JPanel panelUsuario = new JPanel(new BorderLayout());
        JLabel lblUsuario = new JLabel("Usuario: " + usuario.getNombre() + " (" + usuario.getRol() + ")");
        JButton btnCerrarSesion = new JButton("Cerrar sesión");

        btnCerrarSesion.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Sesión cerrada.");
            System.exit(0);
        });

        panelUsuario.add(lblUsuario, BorderLayout.CENTER);
        panelUsuario.add(btnCerrarSesion, BorderLayout.EAST);
        add(panelUsuario, BorderLayout.NORTH);

        // Botón generar factura
        JButton btnGenerarFactura = new JButton("Generar Factura");
        btnGenerarFactura.addActionListener(this::generarFactura);
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBoton.add(btnGenerarFactura);
        add(panelBoton, BorderLayout.SOUTH);
    }

    private JPanel crearPanelProducto(Producto producto) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel lblNombre = new JLabel(producto.getNombre(), JLabel.CENTER);
        ImageIcon imagen = new ImageIcon(producto.getImagenRuta());
        Image imgRedimensionada = imagen.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel lblImagen = new JLabel(new ImageIcon(imgRedimensionada));
        JLabel lblPrecio = new JLabel("Precio: Bs." + producto.getPrecio(), JLabel.CENTER);

        panel.add(lblNombre, BorderLayout.NORTH);
        panel.add(lblImagen, BorderLayout.CENTER);
        panel.add(lblPrecio, BorderLayout.SOUTH);
        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        return panel;
    }

    private void generarFactura(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Factura generada correctamente.");
        // Aquí se puede abrir otra ventana o guardar la factura
    }
}
