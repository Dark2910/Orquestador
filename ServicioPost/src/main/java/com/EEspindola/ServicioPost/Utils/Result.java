package com.EEspindola.ServicioPost.Utils;

import java.util.List;

public class Result <T>{

    public Boolean isCorrect;
    public List<T> objects;
    public T object;
    public Exception exception;
    public String message;

}
