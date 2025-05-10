package com.musakan.core.repositories;

import com.musakan.core.repositories.base.BaseRepository;
import com.musakan.core.entities.User;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User> {
    Optional<User> findByEmail(String email);
}

