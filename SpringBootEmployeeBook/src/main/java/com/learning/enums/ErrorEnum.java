package com.learning.enums;

/**
 * Created by mudassir on 07/02/2017.
 */
public enum ErrorEnum {

    INVALID_EMPLOYEE_ID ("error.employee.id.invalid"),
    INVALID_ADDRESS_ID ("error.address.id.invalid"),
    ADDRESS_WITH_CATEGORY_ALREADY_EXISTS("error.address.category.exist");

    String error;

    ErrorEnum(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return error;
    }
}
