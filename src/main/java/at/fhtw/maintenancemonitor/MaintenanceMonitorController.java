package at.fhtw.maintenancemonitor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MaintenanceMonitorController {

    private final MaintenanceMonitor monitor = new MaintenanceMonitor();

    @GetMapping("/api/message")
    public String message(){
        return monitor.getStatus();
    }

    @RequestMapping("/api/message/set")
    public ResponseEntity<String> setMonitorStatus(@RequestParam String statusMessage) {
        return monitor.setStatus(statusMessage);
    }

    @RequestMapping("/api/message/reset")
    public ResponseEntity<String> resetMonitorStatus() {
        return monitor.resetStatus();
    }
}
