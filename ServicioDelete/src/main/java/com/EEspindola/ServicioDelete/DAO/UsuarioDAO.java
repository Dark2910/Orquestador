package com.EEspindola.ServicioDelete.DAO;

import com.EEspindola.ServicioDelete.ML.UsuarioML;
import com.EEspindola.ServicioDelete.Utils.Result;

import java.sql.SQLException;

public interface UsuarioDAO {

    Result UsuarioDelete(UsuarioML usuario) throws SQLException;

}
