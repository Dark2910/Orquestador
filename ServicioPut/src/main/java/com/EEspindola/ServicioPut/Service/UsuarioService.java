package com.EEspindola.ServicioPut.Service;


import com.EEspindola.ServicioPut.JPA.UsuarioJPA;
import com.EEspindola.ServicioPut.ML.UsuarioML;

import java.text.ParseException;

public interface UsuarioService {

    public UsuarioJPA Normalizar(UsuarioML usuario,
                                 UsuarioML usuarioRecuperado) throws ParseException;

}
