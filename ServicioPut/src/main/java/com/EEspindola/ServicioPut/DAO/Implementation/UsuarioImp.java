package com.EEspindola.ServicioPut.DAO.Implementation;

import com.EEspindola.ServicioPut.DAO.UsuarioDAO;
import com.EEspindola.ServicioPut.ML.UsuarioML;
import com.EEspindola.ServicioPut.Utils.Constantes;
import com.EEspindola.ServicioPut.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class UsuarioImp implements UsuarioDAO {

    @Autowired
    @Qualifier(Constantes.HIKARI_CONNECTION)
    private JdbcTemplate jdbcTemplate;

    @Override
    public Result<?> UsuarioUpdate(UsuarioML usuario) throws SQLException {

        Result<?> result = new Result<>();

        String query = Constantes.USUARIO_UPDATE;

        Integer rowAffected = jdbcTemplate.execute(query, (CallableStatementCallback<Integer>) callableStatementCallback -> {

            callableStatementCallback.setString("pFolio", usuario.getFolio());
            callableStatementCallback.setString("pNombre", usuario.getNombre());
            callableStatementCallback.setString("pApellidoPaterno", usuario.getApellidoPaterno());
            callableStatementCallback.setString("pApellidoMaterno", usuario.getApellidoMaterno());
            callableStatementCallback.setString("pFechaNacimiento", usuario.getFechaNacimiento());
            callableStatementCallback.setString("pUsername", usuario.getUsername());
            callableStatementCallback.setString("pEmail", usuario.getEmail());
            callableStatementCallback.setString("pPassword", usuario.getPassword());
            callableStatementCallback.setString("pStatus", usuario.getStatus());

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
