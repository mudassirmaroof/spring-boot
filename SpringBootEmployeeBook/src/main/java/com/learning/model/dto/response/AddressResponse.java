package com.learning.model.dto.response;

import com.learning.enums.CommonEnum;
import com.learning.model.entity.Address;

/**
 * Created by mudassir on 17/01/2017.
 */
public class AddressResponse extends ApiResponse {
    private Address data;

    public AddressResponse(Address data) {
        this.data = data;
        this.status = CommonEnum.SUCCESS.toString();
    }

    public Address getData() {
        return data;
    }

    public void setData(Address data) {
        this.data = data;
    }
}
