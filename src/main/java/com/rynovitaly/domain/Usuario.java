
package com.rynovitaly.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
    
    private static final long serialVersionUID= 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Long idUsuario;
    
    
    private String nombre;
    private String apellidos;
    private String email;
    private String contrasena;
    private int telefono;

    @JoinColumn(name="id_credito",referencedColumnName="id_credito")
    @ManyToOne
    private Credito credito;

    public Usuario() {
    }

    public Usuario(String nombre, String apellidos, String email, String contrasena, int telefono, Credito credito) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.credito = credito;
    }
    
    
    
    
    
    
    
   

    

    
   
    
    
    
    
    
    
    
}
