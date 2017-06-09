package com.learning.oauth2.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * Created by mudassir on 04/01/2017.
 */
@Entity
@Table (name = "DEPARTMENT", uniqueConstraints =
    @UniqueConstraint(name = "DEPARTMENT_NAME_UNQ", columnNames = "NAME"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EntityListeners(AuditingEntityListener.class)
public class Department extends Audit{
    /*
     * Key Fields
     */
    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, updatable = false)
    private Long id;

    /*
     * Entity Specific Fields
     */
    @Size(min = 1, max = 255, message = "error.department.name.size")
    @Pattern(regexp = "^[a-zA-Z ,.'-]+$", message = "error.department.name.pattern")
    @Column (name = "NAME")
    private String name;

    /*
     * Mapped Fields
     */
    @OneToMany (mappedBy = "department", fetch = FetchType.LAZY)
    private List<Employee> employeeList;

    public Department() {}

    /*
     * Getters/Setters
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
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
