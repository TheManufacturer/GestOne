package com.trm.GestOne.user.UserDto;

import com.trm.GestOne.user.role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long userId;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private Set<Role> role = new HashSet<>();}
