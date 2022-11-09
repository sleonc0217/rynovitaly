
package com.rynovitaly.service;

import com.rynovitaly.domain.Producto;
import java.util.List;


public interface ProductoService {
    
    
    
    //se definen los 4 metodos de un CRUD
    // Create, READ, UPDATE y DELETE
    
    
    //Retorna la lista de productos
    public List<Producto> getProducto(boolean activos);
    
    //Dado un producto.id se busca en la tabla y se retorna todo el objeto producto
    public Producto getProducto(Producto producto);
    
    
    
    //Si producto.id tiene un valor se busca y se actualiza
    //Si el producto .id no tiene valor, se inserta el objeto en la tabla
    public void save(Producto producto);
    
    
    ///elimina el registro que tiene el id igual a producto.id
    
   public void delete (Producto producto);
    
    
    
    
}
