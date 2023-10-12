package com.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Instead of using @JsonIgnore on the field can also use @JsonIgnoreProperties for static filtering
//@JsonIgnoreProperties({"field1","field2"}) // it becomes an array

//To use Dynamic filtering
@JsonFilter("SomeBeanFilter")
public class SomeBean {

    private String field1;

//   If field2 is a password and do not want to return a password use  @JsonIgnore
//    @JsonIgnore
    private String field2;
    private String field3;


//  Generate a constructor
    public SomeBean(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

//    Generate getters
    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }

    @Override
    public String toString() {
        return "SomeBean{" +
               "field1='" + field1 + '\'' +
               ", field2='" + field2 + '\'' +
               ", field3='" + field3 + '\'' +
               '}';
    }
}
