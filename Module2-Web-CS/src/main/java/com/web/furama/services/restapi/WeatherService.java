package com.web.furama.services.restapi;

import com.web.furama.modelapis.weather.WeatherMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;


    public String getTemperature() {
        URI url = getUrl();
        System.out.println(url.toString());
        WeatherMap data = restTemplate.getForObject(url.toString(), WeatherMap.class);
        assert data != null;
        return data.toString();
    }

    private URI getUrl() {
        String schema = "http";
        String host = "api.openweathermap.org";
        String path = "/data/2.5/weather";
        String UNITS = "metric";
        String CITY_ID = "1583992";
        String APP_ID = "f0cc9e9e401f1cbb911af99911b68132";
        String query = String.format("id=%s&units=%s&appid=%s", CITY_ID, UNITS, APP_ID);
        try {
            return new URI(schema, null, host, -1, path, query, null);
        } catch (URISyntaxException u) {
            return URI.create("/");
        }
    }
}
