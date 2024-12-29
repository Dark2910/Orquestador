package com.EEspindola.ServicioGetById.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioJPA, Object> {

    public Optional<UsuarioJPA> findByFolio(String folio);

}
