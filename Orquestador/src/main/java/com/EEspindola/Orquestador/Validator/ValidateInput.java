package com.EEspindola.Orquestador.Validator;

import com.EEspindola.Orquestador.Exceptions.InvalidArgument;
import com.EEspindola.Orquestador.Utils.FolioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

@Component
public class ValidateInput {

    @Autowired
    private Validator validator;

    public BindingResult BindingResult (Object target, String objectName) throws InvalidArgument  {

        BindingResult bindingResult = new BeanPropertyBindingResult(target, objectName);

        validator.validate(target, bindingResult);

        if(bindingResult.hasErrors()){
            throw new InvalidArgument(bindingResult, FolioRequest.CrearFolioRequest());
        }

        return bindingResult;
    }

}
