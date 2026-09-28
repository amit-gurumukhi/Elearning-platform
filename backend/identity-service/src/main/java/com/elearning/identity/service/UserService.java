package com.elearning.identity.service;

import com.elearning.identity.dto.UserResponse;
import com.elearning.identity.entity.User;
import com.elearning.identity.exception.EmailAlreadyExistsException;
import com.elearning.identity.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse createUser(String email, String password) {

        if (userRepository.existsByEmail(email)) {
            throw new EmailAlreadyExistsException(
                "Email already registered"
            );
        }
        String passwordHash = passwordEncoder.encode(password);
        User user = new User(email, passwordHash);
        User savedUser = userRepository.save(user);
        return UserResponse.from(savedUser);
    }

}