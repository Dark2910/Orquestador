package com.EEspindola.ServicioGetAll.DAO.Mapper;

import com.EEspindola.ServicioGetAll.ML.UsuarioML;
import com.EEspindola.ServicioGetAll.Utils.Constantes;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class UsuarioMapper implements RowMapper<UsuarioML> {
    @Override
    public UsuarioML mapRow(@NotNull ResultSet rs, int rowNum) throws SQLException {
        UsuarioML usuarioML = new UsuarioML();

        usuarioML.setIdUsuario(rs.getInt(1));
        usuarioML.setFolio(rs.getString(2));
        usuarioML.setNombre(rs.getString(3));
        usuarioML.setApellidoPaterno(rs.getString(4));
        usuarioML.setApellidoMaterno(rs.getString(5));

        SimpleDateFormat dateFormat = new SimpleDateFormat(Constantes.DATE_FORMAT);
        String fechaNacimiento = dateFormat.format(rs.getDate(6));

        usuarioML.setFechaNacimiento(fechaNacimiento);

        usuarioML.setUsername(rs.getString(7));
        usuarioML.setEmail(rs.getString(8));
        usuarioML.setPassword(rs.getString(9));
        usuarioML.setStatus(rs.getString(10));

        return usuarioML;
    }
}
