package ru.akartashov93.weatheraggregator;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ru.akartashov93.weatheraggregator.service.dto.AverageWeather;
import ru.akartashov93.weatheraggregator.service.integration.impl.WeatherIntegrationAService;
import ru.akartashov93.weatheraggregator.service.integration.impl.WeatherIntegrationBService;
import ru.akartashov93.weatheraggregator.service.integration.impl.WeatherIntegrationCService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WeatherAggregatorApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockitoBean
    private WeatherIntegrationAService weatherIntegrationAService;
    @MockitoBean
    private WeatherIntegrationBService weatherIntegrationBService;
    @MockitoBean
    private WeatherIntegrationCService weatherIntegrationCService;

    @Test
    void test() throws Exception {
        when(weatherIntegrationAService.getWeather(any())).thenReturn(
                "{ \"temp\": 2.1, \"hum\": 55.1 }"
        );
        when(weatherIntegrationBService.getWeather(any())).thenReturn(
                "{ \"temperature\": \"2.1\", \"humidity\": \"55.1\" }"
        );
        when(weatherIntegrationCService.getWeather(any())).thenReturn(
                "{ \"weather\": { \"t\": 2.1, \"h\": 55.1 } }"
        );

        MvcResult result = mockMvc.perform(get("/api/v1/weather/aggregate")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andReturn();

        String json = result.getResponse().getContentAsString();
        AverageWeather averageWeather = objectMapper.readValue(json, AverageWeather.class);
        Assertions.assertEquals(2.1, averageWeather.getAverageTemperature());
        Assertions.assertEquals(55.1, averageWeather.getAverageHumidity());
    }

}
