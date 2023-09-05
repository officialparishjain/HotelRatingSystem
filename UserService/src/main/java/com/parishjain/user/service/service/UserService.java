package com.parishjain.user.service.service;

import com.parishjain.user.service.model.User;

import java.util.List;

public interface UserService {

    // Create User
    public User saveUser(User user);


    // Get All user
    public List<User> getAllUser();

    // Get User By Id
    public User getUserById(String id);
}
