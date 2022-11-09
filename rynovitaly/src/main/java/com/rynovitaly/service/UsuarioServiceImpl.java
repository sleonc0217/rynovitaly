
package com.rynovitaly.service;

import com.rynovitaly.dao.UsuarioDao;
import com.rynovitaly.dao.CreditoDao;
import com.rynovitaly.domain.Usuario;
import com.rynovitaly.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service

public class UsuarioServiceImpl implements UsuarioService{
    
    
    
    //se definen los 4 metodos de un CRUD
    // Create, READ, UPDATE y DELETE mediante UsuarioDAO
    
    
    
    //se utiliza una anotacion autowired para que el objeto usuarioDao
    //Si ya esta en memoria se use ese... sino se crea (singleton)
    @Autowired
    private UsuarioDao usuarioDao;
    
    
     @Autowired
    private CreditoDao creditoDao;
    //Retorna la lista de usuarios
    @Override
    @Transactional(readOnly=true)
    public List<Usuario> getUsuario(){
        return (List<Usuario>)usuarioDao.findAll();
    }
    
    //Dado un usuario.id se busca en la tabla y se retorna todo el objeto usuario
      @Override
    @Transactional(readOnly=true)
    public Usuario getUsuario(Usuario usuario){
        
        
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
        
    }
    
    
    
    //Si usuario.id tiene un valor se busca y se actualiza
    //Si el usuario .id no tiene valor, se inserta el objeto en la tabla
    @Override
    @Transactional
    public void save(Usuario usuario){
        Credito credito = usuario.getCredito();
        creditoDao.save(credito);
        usuario.setCredito(credito);
        
        
        usuarioDao.save(usuario);
    }
    
    
    ///elimina el registro que tiene el id igual a usuario.id
   @Override
   @Transactional
   public void delete (Usuario usuario){
       usuarioDao.delete(usuario);
   }
    
    
    
    
}
