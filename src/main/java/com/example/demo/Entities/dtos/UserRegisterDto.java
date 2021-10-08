package com.example.demo.Entities.dtos;

import com.sun.istack.NotNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserRegisterDto {

    @NotNull
    @Size(min = 3,max = 20,message = "Lütfen en az 3 en fazla 20 karakter giriniz.")
    private String userName;
    @Email
    private String email;
    @NotNull
    @Size(min = 4, max = 20,message = "Lütfen en az 4 en fazla 10 karakter giriniz.")
    private String password;

    public UserRegisterDto(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
