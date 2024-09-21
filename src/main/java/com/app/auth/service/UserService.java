package com.app.auth.service;

import com.app.auth.dto.SaveUser;
import com.app.auth.persistence.entity.User;

public interface UserService {
    User registerCustomer(SaveUser newUser);
}
