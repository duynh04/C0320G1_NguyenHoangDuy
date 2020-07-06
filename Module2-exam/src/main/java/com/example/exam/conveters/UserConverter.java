package com.example.exam.conveters;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class UserConverter implements Converter<String, LocalDate> {
    @Override
    public LocalDate convert(String source) {
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(source);
        } catch (DateTimeParseException e) {
            return null;
        }
        return localDate;

    }
}
