package com.libbooks.library.service.implementation;

import com.libbooks.library.model.dto.UserDTO;
import com.libbooks.library.model.entity.User;
import com.libbooks.library.repository.UserRepo;
import com.libbooks.library.service.interfaceService.UserService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper){
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO getUserById(Integer userId){
        try {
            User user = this.userRepo.findById(userId).orElseThrow(()-> new RuntimeException("user not found"));
            return this.modelMapper.map(user, UserDTO.class);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public UserDTO addUser(UserDTO userdto ){

        try{
            User user = this.modelMapper.map(userdto,User.class);
            user = this.userRepo.save(user);
            return this.modelMapper.map(user, UserDTO.class);
        }catch (Exception e) {
            throw new RuntimeException("Failed to create user: " + e.getMessage());
        }
    }

    @Override
    public List<UserDTO> getUsers(){
        try{
            return this.userRepo.findAll().stream().map(user -> this.modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch all users: " + e.getMessage());
        }
    }
    @Override
    public UserDTO updateUser(Integer userId, UserDTO user){

        try{
            User userToUpdate = this.userRepo.findById(userId).orElseThrow(()-> new RuntimeException("user not Found"));
            modelMapper.map(user,userToUpdate);
            userToUpdate.setId(userId);
            userToUpdate = this.userRepo.save(userToUpdate);
            return modelMapper.map(userToUpdate,UserDTO.class);

        } catch (Exception e) {
        throw new RuntimeException("Failed to update user with ID " + userId + ": " + e.getMessage());
    }

    }

    @Override
    public void deleteUser(Integer userId){
        try {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new RuntimeException("user not Found"));
        this.userRepo.deleteById(userId);

        } catch (Exception e) {
            throw new RuntimeException("Failed to delete user with ID " + userId);
        }
    }
}
