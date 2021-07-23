package com.haa.rest.webservices.restfulwebservices.user;

import java.util.List;

public interface IUserService {
    public List<User> findUserAll();

    public User saveUser(User user);

    public User findUserOne(Integer id);

    public User deleteUser(Integer id);
}
