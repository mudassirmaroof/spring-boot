package com.learning.model.dto.response;

import com.learning.enums.CommonEnum;
import com.learning.model.dto.MessageDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mudassir on 17/01/2017.
 */
public class ErrorResponse extends  ApiResponse{
    private List<MessageDTO> errors;

    public ErrorResponse(List<MessageDTO> errors) {
        this.errors = errors;
        this.status = CommonEnum.ERROR.toString();
    }

    public ErrorResponse(MessageDTO error) {
        this.errors = new ArrayList<MessageDTO>();
        this.errors.add(error);

        this.status = CommonEnum.ERROR.toString();
    }

    public List<MessageDTO> getErrors() {
        return errors;
    }

    public void setErrors(List<MessageDTO> errors) {
        this.errors = errors;
    }
}
