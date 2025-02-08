package com.EEspindola.orquestador.controller;

import com.EEspindola.orquestador.exceptions.InvalidArgument;
import com.EEspindola.orquestador.dto.Result;
import com.EEspindola.orquestador.models.Usuario;
import com.EEspindola.orquestador.services.OrquestadorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orquestador")
public class Orquestador {

    @Autowired
    OrquestadorService service;

    @PostMapping
    public Result<?> OrquestadorGetAll(HttpSession session) {
        return service.GetAll(session);
    }

    @PostMapping("/{folioId}")
    public Result<?> OrquestadorGetByFolio(@PathVariable String folioId, HttpSession session){
        return service.GetByFolio(folioId,session);
    }

    @PostMapping("/post")
    public Result OrquestadorPost(@RequestBody Usuario usuario, HttpSession session) throws InvalidArgument {
        return service.Post(usuario,session);
    }

    @PostMapping("/put")
    public Result OrquestadorPut(@RequestBody Usuario usuario, HttpSession session) throws InvalidArgument {
        return service.Put(usuario,session);
    }

    @PostMapping("/delete/{folioId}")
    public Result OrquestadorDelete(@PathVariable String folioId, HttpSession session){
        return service.Delete(folioId, session);
    }

}
