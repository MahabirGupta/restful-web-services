package com.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Post {
    @Id // is the primary key
    @GeneratedValue // want Id value to be auto generated
    private Integer id;

    private String description;
//    Post maps to a specific User
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
// generate getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //    generate toString() method
    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
