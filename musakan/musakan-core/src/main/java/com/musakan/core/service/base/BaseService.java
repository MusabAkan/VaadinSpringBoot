package com.musakan.core.service.base;

import com.musakan.core.dataAccess.base.BaseRepository;
import com.musakan.core.entities.base.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;


public interface BaseService<T extends BaseEntity> {

    BaseRepository<T> findRepository();

    default T save(T t) {
        return findRepository().save(t);
    }

    default Boolean existsById(Long id){
        return findRepository().existsById(id);
    }

    default List<T> saveAll(List<T> entitties) {
        return findRepository().saveAll(entitties);
    }

    default void delete(Long id) {
        findRepository().deleteById(id);
    }

    default void deleteAll(List<T> entities) {
        findRepository().deleteAll(entities);
    }

    default List<T> findAll() {
        return findRepository().findAll();
    }

    default Optional<T> findById(Long id) {
        return findRepository().findById(id);
    }

    default List<T> findAll(Sort sort) {
        return findRepository().findAll(sort);
    }

    default List<T> findAll(Pageable pageable) {
        Page<T> all = findRepository().findAll(pageable);
        return all != null ? all.getContent() : null;
    }

    default List<T> findAllById(List<Long> ids) {
        return findRepository().findAllById(ids);
    }
}