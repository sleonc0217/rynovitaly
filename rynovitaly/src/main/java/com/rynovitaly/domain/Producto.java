
package com.rynovitaly.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="producto")
public class Producto implements Serializable{
    
    private static final long serialVersionUID= 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Long idProducto;
    @Column(name="id_Categoria")
    private Long idCategoria;
    private String nombre;
    private String descripcion;
    private double precio;
    private int  unidades;
    private String marca;
    private boolean activo;
    
    
    
    
    
    
    public Producto() {
        
    }

    public Producto(Long idCategoria, String nombre, String descripcion, double precio, int unidades, String marca, boolean activo) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.unidades = unidades;
        this.marca = marca;
        this.activo = activo;
    }



    
   
    
  
    
    
    
    
}
