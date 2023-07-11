package kr.megaptera.F4T2.backdoor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class BackdoorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void setupDatabase() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/backdoor/setup-database"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteProduct() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/backdoor/delete-product"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteCart() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/backdoor/delete-cart"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteOrderHistory() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/backdoor/delete-orderHistory"))
                .andExpect(status().isOk());
    }
}
