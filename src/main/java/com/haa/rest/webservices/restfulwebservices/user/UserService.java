package com.haa.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserService implements IUserService {

    private static List<User> users = new ArrayList<>();

    private Integer userCounter = 3;

    static {
        users.add(new User(1, "Eke", new Date()));
        users.add(new User(2, "Meha", new Date()));
        users.add(new User(3, "Kua", new Date()));
    }

    @Override
    public List<User> findUserAll() {
        return users;
    }

    @Override
    public User saveUser(User user) {
        if (user.getId() == null) {
            user.setId(++userCounter);
        }
        users.add(user);

        return user;
    }

    @Override
    public User findUserOne(Integer id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

}
