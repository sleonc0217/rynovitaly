
package com.rynovitaly.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {
    
    
   
    
    
    @GetMapping("/")
    public String inicio(){
    
        
        
        
 


        
        
        return "index";
    }
    
}
