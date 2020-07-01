package com.web.furama.converters;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.temporal.Temporal;

public class DateConverter implements Converter<String, LocalDate> {
    @Override
    public LocalDate convert(String source) {
        if (!source.equals("")) {
            return LocalDate.parse(source);
        }
        return null;
    }
}
