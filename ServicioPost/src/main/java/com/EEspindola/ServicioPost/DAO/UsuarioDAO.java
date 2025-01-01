package com.EEspindola.ServicioPost.DAO;

import com.EEspindola.ServicioPost.ML.UsuarioML;
import com.EEspindola.ServicioPost.Utils.Result;

import java.sql.SQLException;

public interface UsuarioDAO {

    Result UsuarioInsert(UsuarioML usuario) throws SQLException;

}
