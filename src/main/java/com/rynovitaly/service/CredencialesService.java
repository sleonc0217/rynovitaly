/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rynovitaly.service;

import com.rynovitaly.dao.CredencialesDao;
import com.rynovitaly.dao.UsuarioDao;
import com.rynovitaly.domain.Credenciales;
import com.rynovitaly.domain.Rol;
import com.rynovitaly.domain.Usuario;
import java.util.ArrayList;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userDetailsService")
public class CredencialesService implements UserDetailsService {
 
    @Autowired
    private CredencialesDao credencialesDao;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        //Se busca el usuario en la tabla usuario 
        Credenciales credenciales = credencialesDao.findByUsername(username);
        if(credenciales == null) {
            throw new UsernameNotFoundException(username);
  
        }
        
        //se cargan los roles del usuario en un arreglo especial de tipo GrantedAuthoruty
        var roles = new ArrayList<GrantedAuthority>();
        
        //se recorre el ArrayList del objeto usuario y se transformas en grantedAithority
        for(Rol rol:credenciales.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));

        }
        //Retorna un UserDetails conla info recuperada
        return new User(credenciales.getUsername(),credenciales.getPassword(),roles);
    }
    
     
    
}