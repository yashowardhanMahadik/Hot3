package com.hot3.userService.Service.ServiceImpl;

import com.hot3.userService.DTO.UserDTO;
import com.hot3.userService.Exception.UserInvalidsException;
import com.hot3.userService.Model.User;
import com.hot3.userService.Repository.UserRepository;
import com.hot3.userService.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    //Create User
    public UserDTO createUser(UserDTO userDTO){
        try {
            User user = new User();
//            user.setId(userDTO.getId());
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            User saved = userRepository.save(user);
            return UserDTO.getUserDTO(saved);
        }
        catch(Exception e){
            //todo : need to see which exception to throw here if DB cause the error
            throw new UserInvalidsException("User Data Invalid or DB exception");
        }
    }

    //Get User with id
    public UserDTO getUserWithEmail(String email){
        User user = userRepository.findByEmail(email);
        if(user!=null){
            return UserDTO.getUserDTO(user);
        }
        return null;
    }
    // Get all users with Pagination
    public List<UserDTO> getAllUsers(){
        List<User> allUsers = userRepository.findAll();
        if(CollectionUtils.isEmpty(allUsers)){
            return null;
        }
        // todo : Add pagination logic after this
        return allUsers.stream().map(UserDTO::getUserDTO).toList();
    }
}
