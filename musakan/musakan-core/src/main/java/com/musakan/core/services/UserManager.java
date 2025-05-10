package com.musakan.core.services;

import com.musakan.core.enums.EnumStatusType;
import com.musakan.core.repositories.UserRepository;
import com.musakan.core.repositories.base.BaseRepository;
import com.musakan.core.dtos.UserDto;
import com.musakan.core.entities.Customer;
import com.musakan.core.entities.User;
import com.musakan.core.enums.EnumGenderType;
import com.musakan.core.enums.EnumPhoneType;
import com.musakan.core.enums.EnumRoleType;
import com.musakan.core.services.base.BaseManager;
import com.musakan.core.utilities.BusinessExceptionHelper;
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
                    new BusinessExceptionHelper("Kullanıcı Zaten Mevcuttur.");
                });

        String hashedPassword = PasswordHelper.encode(userDto.getPassword());

        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(hashedPassword);
        user.setRole(EnumRoleType.CUSTOMER);
        user.setStatus(EnumStatusType.ACTIVE);

        Customer customer = new Customer();
        customer.setName(userDto.getFirstName());
        customer.setLastName(userDto.getLastName());
        customer.setPhoneNumber(userDto.getPhoneNumber());
        customer.setPhoneType(EnumPhoneType.GSM);
        customer.setBirthDate(userDto.getBirthDate());
        customer.setGenderType(EnumGenderType.UNKNOWN);
        customer.setStatus(EnumStatusType.ACTIVE);

        user.setCustomer(customer);

        return userRepository.save(user);
    }

    @Override
    public User login(UserDto userDto) {
        User user = userRepository.findByEmail(userDto.getEmail())
                .orElseThrow(() -> new BusinessExceptionHelper("Kullanıcı Mail Adresi Bulunamadı "));

        if (Boolean.FALSE.equals(PasswordHelper.match(userDto.getPassword(), user.getPassword()))) {
            new BusinessExceptionHelper("Kullanıcı adı veya şifre hatalı");
        }

        return user;
    }
}
