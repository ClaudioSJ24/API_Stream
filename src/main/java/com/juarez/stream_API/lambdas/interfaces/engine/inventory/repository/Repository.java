package com.juarez.stream_API.lambdas.interfaces.engine.inventory.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {

    void save(T entity, ID id);

    Optional<T> findById(ID id);

    List<T> findAll();

    void  delete(ID id);
}
