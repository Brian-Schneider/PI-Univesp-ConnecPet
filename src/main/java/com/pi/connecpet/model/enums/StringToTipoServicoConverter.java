package com.pi.connecpet.model.enums;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class StringToTipoServicoConverter implements Converter<String, TipoServico>{

    @Override
    public TipoServico convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }
        try {
            return TipoServico.valueOf(source);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Essa string não tem correspondência com um valor do enum TipoServico: " + source);
        }
    }
}
