package com.haa.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserService implements IUserService {

    private static List<UserModel> users = new ArrayList<>();

    private Integer userCounter = 3;

    static {
        users.add(new UserModel(1, "Eke", new Date()));
        users.add(new UserModel(2, "Meha", new Date()));
        users.add(new UserModel(3, "Kua", new Date()));
    }

    @Override
    public List<UserModel> findUserAll() {
        return users;
    }

    @Override
    public UserModel saveUser(UserModel user) {
        if (user.getId() == null) {
            user.setId(++userCounter);
        }
        users.add(user);

        return user;
    }

    @Override
    public UserModel findUserOne(Integer id) {
        for (UserModel user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public UserModel deleteUser(Integer id) {
        Iterator<UserModel> iterator = users.iterator();
        while (iterator.hasNext()) {
            UserModel user = iterator.next();
            if (user.getId().equals(id)) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }

}
