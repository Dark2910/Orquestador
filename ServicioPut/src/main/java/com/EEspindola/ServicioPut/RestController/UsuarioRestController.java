package com.EEspindola.ServicioPut.RestController;

import com.EEspindola.ServicioPut.DAO.UsuarioDAO;
import com.EEspindola.ServicioPut.Service.UsuarioService;
import com.EEspindola.ServicioPut.Utils.Result;
import com.EEspindola.ServicioPut.ML.UsuarioML;
import com.EEspindola.ServicioPut.JPA.UsuarioRepository;
import com.EEspindola.ServicioPut.Utils.FolioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioDAO usuarioDAO;

    @PostMapping("/put")
    public Result<?> Put(@RequestHeader(value = "folioRequest", required = false) String folioRequest , @RequestBody UsuarioML usuario){

        Result<?> result = new Result<>();

        folioRequest = (folioRequest == null || folioRequest.isEmpty() || folioRequest.isBlank())? FolioRequest.CrearFolioRequest() : folioRequest;

        try {
            UsuarioML usuarioRecuperado = GetByFolio(usuario.getFolio());

//            UsuarioJPA usuarioActualizado =  usuarioServiceImplementation.Normalizar(usuario, usuarioRecuperado);
//            usuarioRepository.save( usuarioActualizado);

            UsuarioML usuarioNormalizado = usuarioService.Normalizar(usuario, usuarioRecuperado);

            result = usuarioDAO.UsuarioUpdate(usuarioNormalizado);
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

        return (UsuarioML) result.object;
    }

}
