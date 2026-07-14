package com.diego.thymeleaf.thymeleaf.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("listar")
    public String listar(ModelMap model) {
        model.addAttribute("departamentos", service.buscarTodos());
        return "departamento/lista";
    }

    @PostMapping("salvar")
    public String salvar(Departamento departamento, RedirectAttributes attr) {
        service.salvar(departamento);
        attr.addFlashAttribute("success", "Departamento salvo com sucesso!");
        return "redirect:/departamentos/cadastrar";
    }

    @GetMapping("editar/{id}")
    public String preEditar(@PathVariable Long id, ModelMap model) {
        model.addAttribute("departamento", service.buscarPorId(id));
        return "departamento/cadastro";
    }

    @PostMapping("editar")
    public String editar(Departamento departamento, RedirectAttributes attr) {
        service.atualizar(departamento);
        attr.addAttribute("success", "Departamento salvo com sucesso!");
        return "redirect:/departamentos/cadastrar";
    }

    @GetMapping("excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model) {
        if (service.temCargoAssociado(id)) {
            model.addAttribute("fail", "Departamento não pode ser excluído pois possui cargo associado.");
        } else {
            model.addAttribute("success", "Departamento excluído com sucesso!");
            service.excluir(id);
        }
        return listar(model);
    }
}
