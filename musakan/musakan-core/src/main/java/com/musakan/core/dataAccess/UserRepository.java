package com.musakan.core.dataAccess;

import com.musakan.core.dataAccess.base.BaseRepository;
import com.musakan.core.entities.City;
import com.musakan.core.entities.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends BaseRepository<User> {
    Optional<User> findByEmail(String email);
}

