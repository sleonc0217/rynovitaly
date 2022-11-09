
package com.rynovitaly.service;

import com.rynovitaly.domain.Usuario;
import java.util.List;


public interface UsuarioService {
    
    
    
    //se definen los 4 metodos de un CRUD
    // Create, READ, UPDATE y DELETE
    
    
    //Retorna la lista de usuarios
    public List<Usuario> getUsuario();
    
    //Dado un usuario.id se busca en la tabla y se retorna todo el objeto usuario
    public Usuario getUsuario(Usuario usuario);
    
    
    
    //Si usuario.id tiene un valor se busca y se actualiza
    //Si el usuario .id no tiene valor, se inserta el objeto en la tabla
    public void save(Usuario usuario);
    
    
    ///elimina el registro que tiene el id igual a usuario.id
    
   public void delete (Usuario usuario);
    
    
    
    
}
