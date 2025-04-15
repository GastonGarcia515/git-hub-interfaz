import java.util.HashMap;
import java.util.Map;

public class AuthControlador {
    private Map<String, String> usuarios;

    public AuthControlador() {
        usuarios = new HashMap<>();
        usuarios.put("gerente", "passwordGerente");
        usuarios.put("empleado", "passwordEmpleado");
    }

    public boolean autenticarUsuario(String tipoUsuario, String password) {
        return usuarios.containsKey(tipoUsuario) && usuarios.get(tipoUsuario).equals(password);
    }

    public void mostrarOpciones(String tipoUsuario) {
        if (tipoUsuario.equals("gerente")) {
            System.out.println("Opciones disponibles: Registro de Almacén, Registro de Ventas, Registro de Empleados.");
        } else if (tipoUsuario.equals("empleado")) {
            System.out.println("Opciones disponibles: Seleccionar Bebida, Generar Pedido.");
        }
    }
}

