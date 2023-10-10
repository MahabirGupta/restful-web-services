package com.rest.webservices.restfulwebservices.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        User user = service.findOne(id);

        if(user==null){
            throw new UserNotFoundException("id:"+id);
        }
        return user;
    }

//    Create a User
//    POST /users
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){//User entity/class
       User savedUser = service.save(user);

//        Want to return a url /users/4 of the created resource
//        There is a specific HTTP header called Location Header

//        Want to append /4 to /users/4 => /users/{id}, user.getID
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();  //set up the URL of the current request and add the id
        //current request always comes to this URL users/.

//       Return response status 201 — Created
        return ResponseEntity.created(location).build();

    }

    //    GET /specific user request
    @DeleteMapping("/users/{id}") // to get the users from the url
    public void deleteSelectedUser(@PathVariable int id){
        service.deleteById(id);

    }

}
