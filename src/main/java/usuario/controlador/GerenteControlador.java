public class GerenteControlador {
    private Gerente gerente;

    public GerenteControlador(Gerente gerente) {
        this.gerente = gerente;
    }

    public void gestionarAlmacen() {
        System.out.println("Gestión de almacén: Ver bebidas disponibles, añadir más stock.");
    }

    public void gestionarVentas() {
        System.out.println("Registro de ventas: Ver bebidas vendidas, precios y generar facturas.");
    }

    public void gestionarEmpleados() {
        System.out.println("Gestión de empleados: Lista de empleados, sueldo, horario y descuentos.");
    }
}


