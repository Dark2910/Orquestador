package com.EEspindola.ServicioDelete.JPA;

import com.EEspindola.ServicioDelete.JPA.Entities.UsuarioJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioJPA, Object> {
}
