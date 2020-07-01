package com.web.furama;

import com.web.furama.converters.DateConverter;
import com.web.furama.dtos.AccountRegister;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateConverter());
    }

//    @Override
//    public Validator getValidator() {
//        return new AccountRegister();
//    }

}
