package com.EEspindola.ServicioGetById.Utils;

public class Constantes {

    public static final String Usuario_GET_BY_FOLIO =
            "SELECT IDUSUARIO, FOLIO, NOMBRE, APELLIDOPATERNO, APELLIDOMATERNO, FECHANACIMIENTO, USERNAME, EMAIL, PASSWORD, STATUS " +
            "FROM USUARIO " +
            "WHERE FOLIO = ?";

    public static final String HIKARI_CONNECTION = "hikariTemplate";

    public static final String DATE_FORMAT = "yyyy-MM-dd";

}
