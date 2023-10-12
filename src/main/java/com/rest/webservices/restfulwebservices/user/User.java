package com.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class User {

    private Integer id;
    @Size(min = 2,message = "Name should have at least 2 characters") // minimum size of 2 characters in the name
    @JsonProperty("user_name")//customise the return type of username to user_name
    private String userName;

    @Past(message = "Birth date should be in the past") //the birthdate needs to be in the past
    @JsonProperty("birth_date")//customise the return type of birthdate to birth_date
    private LocalDate birthDate;

    public User(Integer id, String userName, LocalDate birthDate) {
        super();
        this.id = id;
        this.userName = userName;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getbirthDate() {
        return birthDate;
    }

    public void setbirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", userName='" + userName + '\'' +
               ", birthDate=" + birthDate +
               '}';
    }
}
