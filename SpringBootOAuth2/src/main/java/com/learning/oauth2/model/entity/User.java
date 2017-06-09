package com.learning.oauth2.model.entity;

import javax.persistence.*;

/**
 * Created by mudassir on 20/02/2017.
 */
@Entity
@Table(name = "USER", uniqueConstraints =
@UniqueConstraint(name = "USER_USERNAME_UNQ", columnNames = "USERNAME"))
public class User {
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
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column (name = "IS_ACTIVE")
    private boolean isActive;

    /*
     * Getters/Setters
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
