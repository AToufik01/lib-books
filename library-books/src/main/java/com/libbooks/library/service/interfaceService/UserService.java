package com.libbooks.library.service.interfaceService;


import com.libbooks.library.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public Optional<User> getUserById(Integer userId);
    public List<User> getUsers();
    public void addUser(User user);
    public void updateUser(Integer userId, User user);
    public void deleteUser(Integer userId);

}
