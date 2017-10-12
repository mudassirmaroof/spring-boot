package com.learning.controller;

import com.learning.enums.ErrorEnum;
import com.learning.model.dto.response.AddressResponse;
import com.learning.model.dto.response.EmployeesResponse;
import com.learning.model.dto.response.ErrorResponse;
import com.learning.model.entity.Address;
import com.learning.model.entity.Employee;
import com.learning.service.AddressService;
import com.learning.service.EmployeeService;
import com.learning.util.ErrorResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by mudassir on 04/01/2017.
 */
@RestController
@RequestMapping ("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final AddressService addressService;

    public EmployeeController(EmployeeService employeeService,
                              AddressService addressService) {
        this.employeeService = employeeService;
        this.addressService = addressService;
    }

    /*
     * GET Endpoints
     */
    @RequestMapping (method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity get () {
        return new ResponseEntity<EmployeesResponse>(new EmployeesResponse(employeeService.getEmployees()), HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @RequestMapping (value = "/{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity get (@PathVariable("id") Long id,
                               @RequestParam(required = false) boolean fetchDetails) {
        Employee employee;
        if (fetchDetails) {
            employee = employeeService.getEmployeeByIdWithDetails(id);
        } else {
            employee = employeeService.getEmployeeById(id);
        }
        if (ObjectUtils.isEmpty(employee)) {
            return new ResponseEntity<EmployeesResponse>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<EmployeesResponse>(new EmployeesResponse(employee), HttpStatus.OK);
    }

    /*
     * POST Endpoints
     */
    @RequestMapping (method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity create (@Validated @RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return new ResponseEntity<EmployeesResponse>(new EmployeesResponse(employee), HttpStatus.CREATED);
    }

    /*
     * PUT Endpoints
     */
    @RequestMapping (value = "/{id}/address",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity update (@PathVariable("id") Long id,
                                  @Validated @RequestBody Address address) {
        Employee employee = employeeService.getEmployeeById(id);
        if (ObjectUtils.isEmpty(employee)) {
            return new ResponseEntity<ErrorResponse>(new ErrorResponse(ErrorResponseUtil.
                    getApplicableErrorMessage(ErrorEnum.INVALID_EMPLOYEE_ID.toString())), HttpStatus.NOT_FOUND);
        }

        if (!ObjectUtils.isEmpty(address.getId())) {
            Address addressPersisted = addressService.getAddressById(address.getId());
            if (ObjectUtils.isEmpty(addressPersisted)) {
                return new ResponseEntity<ErrorResponse>(new ErrorResponse(ErrorResponseUtil.
                        getApplicableErrorMessage(ErrorEnum.INVALID_ADDRESS_ID.toString())), HttpStatus.NOT_FOUND);
            }
        } else {
            Address addressWithSameCategory = addressService.getAddressByEmployeeAndCategory(employee.getId(), address.getCategory());
            if (!ObjectUtils.isEmpty(addressWithSameCategory)) {
                return new ResponseEntity<ErrorResponse>(new ErrorResponse(ErrorResponseUtil.
                        getApplicableErrorMessage(ErrorEnum.ADDRESS_WITH_CATEGORY_ALREADY_EXISTS.toString())), HttpStatus.NOT_FOUND);
            }
        }

        address.setEmployee(employee);
        address = addressService.saveAddress(address);
        return new ResponseEntity<AddressResponse>(new AddressResponse(address), HttpStatus.OK);
    }
}
