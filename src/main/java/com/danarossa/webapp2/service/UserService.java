package com.danarossa.webapp2.service;

import com.danarossa.webapp2.data.User;

public interface UserService {
    Iterable<User> all();

    Integer add(User newUser);

    User byId(Integer userId);

    String edit(User userToEdit);

    String delete(Integer userId);
}
