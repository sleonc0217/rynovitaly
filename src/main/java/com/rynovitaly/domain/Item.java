
package com.rynovitaly.domain;

import lombok.Data;

@Data
public class Item extends Producto{
    
    private int cantidad; //almacenar la cantidad de items de un articulo
    
    public Item() {
    }
    
    public Item (Producto producto) {
        super.setIdProducto(producto.getIdProducto());
        super.setIdCategoria(producto.getIdCategoria());
        super.setNombre(producto.getNombre());
        super.setDescripcion(producto.getDescripcion());
        super.setPrecio(producto.getPrecio());
        super.setUnidades(producto.getUnidades());
        super.setMarca(producto.getMarca());
        super.setActivo(producto.isActivo());
        super.setRutaImagen(producto.getRutaImagen());
        this.cantidad = 0;
}
    
    
    
    
}

