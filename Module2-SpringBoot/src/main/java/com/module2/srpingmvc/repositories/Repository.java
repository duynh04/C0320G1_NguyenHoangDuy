package com.module2.srpingmvc.repositories;

import java.util.List;

public interface Repository<T> {
    void add(T t);
    void update(long id, T T);
    void deleteById(long id);
    T getById(long id);
    List<T> getAll();
}
