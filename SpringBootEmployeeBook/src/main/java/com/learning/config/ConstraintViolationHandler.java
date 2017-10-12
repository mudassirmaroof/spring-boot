package com.learning.config;

import com.learning.enums.CommonEnum;
import com.learning.model.dto.MessageDTO;
import com.learning.model.dto.response.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mudassir on 18/01/2017.
 */
@ControllerAdvice
public class ConstraintViolationHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse processDataIntegrityViolation(DataIntegrityViolationException ex) {
        List<MessageDTO> messages = new ArrayList<MessageDTO>();
        messages.add(new MessageDTO(ex.getCause().getCause().getMessage(), CommonEnum.ERROR.toString()));
        return new ErrorResponse(messages);
    }
}
