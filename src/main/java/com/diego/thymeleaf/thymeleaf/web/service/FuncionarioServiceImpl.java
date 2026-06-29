package com.diego.thymeleaf.thymeleaf.web.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diego.thymeleaf.thymeleaf.web.dao.FuncionarioDao;
import com.diego.thymeleaf.thymeleaf.web.domain.Funcionario;

import lombok.AllArgsConstructor;

@Service @Transactional(readOnly = false)
@AllArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {
    
    private FuncionarioDao dao;
    
    @Override
    public void atualizar(Funcionario funcionario) {
        dao.update(funcionario);        
    }

    @Override
    @Transactional(readOnly = true)
    public Funcionario buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Funcionario> buscarTodos() {
        return dao.findAll();
    }

    @Override
    public void criar(Funcionario funcionario) {
        dao.save(funcionario);        
    }
    
}
