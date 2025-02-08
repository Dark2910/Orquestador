package com.EEspindola.orquestador.services;

import com.EEspindola.orquestador.exceptions.InvalidArgument;
import com.EEspindola.orquestador.dto.Result;
import com.EEspindola.orquestador.models.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface OrquestadorService {

    @PostMapping
    Result<?> GetAll(HttpSession session);

    @PostMapping("/{folioId}")
    Result<?> GetByFolio(@PathVariable String folioId, HttpSession session);

    @PostMapping("/post")
    Result<?> Post(@RequestBody Usuario usuario, HttpSession session) throws InvalidArgument;

    @PostMapping("/put")
    Result<?> Put(@RequestBody Usuario usuario, HttpSession session) throws InvalidArgument;

    @PostMapping("/delete/{folioId}")
    Result<?> Delete(@PathVariable String folioId, HttpSession session);
}
