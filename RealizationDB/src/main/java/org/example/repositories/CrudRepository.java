package org.example.repositories;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T,K> {
    List<T> findAll();
    void save(T item);
}
