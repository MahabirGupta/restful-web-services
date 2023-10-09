package com.rest.webservices.restfulwebservices.user;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class UserResource {// Is a REST API

    private UserDaoService service;

//    using constructor injection

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    //    Users REST API
//    Retrieve all Users

//    GET / all users request
    @GetMapping("/users") // to get the users from the url
    public List<User> retrieveAllUsers(){
            return service.findAll();
    }

    //    GET /specific user request
    @GetMapping("/users/{id}") // to get the users from the url
    public User retrieveSelectedUser(@PathVariable int id){
        return service.findOne(id);
    }

//    Create a User
//    POST /users
    @PostMapping("/users")
    public void createUser(@RequestBody User user){//User entity/class
        service.save(user);
    }

}
