package com.EEspindola.ServicioDelete.RestController;

import com.EEspindola.ServicioDelete.DAO.UsuarioDAO;
import com.EEspindola.ServicioDelete.Utils.Result;
import com.EEspindola.ServicioDelete.JPA.UsuarioRepository;
import com.EEspindola.ServicioDelete.ML.UsuarioML;
import com.EEspindola.ServicioDelete.Utils.FolioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

@RestController
@RequestMapping("/usuarioAPI")
public class UsuarioRestController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioDAO usuarioDAO;

    @PostMapping("/delete/{folioId}")
    public Result Delete(@RequestHeader(value = "folioRequest", required = false) String folioRequest, @PathVariable String folioId){

        folioRequest = (folioRequest == null || folioRequest.isEmpty() || folioRequest.isBlank())? FolioRequest.CrearFolioRequest() : folioRequest;

        Result result = new Result<>();

        try {
            UsuarioML usuarioRecuperado = GetByFolio(folioId);

            //usuarioRepository.delete(UsuarioMapper.Map(usuarioRecuperado));

            result = usuarioDAO.UsuarioDelete(usuarioRecuperado);
            result.message = MessageFormat.format("Folio: {0}",folioRequest);

        } catch (Exception e){
            result.isCorrect = false;
            result.exception = e;
            result.message = e.getLocalizedMessage();
        }
        return result;
    }

    public UsuarioML GetByFolio(@PathVariable String folioId){
        RestTemplate restTemplate = new RestTemplate();

        String endpoint = MessageFormat.format("http://localhost:8082/usuarioAPI/{0}", folioId);

        ResponseEntity<Result<UsuarioML>> response = restTemplate.exchange(
                endpoint,
                HttpMethod.POST,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<Result<UsuarioML>>() {
                }
        );
        Result result = response.getBody();

        return (UsuarioML)result.object;
    }



}
