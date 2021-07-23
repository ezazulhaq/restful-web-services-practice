package com.haa.rest.webservices.restfulwebservices.user;

import java.util.List;

public interface IUserService {
    public List<UserModel> findUserAll();

    public UserModel saveUser(UserModel user);

    public UserModel findUserOne(Integer id);

    public UserModel deleteUser(Integer id);
}
