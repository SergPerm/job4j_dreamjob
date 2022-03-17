package ru.job4j.dreamjob.services;

import org.springframework.stereotype.Service;
import ru.job4j.dreamjob.model.Post;
import ru.job4j.dreamjob.persistence.PostStore;

import java.util.Collection;

@Service
public class PostService {

    private final PostStore postStore;

    private PostService(PostStore postStore) {
        this.postStore = postStore;
    }

    public Collection<Post> findAllPosts() {
        return postStore.findAllPosts();
    }

    public void createPost(Post post) {
        postStore.createPost(post);
    }

    public void updatePost(Post post) {
        postStore.updatePost(post);
    }

    public Post findPostById(int id) {
        return postStore.findPostById(id);
    }
}
