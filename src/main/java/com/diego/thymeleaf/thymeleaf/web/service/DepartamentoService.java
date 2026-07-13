package com.diego.thymeleaf.thymeleaf.web.service;

import java.util.List;

import com.diego.thymeleaf.thymeleaf.web.domain.Departamento;

public interface DepartamentoService {
    void criar(Departamento departamento);
    void atualizar(Departamento departamento);
    void salvar(Departamento departamento);
    Departamento buscarPorId(Long id);
    void excluir(Long id);
    List<Departamento> buscarTodos();
    boolean temCargoAssociado(Long id);
}
