package org.theodorya.restservicetask.factorials;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
class FactorialsControllerTest {
    int[] factorials = {1,2,6,24,120};

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Correct Input Test, n = 5")
    void testCorrectInput() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/factorials").param("n","5"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.factorials").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.factorials").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.factorials.length()").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$.factorials[0]").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.factorials[4]").value(120));
    }

    @Test
    @DisplayName("Out of Left Boundary Test, n = -1")
    void testLeftBoundary() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/factorials").param("n", "-1"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("Out of Right Boundary Test, n = 1001")
    void testRightBoundary() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/factorials").param("n", "1001"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("Incorrect Input Test, n = abc")
    void testIncorrectInput() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/factorials").param("n","abc"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("Empty Input Test, n = ")
    void testEmptyInput() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/factorials").param("n", ""))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}