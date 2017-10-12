package com.learning.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by mudassir on 04/01/2017.
 */
@Entity
@Table (name = "ADDRESS", uniqueConstraints =
    @UniqueConstraint(name = "EMPLOYEE_ADDRESS__CATEGORY_UNQ", columnNames = {"EMPLOYEE_ID", "CATEGORY"}))
@EntityListeners(AuditingEntityListener.class)
public class Address extends Audit{
    /*
     * Key Fields
     */
    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, updatable = false)
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonIgnore
    @JoinColumn (name = "EMPLOYEE_ID", foreignKey = @ForeignKey(name = "ADDRESS_EMPLOYEE_ID_FK"))
    @ManyToOne (fetch = FetchType.LAZY)
    private Employee employee;

    /*
     * Entity Specific Fields
     */
    @Size(min = 1, max = 255, message = "error.address.category.size")
    @Pattern(regexp = "^[a-zA-Z ,.'-]+$", message = "error.address.category.pattern")
    @Column (name = "CATEGORY")
    private String category;

    @Size(min = 1, max = 255, message = "error.address.addressLine1.size")
    @Pattern(regexp = "^[a-zA-Z0-9 ,.'-]+$", message = "error.address.addressLine1.pattern")
    @Column (name = "ADDRESS_LINE_1")
    private String addressLine1;

    @Size(min = 1, max = 255, message = "error.address.addressLine2.size")
    @Pattern(regexp = "^[a-zA-Z0-9 ,.'-]+$", message = "error.address.addressLine2.pattern")
    @Column (name = "ADDRESS_LINE_2")
    private String addressLine2;

    @Size(min = 1, max = 255, message = "error.address.city.size")
    @Pattern(regexp = "^[a-zA-Z ,.'-]+$", message = "error.address.city.pattern")
    @Column (name = "CITY")
    private String city;

    @Size(min = 1, max = 255, message = "error.address.state.size")
    @Pattern(regexp = "^[a-zA-Z ,.'-]+$", message = "error.address.state.pattern")
    @Column (name = "STATE")
    private String state;

    @Size(min = 1, max = 255, message = "error.address.zipCode.size")
    @Pattern(regexp = "^\\d{5}|\\d{5}-\\d{4}$", message = "error.address.zipCode.pattern")
    @Column (name = "ZIP_CODE")
    private String zipCode;

    @Size(min = 1, max = 255, message = "error.address.country.size")
    @Pattern(regexp = "^[a-zA-Z ,.'-]+$", message = "error.address.country.pattern")
    @Column (name = "COUNTRY")
    private String country;

    /*
     * Getters/Setters
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
