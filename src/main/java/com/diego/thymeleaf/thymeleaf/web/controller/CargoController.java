package com.diego.thymeleaf.thymeleaf.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.diego.thymeleaf.thymeleaf.web.domain.Cargo;
import com.diego.thymeleaf.thymeleaf.web.domain.Departamento;
import com.diego.thymeleaf.thymeleaf.web.service.CargoService;
import com.diego.thymeleaf.thymeleaf.web.service.DepartamentoService;

import lombok.AllArgsConstructor;



@AllArgsConstructor
@Controller
@RequestMapping("cargos")
public class CargoController {

    private DepartamentoService departamentoService;
    private CargoService cargoService;

    @GetMapping("cadastrar")
    public String cadastrar(Cargo cargo) {
        return "cargo/cadastro";
    }
    
    @GetMapping("/listar")
    public String listar() {
        return "cargo/lista";
    }

    @PostMapping("salvar")
    public String salvar(Cargo cargo, RedirectAttributes attr) {
        cargoService.criar(cargo);
        attr.addFlashAttribute("cargo", cargo);
        return "redirect:/cargos/salvar";
    }
    
    @ModelAttribute("departamentos")
    public List<Departamento> departamentos() {
        return departamentoService.buscarTodos();
    }
}
