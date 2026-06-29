package com.diego.thymeleaf.thymeleaf.web.service;

import java.util.List;

import com.diego.thymeleaf.thymeleaf.web.domain.Funcionario;

public interface FuncionarioService {
    void criar(Funcionario funcionario);
    void atualizar(Funcionario funcionario);
    Funcionario buscarPorId(Long id);
    List<Funcionario> buscarTodos();
}
