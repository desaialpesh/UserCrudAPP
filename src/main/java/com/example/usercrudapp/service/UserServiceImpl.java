package com.example.usercrudapp.service;

import com.example.usercrudapp.dao.UserRepository;
import com.example.usercrudapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> userList() {
        return userRepository.findAll();
    }

    @Override
    public boolean addUpdateUser(User user) {
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean deleteUser(Integer id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }
}
