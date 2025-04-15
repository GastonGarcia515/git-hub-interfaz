import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Carlos Barman", "Bartender");
//xd
        List<Producto> productos = Arrays.asList(
                new Producto("Fernet shot", "imagenen/img/imagen1.jpg", 5),
                new Producto("Jagermeister", "imagenen/img/imagen2.jpg", 10),
                new Producto("Vokca", "imagenen/img/imagen3.jpg", 15),
                new Producto("Hansen Special Cocktail", "imagenen/img/imagen4.jpg", 20),
                new Producto("Piedra Dreams", "imagenen/img/imagen5.jpg", 25),
                new Producto("Colt", "imagenen/img/imagen6.jpg", 30),
                new Producto("Bed of Roses", "imagenen/img/imagen7.jpg", 35),
                new Producto("Votka Tonico", "imagenen/img/imagen8.jpg", 40),
                new Producto("Cosmopolitan", "imagenen/img/imagen9.jpg", 45),
                new Producto("Herbal Intenso", "imagenen/img/imagen10.jpg", 70)
        );

        javax.swing.SwingUtilities.invokeLater(() -> {
            new InterfazBartender(usuario, productos).setVisible(true);
        });
    }
}
