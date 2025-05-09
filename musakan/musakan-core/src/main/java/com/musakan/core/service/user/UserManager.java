package com.musakan.core.service.user;

import com.musakan.core.dataAccess.UserRepository;
import com.musakan.core.dataAccess.base.BaseRepository;
import com.musakan.core.entities.User;
import com.musakan.core.entities.enums.EnumRoleType;
import com.musakan.core.service.base.BaseManager;
import com.musakan.core.utilities.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager extends BaseManager<User> implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected BaseRepository<User> getRepository() {
        return userRepository;
    }

    @Override
    public User createUser(User user) {
        String rawPassword = PasswordHelper.generate(12);
//        String hashedPassword = PasswordHelper.encode(rawPassword);

//        user.setPassword(hashedPassword);
        user.setRole(EnumRoleType.CUSTOMER);

        return userRepository.save(user);
    }

    @Override
    public User login(String email, String password) {
        userRepository.findAll();
        return null;
    }
}
