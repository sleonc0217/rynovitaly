
package com.rynovitaly.controller;


import com.rynovitaly.dao.UsuarioDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {
    
   @Autowired
   private UsuarioDao usuarioDao;
   
    
    
    @GetMapping("/")
    public String inicio(Model model){
        var usuarios = usuarioDao.findAll();
        
     model.addAttribute("usuarios",usuarios);
        
        
 


        
        
        return "index";
    }
    
}
