package com.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component // I want Spring to manage this so use @Component
public class UserDaoService {
    //JPA/Hibernate -> DataBase to communicate with the database
//    Create a static list and use the UserDaoService > Static List
    private static List<User> users = new ArrayList<>(); //Currently it is an empty List

//    create a counter
    private static int usersCount = 1;

    //    initialise the List<User> with a set of users
    static {
        users.add(new User(usersCount++, "Anish", LocalDate.now().minusYears(30)));
        users.add(new User(usersCount++, "Anishkaa", LocalDate.now().minusYears(25)));
        users.add(new User(usersCount++, "Ashish", LocalDate.now().minusYears(20)));
    }

    //    The services that want to be included to access the database
//    Store all users in the database
//    findAll() user to retrieve all users
    public List<User> findAll() {
        return users;
    }

    //    save User
    public User save(User user){
        user.setId(usersCount++);
        users.add(user);
        return user;
    }
//    findOne() retrieve details of a Specific user
    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }
}
