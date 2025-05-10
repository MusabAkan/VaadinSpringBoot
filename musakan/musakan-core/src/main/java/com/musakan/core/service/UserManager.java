package com.musakan.core.service;

import com.musakan.core.dataAccess.UserRepository;
import com.musakan.core.dataAccess.base.BaseRepository;
import com.musakan.core.dtos.UserDto;
import com.musakan.core.entities.Customer;
import com.musakan.core.entities.User;
import com.musakan.core.enums.EnumGenderType;
import com.musakan.core.enums.EnumPhoneType;
import com.musakan.core.enums.EnumRoleType;
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
    public User register(UserDto userDto) {
        userRepository.findByEmail(userDto.getEmail())
                .ifPresent(existingUser -> {
                    throw new RuntimeException("Kullanıcı Zaten Mevcuttur.");
                });

        String hashedPassword = PasswordHelper.encode(userDto.getPassword());

        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(hashedPassword);
        user.setRole(EnumRoleType.CUSTOMER);

        Customer customer = new Customer();
        customer.setName(userDto.getFirstName());
        customer.setLastName(userDto.getLastName());
        customer.setPhoneNumber(userDto.getPhoneNumber());
        customer.setPhoneType(EnumPhoneType.GSM);
        customer.setBirthDate(userDto.getBirthDate());
        customer.setGenderType(EnumGenderType.UNKNOWN);

        user.setCustomer(customer);

        return userRepository.save(user);
    }

    @Override
    public User login(UserDto userDto) {
        User user = userRepository.findByEmail(userDto.getEmail())
                .orElseThrow(() -> new RuntimeException("Kullanıcı Mail Adresi Bulunamadı "));

        if (PasswordHelper.match(userDto.getPassword(), user.getPassword())) {
            return user;
        } else {
            throw new RuntimeException("Kullanıcı adı veya şifre hatalı");
        }
    }
}
