
package com.rynovitaly.dao;


import com.rynovitaly.domain.Credenciales;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CredencialesDao extends JpaRepository<Credenciales,Long> {
    
    
 public Credenciales findByUsername (String username);


}

