package com.example.usercrudapp.service;

import com.example.usercrudapp.model.User;

import java.util.List;

public interface UserService {

    List<User> userList();

    boolean addUpdateUser(User user);

    boolean deleteUser(Integer id);

    User getUserById(Integer id);
}
