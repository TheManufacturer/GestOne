package com.trm.GestOne.configuration.login_registration;

import com.trm.GestOne.configuration.dto.ReqRes;
import com.trm.GestOne.configuration.security.jwt.JWTUtils;
import com.trm.GestOne.user.User;
import com.trm.GestOne.user.UserRepository;
import com.trm.GestOne.user.role.Role;
import com.trm.GestOne.user.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public ReqRes signUp(ReqRes registrationRequest) {
        ReqRes resp = new ReqRes();
        try {
            User users = new User();
            users.setFirstName(registrationRequest.getFirstName());
            users.setLastName(registrationRequest.getLastName());
            users.setEmail(registrationRequest.getEmail());
            users.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));


            Set<Role> savedRoles = new HashSet<>();
            for (String roleName : registrationRequest.getRole()) {
                Role role = new Role();
                role.setName(Role.RoleType.valueOf(roleName));
                savedRoles.add(roleRepository.save(role));
            }

            users.setRole(savedRoles);

            User usersResult = userRepository.save(users);
            if (usersResult != null && usersResult.getUserId() > 0) {
                resp.setOurUsers(usersResult);
                resp.setMessage("user saved succesfully ");
                resp.setStatusCode(200);
            }
        } catch (Exception e) {
            resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }

    public ReqRes signIn(ReqRes signinRequest) {

        ReqRes response = new ReqRes();

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(signinRequest.getEmail(), signinRequest.getPassword()));
            var user = userRepository.findByEmail(signinRequest.getEmail()).orElseThrow();
            System.out.println("USER IS: " + user);
            var jwt = jwtUtils.generateToken(user);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshToken);
            response.setMessage("succesfully Signed in");

        } catch (Exception e) {
            response.setStatusCode(500);
            response.setError(e.getMessage());
        }
        return response;
    }

    public ReqRes refreshToken(ReqRes refreshTokenRequiest) {
        ReqRes response = new ReqRes();
        String ourEmail = jwtUtils.extractUserName(refreshTokenRequiest.getToken());
        User user = userRepository.findByEmail(ourEmail).orElseThrow();
        if (jwtUtils.isTokenValid(refreshTokenRequiest.getToken(), user)) {
            var jwt = jwtUtils.generateToken(user);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshTokenRequiest.getToken());
            response.setMessage("succesfully Refreshed Token");
        }
        response.setStatusCode(500);
        return response;
    }

}
