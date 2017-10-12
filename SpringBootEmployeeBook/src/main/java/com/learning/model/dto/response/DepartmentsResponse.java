package com.learning.model.dto.response;

import com.learning.enums.CommonEnum;
import com.learning.model.entity.Department;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mudassir on 18/01/2017.
 */
public class DepartmentsResponse extends ApiResponse {
    private List<Department> data;

    public DepartmentsResponse(List<Department> data) {
        this.data = data;
        this.status = CommonEnum.SUCCESS.toString();
    }

    public DepartmentsResponse(Department department) {
        this.data = new ArrayList<Department>();
        this.data.add(department);
        this.status = CommonEnum.SUCCESS.toString();
    }



    public List<Department> getData() {
        return data;
    }

    public void setData(List<Department> data) {
        this.data = data;
    }
}
