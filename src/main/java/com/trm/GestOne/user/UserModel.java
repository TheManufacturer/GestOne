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
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private Set<Role> role = new HashSet<>();

    //Entity to Model
    public static UserModel mapEntityToModel(User userInfo) {
        return new UserModel(
                userInfo.getUserId(),
                userInfo.getUsername(),
                userInfo.getPassword(),
                userInfo.getEmail(),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getPhoneNumber(),
                userInfo.getAddress(),
                userInfo.getRole()
        );
    }

    //Model to Entity
    public static User mapModelToEntity(UserModel userModel) {
        return new User(
                userModel.getUserId(),
                userModel.getFirstName(),
                userModel.getLastName(),
                userModel.getEmail(),
                userModel.getPassword(),
                userModel.getPhoneNumber(),
                userModel.getAddress(),
                userModel.getRole()
        );
    }

    //Model to Response
    public static UserResponse mapModelToResponse(UserModel userModel) {
        return new UserResponse(
                userModel.getUserId(),
                userModel.getUsername(),
                userModel.getPassword(),
                userModel.getEmail(),
                userModel.getFirstName(),
                userModel.getLastName(),
                userModel.getPhoneNumber(),
                userModel.getAddress(),
                userModel.getRole()
        );
    }

    //Model to Request
    public static UserModel mapRequestToModel(UserRequest userRequest) {
        return new UserModel(
                null,
                userRequest.getUsername(),
                userRequest.getPassword(),
                userRequest.getEmail(),
                userRequest.getFirstName(),
                userRequest.getLastName(),
                userRequest.getPhoneNumber(),
                userRequest.getAddress(),
                userRequest.getRole()
        );
    }

}
