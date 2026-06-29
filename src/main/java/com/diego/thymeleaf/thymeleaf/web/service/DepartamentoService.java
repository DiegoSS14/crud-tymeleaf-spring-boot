package com.diego.thymeleaf.thymeleaf.web.service;

import java.util.List;

import com.diego.thymeleaf.thymeleaf.web.domain.Departamento;

public interface DepartamentoService {
    void criar(Departamento departamento);
    void atualizar(Departamento departamento);
    Departamento buscarPorId(Long id);
    List<Departamento> buscarTodos();
}
