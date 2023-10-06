package com.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Expose a REST API
//Mark this controller as a REST Controller using the annotation @RestController
@RestController // can expose the API
public class HelloWorldController {

//    give a specific url to the REST API Eg: hello-world
//    return "Hello World" back when someone types the url hello-
//    Expose the url at this specific method using @RequestMapping
//    @RequestMapping(method = RequestMethod.GET,path = "/hello-world") //request a GET method on the hello-world url

//    Use @GetMapping instead of @RequestMapping
    @GetMapping(path = "/hello-world") // Do not need to specifiy the GET method
    public String returnHelloWorld(){
        return "Hello World!";
    }
}

