
package com.rynovitaly.controller;

import com.rynovitaly.domain.Usuario;
import com.rynovitaly.dao.UsuarioDao;
import com.rynovitaly.service.UsuarioService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    
    
    
    
    
     @GetMapping("/usuario/listado")
    public String inicio(Model model){
   
        
        
        
 
var usuarios= usuarioService.getUsuario();

         model.addAttribute("usuarios", usuarios);
        
        return "/usuario/listado";
    }
    
    
    
    
    @GetMapping("/usuario/nuevo")
    public String nuevoModificar(Usuario usuario){
        return "/usuario/modificar";
        
        
        
 
    }
    
    
    @PostMapping("/usuario/guardar")
    public String guardarUsuario(Usuario usuario){
        usuarioService.save(usuario);
        return "redirect:/usuario/listado";
    }
    
    
    
    
    @GetMapping("/usuario/modificar/{idUsuario}")
    public String modificarUsuario(Usuario usuario){
        usuario = usuarioService.getUsuario(usuario);
        return "/usuario/modificar";
        
        
        
 
    }
    
    
    
    @GetMapping("usuario/eliminar/{idUsuario}")
    public String eliminarUsuario(Usuario usuario){
        usuarioService.delete(usuario);
        return "redirect:/usuario/listado";
        
        
        
 
    }
}
