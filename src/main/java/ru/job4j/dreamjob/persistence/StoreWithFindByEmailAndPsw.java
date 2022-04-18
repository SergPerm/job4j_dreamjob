package ru.job4j.dreamjob.persistence;

import java.util.Optional;

public interface StoreWithFindByEmailAndPsw<T> extends Store<T> {
    Optional<T> findByEmailAndPsw(String email, String password);
}

