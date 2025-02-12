package com.EEspindola.ServicioDelete.DAO.Implementation;

import com.EEspindola.ServicioDelete.DAO.UsuarioDAO;
import com.EEspindola.ServicioDelete.ML.UsuarioML;
import com.EEspindola.ServicioDelete.Utils.Constantes;
import com.EEspindola.ServicioDelete.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class UsuarioDAOImp implements UsuarioDAO {

    @Autowired
    @Qualifier(Constantes.HIKARI_CONNECTION)
    private JdbcTemplate jdbcTemplate;

    @Override
    public Result<?> UsuarioDelete(UsuarioML usuario) throws SQLException {

        Result<?> result = new Result<>();

        String query = Constantes.USUARIO_DELETE;

        Integer rowAffected = jdbcTemplate.execute(query, (CallableStatementCallback<Integer>) callableStatementCallback -> {

            callableStatementCallback.setString(1, usuario.getFolio());
            //callableStatementCallback.setString("pFolder", usuario.getFolio());

            callableStatementCallback.execute();

            return callableStatementCallback.getUpdateCount();
        });

        if(rowAffected != null && rowAffected != 0){
            result.isCorrect = true;
        } else {
            throw new SQLException();
        }

        return result;
    }
}
