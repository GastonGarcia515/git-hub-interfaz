public class Producto {
    private String nombre;
    private String imagenRuta;
    private double precio;

    public Producto(String nombre, String imagenRuta, double precio) {
        this.nombre = nombre;
        this.imagenRuta = imagenRuta;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public String getImagenRuta() { return imagenRuta; }
    public double getPrecio() { return precio; }
}
