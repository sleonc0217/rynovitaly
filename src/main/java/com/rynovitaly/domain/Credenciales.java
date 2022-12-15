
package com.rynovitaly.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name="usuario")

public class Credenciales implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Long idCredenciales;
    
    //atributios
    @NotEmpty
    private String username;
    
     @NotEmpty
    private String password;
   
//asociacion entre tablas
     @OneToMany
     @JoinColumn(name="id_usuario")
     private List<Rol> roles;
  
    
    
}
