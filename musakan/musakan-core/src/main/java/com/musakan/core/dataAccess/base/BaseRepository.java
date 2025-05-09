package com.musakan.core.dataAccess.base;

import com.musakan.core.entities.base.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long>{

}