package ru.job4j.dreamjob.services;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dreamjob.model.Post;
import ru.job4j.dreamjob.persistence.PostDbStore;
import ru.job4j.dreamjob.persistence.Store;

import java.util.Collection;

@ThreadSafe
@Service
public class PostService {

    private final Store<Post> store;

    private PostService(PostDbStore store) {
        this.store = store;
    }

    public Collection<Post> findAllPosts() {
        return store.findAll();
    }

    public void createPost(Post post) {
        store.add(post);
    }

    public void updatePost(Post post) {
        store.update(post);
    }

    public Post findPostById(int id) {
        return store.findById(id);
    }
}
