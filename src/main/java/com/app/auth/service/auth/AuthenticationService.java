package com.app.auth.service.auth;

import com.app.auth.dto.RegisterUser;
import com.app.auth.dto.SaveUser;
import com.app.auth.persistence.entity.User;
import com.app.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService {


    private final UserService userService;
    private final JwtService jwtService;

    public RegisterUser registerCustomer(SaveUser newUser) {
        User user = userService.registerCustomer(newUser);

        RegisterUser userDto = new RegisterUser();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setName(user.getName());
        userDto.setRole(user.getRole().toString());

        String jwt = jwtService.generateToken(user, generateExtraClaims(user));
        userDto.setJwt(jwt);

        return userDto;
    }

    private Map<String, Object> generateExtraClaims(User user) {
        return Map.of(
                "name", user.getName(),
                "role", user.getRole().name(),
                "authorities", user.getAuthorities()
        );
    }
}
