package com.Trambok.controller;

import com.Trambok.Service.UserService;
import com.Trambok.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        User saveUser = userService.saveUser(user);
        if(ObjectUtils.isEmpty(saveUser)){
            return new ResponseEntity<>("User not saved",HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);

    }

    @GetMapping("/getUsers")
    public ResponseEntity<?> getAllUser(){
        List<User> allUsers = userService.getAllUser();
        return new ResponseEntity<>(allUsers,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        User saveUser = userService.updateUser(user);
        if(ObjectUtils.isEmpty(saveUser)){
            return new ResponseEntity<>("User not updated",HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return new ResponseEntity<>("Delete successfully",HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id){
        User userById = userService.getUserbyId(id);
        if(ObjectUtils.isEmpty(userById)){
            return new ResponseEntity<>("User not found",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userById,HttpStatus.OK);
    }

}
