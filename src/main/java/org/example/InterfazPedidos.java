package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class InterfazPedidos extends JFrame {

    private final JComboBox<String> comboBebidas;
    private final JTextField txtCantidad;
    private final JLabel lblPrecioUnitario;
    private final JLabel lblTotal;
    private final JTextArea areaPedidos;
    private static int contadorPedidos = 1;

    private final Map<String, Double> preciosBebidas = new HashMap<>();

    public InterfazPedidos() {
        setTitle("Sistema de Pedidos - Cafetería");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Bebidas y precios
        preciosBebidas.put("Vodka Tónica", 40.0);
        preciosBebidas.put("Coca Cola", 10.0);
        preciosBebidas.put("Jugo de Naranja", 15.0);
        preciosBebidas.put("Mojito", 35.0);

        // Panel superior
        JPanel panelTop = new JPanel(new GridLayout(4, 2, 5, 5));
        panelTop.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        comboBebidas = new JComboBox<>(preciosBebidas.keySet().toArray(new String[0]));
        txtCantidad = new JTextField();
        lblPrecioUnitario = new JLabel("0.0 Bs");
        lblTotal = new JLabel("0.0 Bs");

        panelTop.add(new JLabel("Seleccionar Bebida:"));
        panelTop.add(comboBebidas);
        panelTop.add(new JLabel("Cantidad:"));
        panelTop.add(txtCantidad);
        panelTop.add(new JLabel("Precio Unitario:"));
        panelTop.add(lblPrecioUnitario);
        panelTop.add(new JLabel("Total:"));
        panelTop.add(lblTotal);

        // Área de pedidos
        areaPedidos = new JTextArea();
        areaPedidos.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaPedidos);

        // Botón generar pedido
        JButton btnGenerar = new JButton("Generar Pedido");
        btnGenerar.addActionListener(e -> generarPedido());

        add(panelTop, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(btnGenerar, BorderLayout.SOUTH);

        // Eventos
        comboBebidas.addActionListener(e -> actualizarPrecioUnitario());
        txtCantidad.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                calcularTotal();
            }
        });

        actualizarPrecioUnitario(); // Inicializar precio
    }

    private void actualizarPrecioUnitario() {
        String bebida = (String) comboBebidas.getSelectedItem();
        if (bebida != null) {
            double precio = preciosBebidas.get(bebida);
            lblPrecioUnitario.setText(precio + " Bs");
            calcularTotal();
        }
    }

    private void calcularTotal() {
        try {
            int cantidad = Integer.parseInt(txtCantidad.getText());
            String bebida = (String) comboBebidas.getSelectedItem();
            if (bebida != null) {
                double total = preciosBebidas.get(bebida) * cantidad;
                lblTotal.setText(total + " Bs");
            }
        } catch (NumberFormatException e) {
            lblTotal.setText("0.0 Bs");
        }
    }

    private void generarPedido() {
        String bebida = (String) comboBebidas.getSelectedItem();
        String cantidadText = txtCantidad.getText();
        if (bebida == null || bebida.isEmpty() || cantidadText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar bebida y cantidad.");
            return;
        }

        try {
            int cantidad = Integer.parseInt(cantidadText);
            double precioUnitario = preciosBebidas.get(bebida);
            double total = precioUnitario * cantidad;
            String idPedido = "PED-" + contadorPedidos++;

            String resumen = String.format("""
                    ID Pedido: %s
                    Bebida: %s
                    Cantidad: %d
                    Subtotal: %.2f Bs
                    Estado: En preparación
                    -----------------------------
                    """, idPedido, bebida, cantidad, total);

            areaPedidos.append(resumen);
            txtCantidad.setText("");
            lblTotal.setText("0.0 Bs");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida.");
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfazPedidos().setVisible(true));
    }
}
