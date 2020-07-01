package com.example.orm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.List;
import java.util.Locale;

@Configuration
public class AppConfig implements WebMvcConfigurer {

//    @Bean
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource src = new ReloadableResourceBundleMessageSource();
//        src.setBasename("classpath:/validMessages/messages");
//
//        src.setDefaultEncoding("UTF-8");
//        return src;
//    }

//    @Override
//    public Validator getValidator() {
//        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
//        // default ValidationMessages.properties
//        bean.setValidationMessageSource(messageSource());
//        return bean;
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor bean = new LocaleChangeInterceptor();
        //default: locale
        bean.setParamName("lang");
        registry.addInterceptor(bean);
    }
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("en"));
        return localeResolver;
    }

}

