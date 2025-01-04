package com.hot3.userService.DTO;

import com.hot3.userService.Exception.UserInvalidException;
import com.hot3.userService.Model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String id;
    private String name;
    private String email;
    public String getEmail(){
        return this.email;
    }

    public static UserDTO getUserDTO(User user){
        if(user!=null){
            // todo : how is the user validated at what stage ?
            return new UserDTO(user.getId(), user.getName(), user.getEmail());
        }
        throw new UserInvalidException("Not a valid user");
    }
}
