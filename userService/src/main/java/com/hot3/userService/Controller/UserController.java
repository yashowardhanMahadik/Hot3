package com.hot3.userService.Controller;

import com.hot3.userService.DTO.UserDTO;
import com.hot3.userService.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    //add users
    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO){
        return ResponseEntity.ok().body(userService.createUser(userDTO));
    }

    //Get user
    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> getUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }
}
