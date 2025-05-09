package com.musakan.core.service.base;

import com.musakan.core.entities.base.BaseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity> {

    T save(T t);

    Boolean existsById(Long id);

    List<T> saveAll(List<T> entities);

    void delete(Long id);

    void deleteAll(List<T> entities);

    List<T> findAll();

    Optional<T> findById(Long id);

    List<T> findAll(Sort sort);

    List<T> findAll(Pageable pageable);

    List<T> findAllById(List<Long> ids);
}
