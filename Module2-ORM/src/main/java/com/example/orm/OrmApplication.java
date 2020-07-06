package com.example.orm;

//import com.example.orm.ModelApi.WeatherMap;
import com.example.orm.ModelApi.WeatherMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrmApplication.class, args);
    }


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            WeatherMap data = restTemplate.getForObject(
                    "http://api.openweathermap.org/data/2.5/weather?id=1583992&units=metric&appid=f0cc9e9e401f1cbb911af99911b68132", WeatherMap.class);
            System.out.println(data);
        };
    }
}
