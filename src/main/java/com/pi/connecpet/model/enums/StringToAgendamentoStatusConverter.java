package com.pi.connecpet.model.enums;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class StringToAgendamentoStatusConverter implements Converter<String, StatusAgendamento> {

    @Override
    public StatusAgendamento convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }
        try {
            return StatusAgendamento.valueOf(source);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Essa string não tem correspondência com um valor do enum StatusAgendamento: " + source);
        }
    }
}
