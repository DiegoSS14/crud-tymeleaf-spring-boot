package com.diego.thymeleaf.thymeleaf.web.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diego.thymeleaf.thymeleaf.web.dao.CargoDao;
import com.diego.thymeleaf.thymeleaf.web.domain.Cargo;

import lombok.AllArgsConstructor;



@Service @Transactional(readOnly = true)
@AllArgsConstructor
public class CargoServiceImpl implements CargoService{

    private CargoDao dao;

    @Transactional(readOnly = false)
    @Override
    public void atualizar(Cargo cargo) {
        dao.update(cargo);
    }

    @Transactional(readOnly = true)
    @Override
    public Cargo buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Cargo> buscarTodos() {
        return dao.findAll();
    }
    
    @Transactional(readOnly = false)
    @Override
    public void salvar(Cargo cargo) {
        dao.save(cargo);        
    }
    
}
