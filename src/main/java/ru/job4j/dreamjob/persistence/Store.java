package ru.job4j.dreamjob.persistence;

import java.util.Collection;

public interface Store<T> {
    Collection<T> findAll();
    T add(T t);
    void update(T t);
    T findById(int id);
}
