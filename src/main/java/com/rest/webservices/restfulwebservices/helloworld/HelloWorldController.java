package com.rest.webservices.restfulwebservices.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

//Expose a REST API
//Mark this controller as a REST Controller using the annotation @RestController
@RestController // can expose the API
public class HelloWorldController {

    private MessageSource messageSource;

//    Using constructor injection
    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    //    give a specific url to the REST API Eg: hello-world
//    return "Hello World" back when someone types the url hello-
//    Expose the url at this specific method using @RequestMapping
//    @RequestMapping(method = RequestMethod.GET,path = "/hello-world") //request a GET method on the hello-world url

    //    Use @GetMapping instead of @RequestMapping
    @GetMapping(path = "/hello-world") // Do not need to specifiy the GET method
    public String returnHelloWorld() {
        return "Hello World Mahabir!";
    }

    @GetMapping(path = "/hello-world-bean") // Return a hello-world-bean back
    public HelloWorldBean returnHelloWorldBean() {
        return new HelloWorldBean("Hello World JSON!");
    }

//    Path Parameters are variable values in the url
//    /users/{id}/todos/{id} => /users/{id of user}/todos/{id of todos list} => /users/1/todos/101
//    the {id} is a variable so it is called a path parameter

    //    build a simple url accepting path parameters
//    /hello-world/path-variable/{name}  {name} is a variable so it must be in braces{}
//    /hello-world/path-variable/Mahabir //when someone send the GET request using @GetMapping  it should capture the value of the variable {name}=Mahabir
    @GetMapping(path = "/hello-world/path-variable/{name}") // hello-world and path-variable are constants and {name} is variables called path parameters
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) { //the variable name must match the name of String variable
//        return new HelloWorldBean("Hello World! " + name);
        return new HelloWorldBean(String.format("Hello World, %s " , name));
    }

    @GetMapping(path = "/hello-world-internationalized") // Do not need to specifiy the GET method
    public String helloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
       return messageSource.getMessage("good.morning.message",null,"Default Message",locale);


//        Someone request for EL
//        - Example: `en` - English (Good Morning!)
//        - Example: `nl` - Dutch (Goedemorgen!)
//        - Example: `fr` - French (Bonjour!)
//        - Example: `de` - Deutsch (Guten Morgen!)
//        1. Define these messages so that it can be selected
//        2. Write the code to pick the values up
    }

}

