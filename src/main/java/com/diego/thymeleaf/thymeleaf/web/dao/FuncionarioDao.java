package com.diego.thymeleaf.thymeleaf.web.dao;

import java.util.List;

import com.diego.thymeleaf.thymeleaf.web.domain.Funcionario;

public interface FuncionarioDao {
    void save(Funcionario funcionario);
    void update(Funcionario funcionario);
    void delete(Long id);
    Funcionario findById(Long id);
    List<Funcionario> findAll();
}
