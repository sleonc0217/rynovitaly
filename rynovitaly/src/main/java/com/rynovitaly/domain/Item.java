
package com.rynovitaly.domain;

import lombok.Data;

@Data
public class Item extends Producto{
    
    private int cantidad; //almacenar la cantidad de items de un articulo
    
    public Item() {
    }
    
    public Item (Producto articulo) {
        super.setIdProducto(articulo.getIdProducto());
        super.setCategoria(producto.getCategoria());
        /*super.setIdCategoria(articulo.getIdCategoria());*/
        super.setDescripcion(articulo.getDescripcion());
        super.setDetalle(articulo.getDetalle());
        super.setPrecio(articulo.getPrecio());
        super.setExistencias(articulo.getExistencias());
        super.setActivo(articulo.isActivo());
        super.setRutaImagen(articulo.getRutaImagen());
        this.cantidad = 0;
}
    
    
    
    
}

