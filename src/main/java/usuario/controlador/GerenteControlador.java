import java.util.ArrayList;
import java.util.List;

public class EmpleadoControlador {
    private List<Empleado> empleados;

    public EmpleadoControlador() {
        empleados = new ArrayList<>();
    }

    public void registrarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        System.out.println("Empleado registrado: " + empleado.getNombre());
    }

    public void mostrarListaEmpleados() {
        System.out.println("Lista de empleados:");
        for (Empleado empleado : empleados) {
            System.out.println(empleado.getNombre() + " - " + empleado.getFuncion() + " - Sueldo: $" + empleado.getSueldo());
        }
    }
}

