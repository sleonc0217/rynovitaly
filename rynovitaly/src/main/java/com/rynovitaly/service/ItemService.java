/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rynovitaly.service;

import com.rynovitaly.domain.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public interface ItemService {
    //se definen los cuatro metodos de un CRUD (Create , Read , Update and Delete)
    
    //en lugar de una tabla de BD se usa  una ArraList para resgistro temporal
    public List<Item> listaItems = new ArrayList<>();
    

    //Retorna la lista de items
    public List<Item> getItems();
    
    //SI el item.id tiene un valor se busca y se actualiza
    //si el item.id NO tiene valor , se inserta el objeto en la tabla , genera un nuevo item
    public void save (Item item);
    
     //Elimina el registro que tiene el id igual a item.id
    public void delete (Item item);
    
      //Dado un item.ID se busca en la tabla y se retorna todo el objeto
    //se retorna todo el objeto item
    public Item getItem(Item item);
    
    public void actualiza(Item item);
    

    public void facturar();
    
    
    
    
    
}
