package com.app.auth.service.impl;

import com.app.auth.dto.SaveUser;
import com.app.auth.exception.InvalidPasswordException;
import com.app.auth.persistence.entity.User;
import com.app.auth.persistence.repository.UserRepository;
import com.app.auth.service.UserService;
import com.app.auth.util.Constants;
import com.app.auth.util.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User registerCustomer(SaveUser newUser) {
        validatePassword(newUser);

        User user = User.builder()
                .name(newUser.getName())
                .username(newUser.getUsername())
                .password(passwordEncoder.encode(newUser.getPassword()))
                .role(Role.ROLE_CUSTOMER)
                .build();
        return userRepository.save(user);
    }

    private void validatePassword(SaveUser newUser) {
        if (!StringUtils.hasText(newUser.getPassword()) || !StringUtils.hasText(newUser.getRepeatedPassword())) {
            throw new InvalidPasswordException(Constants.PASSWORDS_DONT_MATCH);
        }

        if (!newUser.getRepeatedPassword().equals(newUser.getPassword())) {
            throw new InvalidPasswordException(Constants.PASSWORDS_DONT_MATCH);
        }
    }
}
