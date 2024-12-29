package com.EEspindola.ServicioGetAll.RestController;

import com.EEspindola.ServicioGetAll.DAO.Implementation.UsuarioImp;
import com.EEspindola.ServicioGetAll.JPA.Entities.UsuarioJPA;
import com.EEspindola.ServicioGetAll.JPA.Mapper.UsuarioMapper;
import com.EEspindola.ServicioGetAll.JPA.UsuarioRepository;
import com.EEspindola.ServicioGetAll.Utils.Result;
import com.EEspindola.ServicioGetAll.ML.UsuarioML;
import com.EEspindola.ServicioGetAll.Utils.FolioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarioAPI")
public class UsuarioRestController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioImp usuarioDAO;

    @PostMapping
    public Result GetAll(@RequestHeader(value = "folioRequest", required = false) String folioRequest){

        folioRequest = (folioRequest == null || folioRequest.isEmpty() || folioRequest.isBlank())? FolioRequest.CrearFolioRequest() : folioRequest;

        Result result = new Result<>();

        try {

//            List<UsuarioJPA> usuariosJPA = usuarioRepository.findAll();
//            List<UsuarioML> usuariosML = new ArrayList<>();
//
//            for(UsuarioJPA usuarioJPA : usuariosJPA){
//               usuariosML.add(UsuarioMapper.Map(usuarioJPA));
//            }

            List<UsuarioML> usuariosML = usuarioDAO.GetAll().objects;

            result.objects = usuariosML;
            result.message = MessageFormat.format("Folio: {0}", folioRequest);
            result.isCorrect = true;

        } catch (Exception e){
            result.isCorrect = false;
            result.exception = e;
            result.message = e.getLocalizedMessage();
        }
        return result;
    }


}
