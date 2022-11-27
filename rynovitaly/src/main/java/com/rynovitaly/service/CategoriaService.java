
package com.rynovitaly.service;

import com.rynovitaly.domain.Categoria;
import java.util.List;
public interface CategoriaService {
    

    
   public List<Categoria> getCategorias();
    
    public Categoria getCategorias(Categoria categoria);
    
    public void save(Categoria categoria);
    
    public void delete(Categoria categoria);
}

