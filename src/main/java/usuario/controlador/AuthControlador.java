import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class AuthControlador {
    private Map<String, LocalDateTime> entryTimes = new HashMap<>();
    private Map<String, LocalDateTime> exitTimes = new HashMap<>();

    public void registerEntry(String userId) {
        entryTimes.put(userId, LocalDateTime.now());
        System.out.println("Entrada registrada para usuario: " + userId);
    }

    public void registerExit(String userId) {
        exitTimes.put(userId, LocalDateTime.now());
        System.out.println("Salida registrada para usuario: " + userId);
    }

    public LocalDateTime getEntryTime(String userId) {
        return entryTimes.get(userId);
    }

    public LocalDateTime getExitTime(String userId) {
        return exitTimes.get(userId);
    }
}
