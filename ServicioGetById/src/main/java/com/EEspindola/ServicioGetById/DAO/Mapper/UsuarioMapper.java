package com.EEspindola.ServicioGetById.DAO.Mapper;

import com.EEspindola.ServicioGetById.ML.UsuarioML;
import com.EEspindola.ServicioGetById.Utils.Constantes;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class UsuarioMapper implements RowMapper<UsuarioML> {
    @Override
    public UsuarioML mapRow(ResultSet rs, int rowNum) throws SQLException {

        UsuarioML usuario = new UsuarioML();

        usuario.setIdUsuario(rs.getInt("IDUSUARIO"));
        usuario.setFolio(rs.getString("FOLIO"));
        usuario.setNombre(rs.getString("NOMBRE"));
        usuario.setApellidoPaterno(rs.getString("APELLIDOPATERNO"));
        usuario.setApellidoMaterno(rs.getString("APELLIDOMATERNO"));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constantes.DATE_FORMAT);
        String fechaNacimiento = simpleDateFormat.format(rs.getDate("FECHANACIMIENTO"));

        usuario.setFechaNacimiento(fechaNacimiento);

        usuario.setUsername(rs.getString("USERNAME"));
        usuario.setEmail(rs.getString("EMAIL"));
        usuario.setPassword(rs.getString("PASSWORD"));
        usuario.setStatus(rs.getString("STATUS"));

        return usuario;
    }
}
