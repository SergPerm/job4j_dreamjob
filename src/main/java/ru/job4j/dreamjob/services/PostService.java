package ru.job4j.dreamjob.services;

import ru.job4j.dreamjob.model.Post;
import ru.job4j.dreamjob.persistence.PostStore;

import java.util.Collection;

public class PostService {

    private static final PostService INST = new PostService();
    private final PostStore postStore;

    private PostService() {
        this.postStore = PostStore.instOf();
    }

    public static PostService instOf() {
        return INST;
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
