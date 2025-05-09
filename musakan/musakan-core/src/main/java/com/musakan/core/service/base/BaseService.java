package com.musakan.core.service.base;


import com.musakan.core.dataAccess.base.BaseRepository;
import com.musakan.core.entities.base.BaseEntity;

import java.util.List;
import java.util.Optional;


public interface BaseService<T extends BaseEntity> {

    BaseRepository<T> findRepository();

    default T create(T t) {
        return findRepository().save(t);
    }

    default Optional<T> update(T t) {
        if (findRepository().existsById(t.getId())) {
            return Optional.of(findRepository().save(t));
        }
        return Optional.empty();
    }

    default Optional<T> get(Long id) {
        return findRepository().findById(id);
    }

    default List<T> getAll() {
        return findRepository().findAll();
    }

    default void delete(Long id) {
        findRepository().deleteById(id);
    }

}