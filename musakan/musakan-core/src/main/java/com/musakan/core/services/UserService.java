package com.musakan.core.services;

import com.musakan.core.dtos.UserDto;
import com.musakan.core.entities.User;
import com.musakan.core.services.base.BaseService;

public interface UserService extends BaseService<User> {
    User register(UserDto user);

    User login(UserDto user);
}
