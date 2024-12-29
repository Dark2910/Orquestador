package com.EEspindola.ServicioPost.Service;

import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.UUID;

@Service
public class UsuarioServiceImplementation implements UsuarioService{

    @Override
    public String CrearFolioId() {

        //Long milis = System.currentTimeMillis();
        //Date date = new Date(milis);

        UUID uuid = UUID.randomUUID();

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String text = date.format(formatter);
        LocalDateTime parsedDate = LocalDateTime.parse(text, formatter);

        String folio = MessageFormat.format("{0}-{1}", uuid, parsedDate);

        return folio;
    }
}
