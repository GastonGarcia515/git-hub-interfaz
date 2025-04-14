import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class GerenteControlador {
    private Map<String, LocalDateTime> entryTimes = new HashMap<>();
    private Map<String, LocalDateTime> exitTimes = new HashMap<>();

    public void registerEntry(String managerId) {
        entryTimes.put(managerId, LocalDateTime.now());
        System.out.println("Entrada registrada para gerente: " + managerId);
    }

    public void registerExit(String managerId) {
        exitTimes.put(managerId, LocalDateTime.now());
        System.out.println("Salida registrada para gerente: " + managerId);
    }

    public LocalDateTime getEntryTime(String managerId) {
        return entryTimes.get(managerId);
    }

    public LocalDateTime getExitTime(String managerId) {
        return exitTimes.get(managerId);
    }
}
