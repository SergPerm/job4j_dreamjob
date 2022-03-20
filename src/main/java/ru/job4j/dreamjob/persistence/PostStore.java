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
public class PostStore {

    private static final AtomicInteger POST_ID = new AtomicInteger(4);
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    public PostStore() {
        posts.put(1, new Post(1, "Junior Java Job"));
        posts.put(2, new Post(2, "Middle Java Job"));
        posts.put(3, new Post(3, "Senior Java Job"));
    }

    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    public void createPost(Post post) {
        this.savePost(post);
    }

    public void updatePost(Post post) {
        this.savePost(post);
    }

    public Post findPostById(int id) {
        return posts.get(id);
    }

    private void savePost(Post post) {
        if (post.getId() == 0) {
            post.setId(POST_ID.getAndIncrement());
        }
        posts.put(post.getId(), post);
    }
}
