package com.web.furama;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.web.furama.models")
@SpringBootApplication
public class FuramaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FuramaApplication.class, args);
    }

}
