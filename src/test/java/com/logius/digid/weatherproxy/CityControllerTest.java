package com.logius.digid.weatherproxy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnRotterdamFromWeatherApi() throws Exception {
        this.mockMvc.perform(get("/weatherproxy/cities/Rotterdam")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("minTemp\":289.82,\"maxTemp\":292.59,\"sunrise\":1592104928,\"id\":2747891,\"name\":\"Rotterdam")));
    }

}
