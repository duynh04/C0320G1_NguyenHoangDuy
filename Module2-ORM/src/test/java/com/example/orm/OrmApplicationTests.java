package com.example.orm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest
class OrmApplicationTests {

    @Test
    void contextLoads() {
        String schema = "http";
        String host = "api.openweathermap.org";
        String path = "/data/2.5/weather";
        String UNITS = "metric";
        String CITY_ID = "1583992";
        String APP_ID = "f0cc9e9e401f1cbb911af99911b68132";
        String query = String.format("id=%s&units=%s&appid=%s", CITY_ID, UNITS, APP_ID);
        try {
            URI url = new URI(schema, null, host, -1, path, query, null);
            System.out.print(url.toString());
        } catch (URISyntaxException ignored) {}
    }
}
