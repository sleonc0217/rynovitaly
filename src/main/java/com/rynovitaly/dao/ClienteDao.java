
package com.rynovitaly.dao;

import com.rynovitaly.domain.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteDao extends JpaRepository<Cliente,Long> {
    
    public List<Cliente> findByCorreo(String correo);
    
    
    public List<Cliente> findByApellidos(String apellidos);
}
