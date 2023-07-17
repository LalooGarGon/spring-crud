package com.example.crud.controller;

import com.example.crud.entity.User;
import com.example.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll(){
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public Optional<User> getOneById(@PathVariable("userId") Long userId){
        return userService.getUser(userId);
    }

    @PostMapping
    public void saveOrUpdate(@RequestBody User user){
        userService.saveOrUpdate(user);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }
}
