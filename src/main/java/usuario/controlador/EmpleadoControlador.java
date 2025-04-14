import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class EmpleadoControlador {
    private Map<String, LocalDateTime> entryTimes = new HashMap<>();
    private Map<String, LocalDateTime> exitTimes = new HashMap<>();

    public void registerEntry(String employeeId) {
        entryTimes.put(employeeId, LocalDateTime.now());
        System.out.println("Entrada registrada para empleado: " + employeeId);
    }

    public void registerExit(String employeeId) {
        exitTimes.put(employeeId, LocalDateTime.now());
        System.out.println("Salida registrada para empleado: " + employeeId);
    }

    public LocalDateTime getEntryTime(String employeeId) {
        return entryTimes.get(employeeId);
    }

    public LocalDateTime getExitTime(String employeeId) {
        return exitTimes.get(employeeId);
    }
}
