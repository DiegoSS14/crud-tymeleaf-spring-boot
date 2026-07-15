package com.diego.thymeleaf.thymeleaf.web.conversor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.diego.thymeleaf.thymeleaf.web.domain.Departamento;
import com.diego.thymeleaf.thymeleaf.web.service.DepartamentoService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class StringToDepartamentoConverter implements Converter<String, Departamento> {
    
    private DepartamentoService departamentoService;

    @Override
    public Departamento convert(String text) {
        if(text.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(text);
        return departamentoService.buscarPorId(id);
    }
}
