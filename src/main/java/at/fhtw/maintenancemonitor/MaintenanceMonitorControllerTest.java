package at.fhtw.maintenancemonitor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MaintenanceMonitorController.class)
class MaintenanceMonitorControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testDefaultStatusMessage() throws Exception{
        mockMvc.perform(get("/api/message"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(result -> result.getResponse().getContentAsString().contentEquals("Everything works  as expected"));
    }
    @Test
    void testSetMonitorStatusMessage() throws Exception{
        mockMvc.perform(get("/api/message/set?statusMessage=Service checks: No power until 5:00 pm"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(result -> result.getResponse().getContentAsString().contentEquals("OK"));
    }
    @Test
    void testStatusMessageAfterSettingNewMessage() throws Exception{
        mockMvc.perform(get("/api/message"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(result -> result.getResponse().getContentAsString().contentEquals("Service checks: No power until 5:00 pm"));
    }
    @Test
    void testResetMonitorStatusMessage() throws Exception {
        mockMvc.perform(get("/api/message/reset"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(result -> result.getResponse().getContentAsString().contentEquals("OK"));
    }
    @Test
    void testShowStatusMessageAfterReset() throws Exception{
        mockMvc.perform(get("/api/message"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(result -> result.getResponse().getContentAsString().contentEquals("Everything works  as expected"));
    }
}