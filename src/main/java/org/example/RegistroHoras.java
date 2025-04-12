import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class RegistroHoras {
    private static Map<String, LocalDateTime> registroEntradas = new HashMap<>();
    private static Map<String, LocalDateTime> registroSalidas = new HashMap<>();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void registrarEntrada(String empleado) {
        LocalDateTime horaEntrada = LocalDateTime.now();
        registroEntradas.put(empleado, horaEntrada);
        System.out.println("Entrada registrada para " + empleado + " a las " + horaEntrada.format(formatter));
    }
    public static void registrarSalida(String empleado) {
        LocalDateTime horaSalida = LocalDateTime.now();
        if (registroEntradas.containsKey(empleado)) {
            registroSalidas.put(empleado, horaSalida);
            System.out.println("Salida registrada para " + empleado + " a las " + horaSalida.format(formatter));
        } else {
            System.out.println("No se encontró una entrada previa para " + empleado);
        }
    }
    public static void mostrarRegistros() {
        System.out.println("\nRegistros de entrada y salida:");
        for (String empleado : registroEntradas.keySet()) {
            System.out.println(empleado + " - Entrada: " + registroEntradas.get(empleado).format(formatter) +
                    " | Salida: " + (registroSalidas.get(empleado) != null ? registroSalidas.get(empleado).format(formatter) : "No registrada"));
        }
    }
    public static void main(String[] args) {
        registrarEntrada("Gaston");
        registrarSalida("Gaston");
        mostrarRegistros();
    }
}
