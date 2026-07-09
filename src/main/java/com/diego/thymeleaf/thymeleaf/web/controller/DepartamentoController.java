package com.diego.thymeleaf.thymeleaf.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diego.thymeleaf.thymeleaf.web.domain.Departamento;
import com.diego.thymeleaf.thymeleaf.web.service.DepartamentoService;




@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

    private final DepartamentoService service;

    DepartamentoController(DepartamentoService service) {
        this.service = service;
    }

    @GetMapping("cadastrar")
    public String cadastrar(@ModelAttribute("departamento") Departamento departamento) {
        return "departamento/cadastro";
    }
    
    @GetMapping("/listar")
    public String listar() {
        return "departamento/lista";
    }
    
    @PostMapping("/salvar")
    public String salvar(Departamento departamento) {
        service.salvar(departamento);
        return "redirect:/departamentos/cadastrar";
    }
    
}
