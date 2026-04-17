package com.libbooks.library.service.implementation;

import com.libbooks.library.model.entity.User;
import com.libbooks.library.repository.UserRepo;
import com.libbooks.library.service.interfaceService.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public Optional<User> getUserById(Integer userId){
        return this.userRepo.findById(userId);
    }
    @Override
    public void addUser(User user){
        this.userRepo.save(user);
    }

    @Override
    public List<User> getUsers(){
        return  this.userRepo.findAll();
    }
    @Override
    public void updateUser(Integer userId, User user){
        User userToUpdate = this.userRepo.findById(userId).orElseThrow(()-> new RuntimeException("user not Found"));

        userToUpdate.setFirstname(user.getFirstname());
        userToUpdate.setLastname(user.getLastname());
        userToUpdate.setDateOfBirth(user.getDateOfBirth());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setEnabled(user.isEnabled());
        userToUpdate.setAccountLocked(user.isAccountLocked());
        this.userRepo.save(userToUpdate);

    }

    @Override
    public void deleteUser(Integer userId){
        this.userRepo.deleteById(userId);
    }
}
