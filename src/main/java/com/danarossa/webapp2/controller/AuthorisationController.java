package com.danarossa.webapp2.controller;

import com.danarossa.webapp2.data.Role;
import com.danarossa.webapp2.data.User;
import com.danarossa.webapp2.dto.JwtResponse;
import com.danarossa.webapp2.dto.LoginForm;
import com.danarossa.webapp2.dto.ResponseMessage;
import com.danarossa.webapp2.dto.SignUpForm;
import com.danarossa.webapp2.repository.UserRepository;
import com.danarossa.webapp2.security.jwt.JwtProvider;
import com.danarossa.webapp2.security.services.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthorisationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserPrinciple userDetails = (UserPrinciple) authentication.getPrincipal();

        return ResponseEntity.ok(
                new JwtResponse(jwt, userDetails.getUsername(),
                        userDetails.getId(), userDetails.getAuthorities()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getName(), signUpRequest.getSurname());
        switch (signUpRequest.getRole()) {
            case "admin":
                user.setRole(Role.ADMIN);
                break;
            case "trainer":
                user.setRole(Role.TRAINER);
                break;
            default:
                user.setRole(Role.STUDENT);
        }
        userRepository.save(user);
        return ResponseEntity.ok(new ResponseMessage("User registered successfully!"));
}
}