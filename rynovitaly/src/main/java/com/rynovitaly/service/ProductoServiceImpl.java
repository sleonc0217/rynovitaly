
package com.rynovitaly.service;

import com.rynovitaly.dao.ProductoDao;
import com.rynovitaly.domain.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service

public class ProductoServiceImpl implements ProductoService{
    
    
    
    //se definen los 4 metodos de un CRUD
    // Create, READ, UPDATE y DELETE mediante ProductoDAO
    
    
    
    //se utiliza una anotacion autowired para que el objeto productoDao
    //Si ya esta en memoria se use ese... sino se crea (singleton)
    @Autowired
    private ProductoDao productoDao;
    
    //Retorna la lista de productos
    @Override
    @Transactional(readOnly=true)
    public List<Producto> getProducto(boolean activos){
        var lista=(List<Producto>)productoDao.findAll();
        
        
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        
        
        return lista;
    }
    
    //Dado un producto.id se busca en la tabla y se retorna todo el objeto producto
      @Override
    @Transactional(readOnly=true)
    public Producto getProducto(Producto producto){
        
        
        return productoDao.findById(producto.getIdProducto()).orElse(null);
        
    }
    
    
    
    //Si producto.id tiene un valor se busca y se actualiza
    //Si el producto .id no tiene valor, se inserta el objeto en la tabla
    @Override
    @Transactional
    public void save(Producto producto){
        productoDao.save(producto);
    }
    
    
    ///elimina el registro que tiene el id igual a producto.id
   @Override
   @Transactional
   public void delete (Producto producto){
       productoDao.delete(producto);
   }
    
    
    
    
}
