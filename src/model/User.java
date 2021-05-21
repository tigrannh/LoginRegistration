package model;

import service.MD5;
import service.ValidateInput;

import java.io.IOException;

public class User {
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (ValidateInput.validateName(name)) {
            this.name = name;
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (ValidateInput.validateSurname(surname)) {
            this.surname = surname;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws IOException {
        if (ValidateInput.validateUsername(username)) {
            this.username = username;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (ValidateInput.validateEmail(email)) {
            this.email = email;
        }
    }

    public String getPassword() {
        return MD5.getMD5(password);
    }

    public void setPassword(String password) {
        if (ValidateInput.validatePassword(password)) {
            this.password = password;
        }
    }

    public User(String fullName, String username, String email, String password) {
        String[] data = fullName.split(" ");
        this.name = data[0];
        this.surname = data[1];
        this.username = username;
        this.email = email;
        this.password = password;
    }


}
