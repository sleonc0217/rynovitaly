
package com.rynovitaly.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="categoria")
public class Categoria implements Serializable{
    
    private static final long serialVersionUID= 1L;
    

    



        @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_categoria")
    private Long idCategoria;
        private String nombre;
    private String descripcion;


    
    
    
    
    
    public Categoria() {
        
    }

    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;

    }


  
   
    
    
    
    
    
    
    
    
}
