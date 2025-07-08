package com.Trambok.Service;

import com.Trambok.model.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);

    public List<User> getAllUser();

    public User updateUser(User user);

    public void deleteUser(Integer userId);

    public User getUserbyId(Integer userId);
}
