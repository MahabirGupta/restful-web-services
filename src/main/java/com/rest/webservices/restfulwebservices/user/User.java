package com.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;

public class User {

    private Integer id;
    private String userName;
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
