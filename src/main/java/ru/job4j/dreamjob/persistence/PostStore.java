package ru.job4j.dreamjob.persistence;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob.model.Post;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
@Repository
public class PostStore implements Store<Post> {

    private static final AtomicInteger POST_ID = new AtomicInteger(4);
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    public PostStore() {
        posts.put(1, new Post(1, "Junior Java Job"));
        posts.put(2, new Post(2, "Middle Java Job"));
        posts.put(3, new Post(3, "Senior Java Job"));
    }

    @Override
    public Collection<Post> findAll() {
        return posts.values();
    }

    @Override
    public Post add(Post post) {
        this.savePost(post);
        return post;
    }

    @Override
    public void update(Post post) {
        this.savePost(post);
    }

    @Override
    public Post findById(int id) {
        return posts.get(id);
    }

    private void savePost(Post post) {
        if (post.getId() == 0) {
            post.setId(POST_ID.getAndIncrement());
        }
        posts.put(post.getId(), post);
    }

    @Override
    public Post findByEmailAndPsw(String email, String password) {
        return null;
    }
}
