package com.trm.GestOne.configuration.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.trm.GestOne.item.Item;
import com.trm.GestOne.user.Users;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReqRes {

    private int statusCode;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String name;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Set<String> role = new HashSet<>();
    private List<Item> item;
    private Users ourUsers;
}
