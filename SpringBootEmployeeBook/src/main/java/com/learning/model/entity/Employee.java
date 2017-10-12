package com.learning.model.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * Created by mudassir on 04/01/2017.
 */
@Entity
@Table (name = "EMPLOYEE", uniqueConstraints =
    @UniqueConstraint(name = "EMPLOYEE_EMAIL_UNQ", columnNames = "EMAIL"))
@NamedQueries({
        @NamedQuery(name = "Employee.find",
                query = "Select e from Employee e JOIN FETCH e.department d"),
        @NamedQuery(name = "Employee.findById",
            query = "Select e from Employee e JOIN FETCH e.department d WHERE e.id = :id"),
        @NamedQuery(name = "Employee.findByIdWithDetails",
                query = "SELECT e FROM Employee e JOIN FETCH e.department d JOIN FETCH e.addressList a WHERE e.id = :id ")
})
@EntityListeners(AuditingEntityListener.class)
public class Employee extends Audit{
    /*
     * Key Fields
     */
    @Id
    @GeneratedValue
    @Column (name = "ID", unique = true, updatable = false)
    private Long id;

    @NotNull(message = "error.employee.departmentId.notnull")
    @JoinColumn (name = "DEPARTMENT_ID", foreignKey = @ForeignKey(name = "EMPLOYEE_DEPARTMENT_ID_FK"))
    @OneToOne (fetch = FetchType.LAZY)
    private Department department;

    /*
     * Entity Specific Fields
     */
    @Size(min = 1, max = 255, message = "error.employee.firstName.size")
    @Pattern(regexp = "^[a-zA-Z ,.'-]+$", message = "error.employee.firstName.pattern")
    @Column (name = "FIRST_NAME")
    private String firstName;

    @Size(min = 1, max = 255, message = "error.employee.lastName.size")
    @Pattern(regexp = "^[a-zA-Z ,.'-]+$", message = "error.employee.lastName.pattern")
    @Column (name = "LAST_NAME")
    private String lastName;

    @NotNull(message = "error.employee.email.notnull")
    @Size(min = 1, max = 255, message = "error.employee.email.size")
    @Pattern(regexp = "[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})",
            message = "error.employee.email.pattern")
    @Column (name = "EMAIL", unique = true)
    private String email;

    @Size(min = 2, max = 25, message = "error.employee.salary.size")
    @Pattern(regexp = "^\\d{2,10}$", message = "error.employee.salary.pattern")
    @Column (name = "SALARY")
    private String salary;

    @NotNull(message = "error.employee.isActive.notnull")
    @Column (name = "IS_ACTIVE")
    private boolean isActive;

    /*
     * Mapped Fields
     */
    @OneToMany (mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Address> addressList;

    public Employee() {}

    /*
         * Getters/Setters
         */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedById() {
        return lastModifiedById;
    }

    public void setLastModifiedById(String lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
