
package com.rynovitaly.controller;

import com.rynovitaly.domain.Categoria;
import com.rynovitaly.service.CategoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categoria/listado")
    public String listado(Model model) {        
        var categorias=categoriaService.getCategorias();     
        
        model.addAttribute("categorias",categorias);
        return "/categoria/listado";
    }
    
    @GetMapping("/categoria/nuevo")
    public String categoriaNuevo(Categoria categoria) {
        return "/categoria/modificar";
    }

    @PostMapping("/categoria/guardar")
    public String categoriaGuardar(Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/categoria/modificar/{idCategoria}")
    public String categoriaModificar(Categoria categoria,Model model) {
        categoria = categoriaService.getCategorias(categoria);
        model.addAttribute("categoria",categoria);
        return "/categoria/modificar";
    }

    @GetMapping("/categoria/eliminar/{idCategoria}")
    public String categoriaEliminar(Categoria categoria) {
        categoriaService.delete(categoria);        
        return "redirect:/categoria/listado";
    }
}
