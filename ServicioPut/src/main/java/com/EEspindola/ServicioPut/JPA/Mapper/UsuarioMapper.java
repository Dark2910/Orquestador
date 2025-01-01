package com.EEspindola.ServicioPut.JPA.Mapper;

import com.EEspindola.ServicioPut.JPA.Entities.UsuarioJPA;
import com.EEspindola.ServicioPut.ML.UsuarioML;
import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsuarioMapper {

    public static @NotNull UsuarioJPA Map(@NotNull UsuarioML usuarioML) throws ParseException {

        UsuarioJPA usuarioJPA = new UsuarioJPA();

        usuarioJPA.setIdUsuario( usuarioML.getIdUsuario() );
        usuarioJPA.setFolio( usuarioML.getFolio() );
        usuarioJPA.setNombre( usuarioML.getNombre() );
        usuarioJPA.setApellidoPaterno( usuarioML.getApellidoPaterno() );
        usuarioJPA.setApellidoMaterno( usuarioML.getApellidoMaterno() );

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = simpleDateFormat.parse(usuarioML.getFechaNacimiento());

        usuarioJPA.setFechaNacimiento(fechaNacimiento);

        usuarioJPA.setUsername( usuarioML.getUsername() );
        usuarioJPA.setEmail( usuarioML.getEmail() );
        usuarioJPA.setPassword( usuarioML.getPassword() );
        usuarioJPA.setStatus( usuarioML.getStatus() );

        return usuarioJPA;
    }

}
