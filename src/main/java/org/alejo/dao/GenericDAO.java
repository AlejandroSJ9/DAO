package org.alejo.dao;

import java.util.List;

public interface GenericDAO <T,K>{
    List<T> getAll();
    T getById(K id);
    void save(T t);
    void update(T t);
    void delete(T t);

}
