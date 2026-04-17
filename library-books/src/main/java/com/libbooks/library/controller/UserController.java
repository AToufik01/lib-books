package com.libbooks.library.controller;

import com.libbooks.library.model.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
import com.libbooks.library.service.implementation.UserServiceImpl;
import com.libbooks.library.service.interfaceService.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/api")

public class UserController {

    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/user/{userId}")
    public Optional<User> getUserById(@PathVariable Integer userId){
        return this.userService.getUserById(userId);
    }
//    @PreAuthorize("permitAll()")
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return this.userService.getUsers();
    }
    @PostMapping("/user")
    public void addProduct(@RequestBody User user){
        this.userService.addUser(user);
    }
    @PutMapping("/user/{userId}")
    public void updateProduct(@PathVariable Integer userId,@RequestBody User user){
        this.userService.updateUser(userId,user);
    }
    @DeleteMapping("/user/{userId}")
    public void deleteProduct(@PathVariable Integer userId){
        this.userService.deleteUser(userId);
    }



}
