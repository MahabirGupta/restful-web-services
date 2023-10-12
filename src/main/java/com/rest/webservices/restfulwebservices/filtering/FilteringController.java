package com.rest.webservices.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering") //map to a URL
    public SomeBean filtering(){

        return new SomeBean("value1","value2","value3");
    }

    @GetMapping("/filtering-list") //map to a URL
    public List<SomeBean> filteringList(){

        return Arrays.asList(new SomeBean("value1","value2","value3"),new SomeBean("value4","value5","value6"));
    }
}
