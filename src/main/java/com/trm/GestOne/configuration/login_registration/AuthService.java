package com.trm.GestOne.configuration.login_registration;

import com.trm.GestOne.configuration.dto.ReqRes;
import com.trm.GestOne.configuration.security.jwt.JWTUtils;
import com.trm.GestOne.user.Users;
import com.trm.GestOne.user.UserRepository;
import com.trm.GestOne.user.role.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);


    public ReqRes signUp(ReqRes registrationRequest) {
        logger.info("Signup method called with request: {}", registrationRequest);
        ReqRes resp = new ReqRes();
        try {
            Users users = new Users();
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

            Users usersResult = userRepository.save(users);
            if (usersResult.getUserId() > 0) {
                resp.setOurUsers(usersResult);
                resp.setMessage("User saved successfully");
                resp.setStatusCode(200);
            }
        } catch (Exception e) {
            logger.error("Error in signup method: ", e);
            resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }
    public ReqRes signIn(ReqRes signingRequest) {

        ReqRes response = new ReqRes();

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(signingRequest.getEmail(), signingRequest.getPassword()));
            var user = userRepository.findByEmail(signingRequest.getEmail()).orElseThrow();
            System.out.println("USER IS: " + user);
            var jwt = jwtUtils.generateToken(user);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshToken);
            response.setMessage("successfully Signed in");

        } catch (Exception e) {
            response.setStatusCode(500);
            response.setError(e.getMessage());
        }
        return response;
    }

    public ReqRes refreshToken(ReqRes refreshTokenRequest) {
        ReqRes response = new ReqRes();
        String ourEmail = jwtUtils.extractUserName(refreshTokenRequest.getToken());
        Users users = userRepository.findByEmail(ourEmail).orElseThrow();
        if (jwtUtils.isTokenValid(refreshTokenRequest.getToken(), users)) {
            var jwt = jwtUtils.generateToken(users);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshTokenRequest.getToken());
            response.setMessage("successfully Refreshed Token");
        }
        response.setStatusCode(500);
        return response;
    }

}
