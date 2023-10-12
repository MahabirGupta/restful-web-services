package com.rest.webservices.restfulwebservices.user;

//Do a static import of all the methods which are present in WebMvcLinkBuilder
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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

//    add a link to http://localhost:8080/users
//    To be able to create a response with data and the links we need to make use of ATS Concepts
//    EntityModel
//    WebMvcLinkBuilder

    //    GET /specific user request
//    Wrap the User class in EntityModel
//    A simple EntityModel wrapping a domain object and adding links to it
    @GetMapping("/users/{id}") // to get the users from the url
    public EntityModel<User> retrieveSelectedUser(@PathVariable int id){
        User user = service.findOne(id);

        if(user==null){
            throw new UserNotFoundException("id:"+id);
        }
        EntityModel<User> entityModel = EntityModel.of(user);
//        Add links to the EntityModel to return links
//        To create links can use another utility class called WebMvcLinkBuilder
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

//    Create a User
//    POST /users
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){//User entity/class
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
