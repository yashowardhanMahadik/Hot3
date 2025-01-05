package com.hot3.userService.DTO;

import com.hot3.userService.Model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String id;
    @NotNull
    private String name;
    @NotNull
    @Email
    private String email;
    public static UserDTO getUserDTO(User user){
        if(user!=null){
            // todo : how is the user validated at what stage ?
            return new UserDTO(user.getId(), user.getName(), user.getEmail());
        }
        return null;
    }
}
