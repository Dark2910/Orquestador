package com.EEspindola.ServicioPut.JPA;

import com.EEspindola.ServicioPut.JPA.Entities.UsuarioJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioJPA, Object> {
}
