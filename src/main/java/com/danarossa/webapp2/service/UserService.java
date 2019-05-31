package com.danarossa.webapp2.service;

import com.danarossa.webapp2.data.User;

public interface UserService {
    Iterable<User> all();

    Integer add(User newUser);

    User byId(Integer userId);

    void edit(User userToEdit);

    void delete(Integer userId);
}
