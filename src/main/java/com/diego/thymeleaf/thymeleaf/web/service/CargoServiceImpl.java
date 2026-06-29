package com.diego.thymeleaf.thymeleaf.web.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diego.thymeleaf.thymeleaf.web.dao.CargoDao;
import com.diego.thymeleaf.thymeleaf.web.domain.Cargo;

import lombok.AllArgsConstructor;



@Service @Transactional(readOnly = false)
@AllArgsConstructor
public class CargoServiceImpl implements CargoService{

    private CargoDao dao;

    @Override
    public void atualizar(Cargo cargo) {
        dao.update(cargo);
    }

    @Override
    public Cargo buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Cargo> buscarTodos() {
        return null;
    }
    
    @Transactional(readOnly = true)
    @Override
    public void criar(Cargo cargo) {
        dao.save(cargo);        
    }
    
}
