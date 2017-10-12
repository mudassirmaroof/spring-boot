package com.learning.config;

import com.learning.enums.CommonEnum;
import com.learning.model.dto.MessageDTO;
import com.learning.model.dto.response.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by mudassir on 17/01/2017.
 */
@ControllerAdvice
public class PayloadValidationHandler {

    @Autowired
    private MessageSource msgSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse processValidationErrors(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        return processFieldErrors(result.getFieldErrors());
    }

    private ErrorResponse processFieldErrors(List<FieldError> fieldErrors) {
        List<MessageDTO> errors = new ArrayList<MessageDTO>();
        if (!ObjectUtils.isEmpty(fieldErrors)) {
            for (FieldError error : fieldErrors) {
                Locale currentLocale = LocaleContextHolder.getLocale();
                String msg = msgSource.getMessage(error.getDefaultMessage(), null, currentLocale);
                errors.add(new MessageDTO(CommonEnum.ERROR.toString(), msg));
            }
        }

        return new ErrorResponse(errors);
    }
}
