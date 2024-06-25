package com.rest.webservices.restfulwebservices.user;

//Do a static import of all the methods which are present in WebMvcLinkBuilder

import com.rest.webservices.restfulwebservices.jpa.PostRepository;
import com.rest.webservices.restfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {// Is a REST API
//We want UserJpaResource to talk to a database through UserRepository
    private UserRepository repository;

    //We want UserJpaResource to talk to a database through PostRepository
    private PostRepository postRepository;

//    not using UserDaoService service
//    private UserDaoService service;

//    using constructor injection
    public UserJpaResource(UserRepository repository,PostRepository postRepository) {//UserRepository is wired in

        this.repository = repository;
        this.postRepository = postRepository;
    }

    //    Users REST API
//    Retrieve all Users

//    GET / all users request
    @GetMapping("/jpa/users") // to get the users from the database
    public List<User> retrieveAllUsers(){
        return repository.findAll();
    }

    //    GET /specific user request

//    Wrap the User class in EntityModel
//    A simple EntityModel wrapping a domain object and adding links to it
    @GetMapping("/jpa/users/{id}") // to get the users from the url
    public EntityModel<User> retrieveSelectedUser(@PathVariable int id){
        Optional<User> user = repository.findById(id);

        if(user.isEmpty()){
            throw new UserNotFoundException("id:"+id);
        }
        EntityModel<User> entityModel = EntityModel.of(user.get());
//        Add links to the EntityModel to return links
//        To create links can use another utility class called WebMvcLinkBuilder
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

//    Create a User
//    POST /users
    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){//User entity/class
       User savedUser = repository.save(user);

//        Want to return an url /users/4 of the created resource
//        There is a specific HTTP header called Location Header

//        Want to append /4 to /users/4 => /users/{id}, user.getID
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();  //set up the URL of the current request and add the id
        //current request always comes to this URL users/.

//       Return response status 201 — Created
        return ResponseEntity.created(location).build();

    }

    //    GET /specific user request
    @DeleteMapping("/jpa/users/{id}") // to get the users from the url
    public void deleteSelectedUser(@PathVariable int id){
        repository.deleteById(id);

    }

    @GetMapping("/jpa/users/{id}/posts") // to get the users from the url
    public List<Post> retrievePostsForUser(@PathVariable int id){
        Optional<User> user = repository.findById(id);

        if(user.isEmpty()){
            throw new UserNotFoundException("id:"+id);
        }

      return user.get().getPosts();

    }
    @PostMapping("/jpa/users/{id}/posts") // to get the users from the url
    public ResponseEntity<Object> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post){
        Optional<User> user = repository.findById(id);

        if(user.isEmpty()){
            throw new UserNotFoundException("id:"+id);
        }

        post.setUser(user.get());
        Post savedPost = postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId()).toUri();  //set up the URL of the current request and add the id
        //current request always comes to this URL users/.

//       Return response status 201 — Created
        return ResponseEntity.created(location).build();


    }
}
