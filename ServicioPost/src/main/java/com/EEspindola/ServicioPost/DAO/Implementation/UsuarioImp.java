package com.EEspindola.ServicioPost.DAO.Implementation;

import com.EEspindola.ServicioPost.DAO.UsuarioDAO;
import com.EEspindola.ServicioPost.ML.UsuarioML;
import com.EEspindola.ServicioPost.Service.UsuarioService;
import com.EEspindola.ServicioPost.Service.UsuarioServiceImplementation;
import com.EEspindola.ServicioPost.Utils.Constantes;
import com.EEspindola.ServicioPost.Utils.Result;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.text.MessageFormat;

@Repository
public class UsuarioImp implements UsuarioDAO {

    @Autowired
    @Qualifier(Constantes.HIKARI_CONNECTION)
    private JdbcTemplate jdbcTemplate;

    @Autowired
    UsuarioService usuarioService;

    @Override
    public Result<?> UsuarioInsert(UsuarioML usuario) throws SQLException {

        Result<?> result = new Result<>();

        String query = Constantes.USUARIO_INSERT;

        Integer rowAffected = jdbcTemplate.execute(query, (CallableStatementCallback<Integer>) callableStatementCallback ->{

            callableStatementCallback.setString(1, usuarioService.CrearFolioId());
            callableStatementCallback.setString(2, usuario.getNombre());
            callableStatementCallback.setString(3, usuario.getApellidoPaterno());
            callableStatementCallback.setString(4, usuario.getApellidoMaterno());
            callableStatementCallback.setString(5, usuario.getFechaNacimiento());
            callableStatementCallback.setString(6, usuario.getUsername());
            callableStatementCallback.setString(7, usuario.getEmail());
            callableStatementCallback.setString(8, usuario.getPassword());

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
