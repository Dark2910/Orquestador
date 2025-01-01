package com.EEspindola.ServicioPut.Service;


import com.EEspindola.ServicioPut.JPA.Entities.UsuarioJPA;
import com.EEspindola.ServicioPut.ML.UsuarioML;

import java.text.ParseException;

public interface UsuarioService {

    public UsuarioML Normalizar(UsuarioML usuario,
                                 UsuarioML usuarioRecuperado) throws ParseException;

}
