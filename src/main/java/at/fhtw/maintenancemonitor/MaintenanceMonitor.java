package at.fhtw.maintenancemonitor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class MaintenanceMonitor {
    private final String defaultStatus= "Everything works as expected";
    private String status = defaultStatus;

    public String getStatus() {
        return status;
    }

    public ResponseEntity<String> setStatus(String setStatus) {
        this.status = setStatus;
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    public ResponseEntity<String> resetStatus() {
        this.status = defaultStatus;
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    public MaintenanceMonitor() {
    }
}