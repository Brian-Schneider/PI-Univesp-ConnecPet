package com.pi.connecpet.model.enums;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class StringToSexoConverter implements Converter<String, Sexo> {

    @Override
    public Sexo convert(String source) {
        return Sexo.fromValue(Integer.parseInt(source));
    }
}