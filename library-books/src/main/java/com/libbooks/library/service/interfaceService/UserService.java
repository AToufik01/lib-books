package com.libbooks.library.service.interfaceService;


import com.libbooks.library.model.dto.UserDTO;
import com.libbooks.library.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDTO getUserById(Integer userId);
    List<UserDTO> getUsers();
    UserDTO addUser(UserDTO userdto);
    UserDTO updateUser(Integer userId, UserDTO userdto);
    void deleteUser(Integer userId);

}
