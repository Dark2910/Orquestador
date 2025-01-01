package com.EEspindola.ServicioPost.JPA;

import com.EEspindola.ServicioPost.JPA.Entities.UsuarioJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioJPA, Object> {
}
