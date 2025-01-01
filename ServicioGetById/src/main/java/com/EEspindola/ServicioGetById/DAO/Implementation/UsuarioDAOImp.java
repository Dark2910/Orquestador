package com.EEspindola.ServicioGetById.DAO.Implementation;

import com.EEspindola.ServicioGetById.DAO.Mapper.UsuarioMapper;
import com.EEspindola.ServicioGetById.DAO.UsuarioDAO;
import com.EEspindola.ServicioGetById.ML.UsuarioML;
import com.EEspindola.ServicioGetById.Utils.Constantes;
import com.EEspindola.ServicioGetById.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UsuarioDAOImp implements UsuarioDAO {

    @Autowired
    @Qualifier(Constantes.HIKARI_CONNECTION)
    private JdbcTemplate jdbcTemplate;

    public UsuarioDAOImp(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Result<UsuarioML> GetByFolio(String folioId) {

        Result<UsuarioML> result = new Result<>();
        String query = Constantes.Usuario_GET_BY_FOLIO;

        try{
            result.object = jdbcTemplate.query(query, new UsuarioMapper(), folioId).get(0);
            result.isCorrect = true;

        } catch (Exception e) {
            result.isCorrect = false;
            result.exception = e;
            result.message = e.getLocalizedMessage();
        }

        return result;
    }
}
