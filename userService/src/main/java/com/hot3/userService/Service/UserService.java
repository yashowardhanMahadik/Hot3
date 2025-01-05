package com.hot3.userService.Service;

import com.hot3.userService.DTO.UserDTO;

import java.util.List;

public interface UserService {
    // implement CRUD of user
    public UserDTO createUser(UserDTO userDTO);
    public UserDTO getUserWithEmail(String email);
    public List<UserDTO> getAllUsers();

}
