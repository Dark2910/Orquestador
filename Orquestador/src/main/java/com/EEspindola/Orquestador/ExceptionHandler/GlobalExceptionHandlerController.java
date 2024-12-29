package com.EEspindola.Orquestador.ExceptionHandler;

import com.EEspindola.Orquestador.Exceptions.InvalidArgument;
import com.EEspindola.Orquestador.ML.Result;
import com.EEspindola.Orquestador.Utils.FolioRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler({MethodArgumentNotValidException.class, InvalidArgument.class})
    protected ResponseEntity<Result> handleNoHandlerFoundException(InvalidArgument ex){

        Result<String> result = new Result<>();

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(this::mensajeDeErrorFormateado)
                .collect(Collectors.toList());

        result.setObjects(errors);
        result.setMessage("Folio: " + ex.getFolioRequest());

        return ResponseEntity.badRequest().body(result);
    }

    private String mensajeDeErrorFormateado(FieldError fieldError){
        return fieldError.getDefaultMessage().concat(" ( ").concat(fieldError.getField() + " ).");
    }

}
