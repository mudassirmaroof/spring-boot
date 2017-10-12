package com.learning.model.dto.response;

import com.learning.enums.CommonEnum;
import com.learning.model.entity.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mudassir on 17/01/2017.
 */
public class EmployeesResponse extends ApiResponse {
    private List<Employee> data;

    public EmployeesResponse(List<Employee> data) {
        this.data = data;
        this.status = CommonEnum.SUCCESS.toString();
    }

    public EmployeesResponse(Employee employee) {
        data = new ArrayList<Employee>();
        data.add(employee);
        this.status = CommonEnum.SUCCESS.toString();
    }

    public List<Employee> getData() {
        return data;
    }

    public void setData(List<Employee> data) {
        this.data = data;
    }


}
