package com.libbooks.library.controller;

import com.libbooks.library.model.dto.UserDTO;
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
    public UserDTO getUserById(@PathVariable Integer userId){
        return this.userService.getUserById(userId);
    }
//    @PreAuthorize("permitAll()")
    @GetMapping("/users")
    public List<UserDTO> getAllUsers(){
        return this.userService.getUsers();
    }
    @PostMapping("/user")
    public void addUser(@RequestBody UserDTO user){
        UserDTO UserDTO = this.userService.addUser(user);
    }
    @PutMapping("/user/{userId}")
    public void updateUser(@PathVariable Integer userId,@RequestBody UserDTO user){
        UserDTO userDTO = this.userService.updateUser(userId,user);
    }
    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable Integer userId){
        this.userService.deleteUser(userId);
    }



}
