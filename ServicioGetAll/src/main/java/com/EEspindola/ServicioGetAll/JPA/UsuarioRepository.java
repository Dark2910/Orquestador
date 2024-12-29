package com.EEspindola.ServicioGetAll.JPA;

import com.EEspindola.ServicioGetAll.JPA.Entities.UsuarioJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioJPA, Object> {
}
