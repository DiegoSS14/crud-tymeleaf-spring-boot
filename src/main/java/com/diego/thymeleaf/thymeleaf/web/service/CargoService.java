package com.diego.thymeleaf.thymeleaf.web.service;

import java.util.List;

import com.diego.thymeleaf.thymeleaf.web.domain.Cargo;

public interface CargoService {
    void salvar(Cargo cargo);
    void atualizar(Cargo cargo);
    Cargo buscarPorId(Long id);
    List<Cargo> buscarTodos();
}
