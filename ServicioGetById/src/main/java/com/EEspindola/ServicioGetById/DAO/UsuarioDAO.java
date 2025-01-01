package com.EEspindola.ServicioGetById.DAO;

import com.EEspindola.ServicioGetById.ML.UsuarioML;
import com.EEspindola.ServicioGetById.Utils.Result;

public interface UsuarioDAO {

    Result<UsuarioML> GetByFolio(String folioId);

}
