package com.pi.connecpet.model.enums;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class StringToPorteConverter implements Converter<String, Porte> {

    @Override
    public Porte convert(String source) {
        return Porte.fromValue(Integer.parseInt(source));
    }
}