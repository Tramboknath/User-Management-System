package com.Trambok.Service;

import com.Trambok.model.User;
import com.Trambok.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        User saveUser = userRepository.save(user);
        return saveUser;
    }

    @Override
    public List<User> getAllUser() {
        List<User> allUser = userRepository.findAll();
        return allUser;
    }

    @Override
    public User updateUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        Optional<User> findByIdUser = userRepository.findById(userId);
        if(findByIdUser.isPresent()){
            User user = findByIdUser.get();
            userRepository.delete(user);
        }
    }

    @Override
    public User getUserbyId(Integer userId) {
        Optional<User> userbyId = userRepository.findById(userId);
        if (userbyId.isPresent()){
            return userbyId.get();
        }
        return null;
    }
}
