package com.danarossa.webapp2.dto;

import com.danarossa.webapp2.data.Role;
import lombok.Data;

import java.util.Date;

@Data
public class Account {
    private String name;
    private String surname;
    private String email;
    private Role role;
    private String password;

    public Account(String name, String surname, String email, Date dateEntered, Role role, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public Account(String name, String surname, String email, Role role, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.role = role;
        this.password = password;
    }

}
