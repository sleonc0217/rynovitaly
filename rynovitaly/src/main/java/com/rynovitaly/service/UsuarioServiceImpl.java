
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
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao clienteDao;
    @Autowired
    private CreditoDao creditoDao;
    
    
   
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios() {
        return (List<Usuario>)clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario cliente) {
        return clienteDao.findById(cliente.getIdUsuario()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Usuario cliente) {
        Credito credito = cliente.getCredito();
        
        credito = creditoDao.save(credito);
        
        cliente.setCredito(credito);
        
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Usuario cliente) {
        clienteDao.delete(cliente);
    }


    
}
