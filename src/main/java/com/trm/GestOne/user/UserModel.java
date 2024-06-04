package com.trm.GestOne.user;

import com.trm.GestOne.user.UserDto.UserRequest;
import com.trm.GestOne.user.UserDto.UserResponse;
import com.trm.GestOne.user.role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private Long userId;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private Set<Role> role = new HashSet<>();

    //Entity to Model
    public static UserModel mapEntityToModel(Users usersInfo) {
        return new UserModel(
                usersInfo.getUserId(),
                usersInfo.getPassword(),
                usersInfo.getEmail(),
                usersInfo.getFirstName(),
                usersInfo.getLastName(),
                usersInfo.getRole()
        );
    }

    //Model to Entity
    public static Users mapModelToEntity(UserModel userModel) {
        return new Users(
                userModel.getUserId(),
                userModel.getFirstName(),
                userModel.getLastName(),
                userModel.getEmail(),
                userModel.getPassword(),
                userModel.getRole()
        );
    }

    //Model to Response
    public static UserResponse mapModelToResponse(UserModel userModel) {
        return new UserResponse(
                userModel.getUserId(),
                userModel.getPassword(),
                userModel.getEmail(),
                userModel.getFirstName(),
                userModel.getLastName(),
                userModel.getRole()
        );
    }

    //Model to Request
    public static UserModel mapRequestToModel(UserRequest userRequest) {
        return new UserModel(
                null,
                userRequest.getPassword(),
                userRequest.getEmail(),
                userRequest.getFirstName(),
                userRequest.getLastName(),
                userRequest.getRole()
        );
    }

}
