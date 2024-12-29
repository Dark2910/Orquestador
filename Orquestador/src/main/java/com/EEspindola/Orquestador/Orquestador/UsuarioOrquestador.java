package com.EEspindola.Orquestador.Orquestador;

import com.EEspindola.Orquestador.Exceptions.InvalidArgument;
import com.EEspindola.Orquestador.ML.Result;
import com.EEspindola.Orquestador.ML.Usuario;
import com.EEspindola.Orquestador.Utils.FolioRequest;
import com.EEspindola.Orquestador.Validator.ValidateInput;
import jakarta.servlet.http.HttpSession;
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
@RequestMapping("/orquestador")
public class UsuarioOrquestador {

    @Autowired
    private ValidateInput validateInput;

    private RestTemplate restTemplate = new RestTemplate();

    @PostMapping
    public Result OrquestadorGetAll(HttpSession session){
        //session.setAttribute("session", FolioRequest.CrearFolioRequest());

        HttpHeaders httpHeader = new HttpHeaders();
        httpHeader.add("folioRequest", FolioRequest.CrearFolioRequest());

        String endpoint = "http://localhost:8081/usuarioAPI";

        HttpEntity httpEntity = new HttpEntity(HttpEntity.EMPTY, httpHeader);

        ResponseEntity<Result> response = restTemplate.exchange(
                endpoint,
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<Result>() {
                }
        );

        return  response.getBody();
    }

    @PostMapping("/{folioId}")
    public Result OrquestadorGetByFolio(@PathVariable String folioId, HttpSession session){
        //session.setAttribute("session", FolioRequest.CrearFolioRequest());

        HttpHeaders httpHeader = new HttpHeaders();
        httpHeader.add("folioRequest", FolioRequest.CrearFolioRequest());

        String endpoint = MessageFormat.format("http://localhost:8082/usuarioAPI/{0}", folioId);

        HttpEntity httpEntity = new HttpEntity<>(HttpEntity.EMPTY, httpHeader);

        ResponseEntity<Result> response = restTemplate.exchange(
                endpoint,
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<Result>() {
                }
        );

        return  response.getBody();
    }

    @PostMapping("/post")
    public Result OrquestadorPost(@RequestBody Usuario usuario, HttpSession session) throws InvalidArgument {
        //session.setAttribute("session", FolioRequest.CrearFolioRequest());

        validateInput.BindingResult(usuario, "Usuario");

        HttpHeaders httpHeader = new HttpHeaders();
        httpHeader.add("folioRequest", FolioRequest.CrearFolioRequest());

        String endpoint = "http://localhost:8083/usuarioAPI/post";

        HttpEntity httpEntity = new HttpEntity(usuario, httpHeader);

        ResponseEntity<Result> response = restTemplate.exchange(
                endpoint,
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<Result>() {
                }
        );

        return  response.getBody();
    }

    @PostMapping("/put")
    public Result OrquestadorPut(@RequestBody Usuario usuario, HttpSession session) throws InvalidArgument {
        //session.setAttribute("session", FolioRequest.CrearFolioRequest());

        validateInput.BindingResult(usuario, "Usuario");

        HttpHeaders httpHeader = new HttpHeaders();
        httpHeader.add("folioRequest", FolioRequest.CrearFolioRequest());

        String endpoint = "http://localhost:8084/usuarioAPI/put";

        HttpEntity httpEntity = new HttpEntity(usuario, httpHeader);

        ResponseEntity<Result> response = restTemplate.exchange(
                endpoint,
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<Result>() {
                }
        );

        return  response.getBody();
    }

    @PostMapping("/delete/{folioId}")
    public Result OrquestadorDelete(@PathVariable String folioId, HttpSession session){
        //session.setAttribute("session", FolioRequest.CrearFolioRequest());

        HttpHeaders httpHeader = new HttpHeaders();
        httpHeader.add("folioRequest", FolioRequest.CrearFolioRequest());

        String endpoint = MessageFormat.format("http://localhost:8085/usuarioAPI/delete/{0}", folioId);

        HttpEntity httpEntity = new HttpEntity(HttpEntity.EMPTY, httpHeader);

        ResponseEntity<Result> response = restTemplate.exchange(
                endpoint,
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<Result>() {
                }
        );

        return  response.getBody();
    }

}
