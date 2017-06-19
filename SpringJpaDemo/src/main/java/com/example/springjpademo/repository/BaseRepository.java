package com.example.springjpademo.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Created by Adi Adari on 12/31/2016.
 */
@NoRepositoryBean
public interface BaseRepository<T, PK extends Serializable> extends Repository<T, PK>
{
    void delete(T entity);
    List<T> findAll();
    Optional<T> findOne(PK pk);
    T save(T entity);

}
