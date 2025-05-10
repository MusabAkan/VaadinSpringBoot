package com.musakan.core.services.base;


import com.musakan.core.repositories.base.BaseRepository;
import com.musakan.core.entities.base.BaseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class BaseManager<T extends BaseEntity> implements BaseService<T> {

    protected abstract BaseRepository<T> getRepository();

    @Override
    public T save(T t) {
        return getRepository().save(t);
    }

    @Override
    public Boolean existsById(Long id) {
        return getRepository().existsById(id);
    }

    @Override
    public List<T> saveAll(List<T> entities) {
        return getRepository().saveAll(entities);
    }

    @Override
    public void delete(Long id) {
        getRepository().deleteById(id);
    }

    @Override
    public void deleteAll(List<T> entities) {
        getRepository().deleteAll(entities);
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public Optional<T> findById(Long id) {
        return getRepository().findById(id);
    }

    @Override
    public List<T> findAll(Sort sort) {
        return getRepository().findAll(sort);
    }

    @Override
    public List<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable).getContent();
    }

    @Override
    public List<T> findAllById(List<Long> ids) {
        return getRepository().findAllById(ids);
    }
}
