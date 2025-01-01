package com.EEspindola.ServicioGetAll.DAO.Implementation;

import com.EEspindola.ServicioGetAll.DAO.Mapper.UsuarioMapper;
import com.EEspindola.ServicioGetAll.DAO.UsuarioDAO;
import com.EEspindola.ServicioGetAll.Utils.Constantes;
import com.EEspindola.ServicioGetAll.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioImp implements UsuarioDAO {

    @Autowired
    @Qualifier(Constantes.HIKARI_CONNECTION)
    private JdbcTemplate jdbcTemplate;

    @Override
    public Result GetAll() {
        Result result = new Result();

        String query = Constantes.USUARIO_GET_ALL;

        try {
            result.objects = jdbcTemplate.query(query, new UsuarioMapper());
            result.isCorrect = true;

        } catch (Exception e){
            result.isCorrect = true;
            result.exception = e;
            result.message = e.getLocalizedMessage();
        }
        return  result;
    }
}
