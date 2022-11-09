
package com.rynovitaly.controller;

import com.rynovitaly.domain.Producto;
import com.rynovitaly.dao.ProductoDao;
import com.rynovitaly.service.ProductoService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    
    
    
    
    
     @GetMapping("/producto/listado")
    public String inicio(Model model){
        var texto="Estamos en semana 4";
        model.addAttribute("mensaje", texto);
        
        
        
 
var productos= productoService.getProducto(false);

         model.addAttribute("productos", productos);
        
        return "/producto/listado";
    }
    
    
    
    
    @GetMapping("/producto/nuevo")
    public String nuevoProducto(Producto producto){
        return "/producto/modificar";
        
        
        
 
    }
    
    
    @PostMapping("/producto/guardar")
    public String guardarProducto(Producto producto){
        productoService.save(producto);
        return "redirect:/producto/listado";
    }
    
    
    
    
    @GetMapping("/producto/modificar/{idProducto}")
    public String modificarProducto(Producto producto){
        producto = productoService.getProducto(producto);
        return "/producto/modificar";
        
        
        
 
    }
    
    
    
    @GetMapping("producto/eliminar/{idProducto}")
    public String eliminarProducto(Producto producto){
        productoService.delete(producto);
        return "redirect:/producto/listado";
        
        
        
 
    }
}
