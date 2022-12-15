
package com.rynovitaly.service;


import com.rynovitaly.domain.Item;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.springframework.stereotype.Service;



@Service
public class ItemServicelmpl implements ItemService {

    @Override
    public List<Item> getItems() {
        return listaItems;
    }
    
    

    @Override
    public Item getItem(Item item) {
        for(Item c : listaItems) {
            if(Objects.equals(c.getIdProducto(),item.getIdProducto())){
                return c;
            
                }
   
            }
           
        return null;
        
        }
     

    
    //se usa para agregar productos en el carrito
    @Override
    public void save(Item item) {
        boolean existe = false;
        for(Item c : listaItems) {
            //busca si ya existe el producto en el carrrito
            if(Objects.equals(c.getIdProducto(),item.getIdProducto())) {
                //valida si aun puede colocar un item adicional -segun existencias
                if(c.getCantidad() < item.getUnidades()) {
                    //incrementa en uno la cantidad de elementos 
                    c.setCantidad(c.getCantidad()+1);
                
                
                }
                existe = true;
                break;
            
            }
        
        
        }
        if (!existe ) {  //si no esta el producto en el carrito entpnces lo agrega cantidad=1
            item.setCantidad(1);
            listaItems.add(item);
        
        }
        
    }

    @Override
    public void delete(Item item) {
        var posicion = -1;
        var existe = false;
        for(Item c : listaItems) {
            ++posicion;
            if(Objects.equals(c.getIdProducto(),item.getIdProducto())) {
                existe = true;
                break;
            
            }
        
        }
        if(existe) {
            listaItems.remove(posicion);
        
        }
    }
    
    //actualiza la cantidad de 
    @Override
    public void actualiza(Item item) {
        for(Item i : listaItems) {
            if(Objects.equals(i.getIdProducto(), item.getIdProducto())) {
                i.setCantidad(item.getCantidad());
                break;
            }
            
        
        }
    }

    @Override
    public void facturar() {
        for(Item i : listaItems) {
            //Proceso de facturacion
       
        }
        listaItems.clear();
        
    }
    
    
    
}
