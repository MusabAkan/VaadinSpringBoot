package com.musakan.core.repositories.base;

import com.musakan.core.entities.base.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository için kullanılan temel Generic sınıf
 * @param <T>
 */
@Repository
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long>{

}