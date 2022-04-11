package ru.job4j.dreamjob.services;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dreamjob.model.User;
import ru.job4j.dreamjob.persistence.Store;
import ru.job4j.dreamjob.persistence.UserDbStore;

import java.util.Collection;
import java.util.Optional;

@ThreadSafe
@Service
public class UserService {

    private final Store<User> store;

    public UserService(UserDbStore userDbStore) {
        this.store = userDbStore;
    }


    public Collection<User> findAllUsers() {
        return store.findAll();
    }

    public Optional<User> createUser(User user) {
        return Optional.ofNullable(store.add(user));
    }

    public void updateUser(User user) {
        store.update(user);
    }

    public User findUserById(int id) {
        return store.findById(id);
    }
}
