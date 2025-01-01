package com.EEspindola.ServicioPut.DAO;

import com.EEspindola.ServicioPut.ML.UsuarioML;
import com.EEspindola.ServicioPut.Utils.Result;

import java.sql.SQLException;

public interface UsuarioDAO {

    Result UsuarioUpdate(UsuarioML usuario) throws SQLException;

}
