package com.diego.thymeleaf.thymeleaf.web.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diego.thymeleaf.thymeleaf.web.dao.DepartamentoDao;
import com.diego.thymeleaf.thymeleaf.web.domain.Departamento;

import lombok.AllArgsConstructor;

@Service @Transactional(readOnly = false)
@AllArgsConstructor
public class DepartamentoServiceImpl implements DepartamentoService {
    
    private DepartamentoDao dao;

    @Override
    public void atualizar(Departamento departamento) {
        dao.update(departamento);        
    }

    @Override
    @Transactional(readOnly = true)
    public Departamento buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Departamento> buscarTodos() {
        return dao.findAll();
    }

    @Override
    public void criar(Departamento departamento) {
        dao.save(departamento);
    }
    
}
