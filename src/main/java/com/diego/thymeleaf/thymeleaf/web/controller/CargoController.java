package com.diego.thymeleaf.thymeleaf.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String listar(ModelMap model) {
        model.addAttribute("cargos", cargoService.buscarTodos());

        // Verificacao
        List<Cargo> lista = cargoService.buscarTodos();
        System.out.println("DEBUG - Quantidade de cargos encontrados: " + (lista != null ? lista.size() : 0));
        
        return "cargo/lista";
    }

    @PostMapping("salvar")
    public String salvar(Cargo cargo, RedirectAttributes attr) {
        cargoService.salvar(cargo);
        attr.addFlashAttribute("success", "Cargo salvo com sucesso!");
        return "redirect:/cargos/listar";
    }
    
    @ModelAttribute("departamentos")
    public List<Departamento> departamentos() {
        return departamentoService.buscarTodos();
    }

    @GetMapping("editar/{id}")
    public String preEditar(@PathVariable Long id, Model model) {
        Cargo cargo = cargoService.buscarPorId(id);
        if (cargo == null) {
            return "error";
        }
        model.addAttribute("cargo", cargo);
        return "cargo/cadastro";
    }

    @PostMapping("editar")
    public String editar(Cargo cargo, RedirectAttributes attr) {
        cargoService.atualizar(cargo);
        attr.addFlashAttribute("success", "Registro atualizado com sucesso!");
        return "redirect:/cargos/cadastrar"; 
    }
    
}
