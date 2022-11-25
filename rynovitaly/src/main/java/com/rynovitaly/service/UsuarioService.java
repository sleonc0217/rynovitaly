
package com.rynovitaly.service;

import com.rynovitaly.domain.Usuario;
import java.util.List;


public interface UsuarioService {
    
    //Los métodos para hacer un CRUD de la tabla cliente
    //Create Read Update Delete
    
    public List<Usuario> getUsuarios();
    
    public Usuario getUsuario(Usuario cliente);
    
    public void save(Usuario cliente);
    
    public void delete(Usuario cliente);
    
    
}
