package org.theodorya.restservicetask.factorials;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class FactorialsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Correct Input Test, n = 5: ")
    void testCorrectInput() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/factorials").param("n","5"))

    }

}