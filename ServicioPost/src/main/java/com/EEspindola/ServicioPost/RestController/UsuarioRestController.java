package com.EEspindola.ServicioPost.RestController;

import com.EEspindola.ServicioPost.JPA.Result;
import com.EEspindola.ServicioPost.JPA.UsuarioRepository;
import com.EEspindola.ServicioPost.ML.UsuarioML;
import com.EEspindola.ServicioPost.Mapper.UsuarioMapper;
import com.EEspindola.ServicioPost.Service.UsuarioServiceImplementation;
import com.EEspindola.ServicioPost.Utils.FolioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;

@RestController
@RequestMapping("/usuarioAPI")
public class UsuarioRestController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioServiceImplementation usuarioServiceImplementation;

    @PostMapping("/post")
    public Result Post(@RequestHeader(value = "folioRequest", required = false) String folioRequest, @RequestBody UsuarioML usuarioML){

        folioRequest = (folioRequest == null || folioRequest.isEmpty() || folioRequest.isBlank())? FolioRequest.CrearFolioRequest() : folioRequest;

        Result result = new Result<>();

        try {
            usuarioML.setFolio(usuarioServiceImplementation.CrearFolioId());
            usuarioML.setStatus("1");

            usuarioRepository.save(UsuarioMapper.Map(usuarioML));

            result.message = MessageFormat.format("Folio: {0}",folioRequest);
            result.isCorrect = true;

        } catch (Exception e){
            result.isCorrect = false;
            result.exception = e;
            result.message = e.getLocalizedMessage();
        }
        return result;
    }


}
