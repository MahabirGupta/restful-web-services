package com.rest.webservices.restfulwebservices.jpa;

import com.rest.webservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {//It will manage the User Entity and the Id is of type int
}
