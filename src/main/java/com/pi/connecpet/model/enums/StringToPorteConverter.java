package com.pi.connecpet.model.enums;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class StringToPorteConverter implements Converter<String, Porte> {

    @Override
    public Porte convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }
        try {
            return Porte.valueOf(source);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Essa string não tem correspondência com um valor do enum Porte: " + source);
        }
    }
}