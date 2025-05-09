package com.musakan.core.service.user;

import com.musakan.core.entities.User;
import com.musakan.core.service.base.BaseService;

public interface UserService extends BaseService<User> {
    User createUser(User user);

    User login(String email, String password);
}
