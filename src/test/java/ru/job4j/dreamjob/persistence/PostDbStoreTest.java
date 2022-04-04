package ru.job4j.dreamjob.persistence;

import org.junit.jupiter.api.Test;
import ru.job4j.dreamjob.Main;
import ru.job4j.dreamjob.model.Post;

import java.util.List;

import static org.junit.Assert.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class PostDbStoreTest {

    @Test
    public void findAll() {
        PostDbStore store = new PostDbStore(new Main().loadPool());
        Post post1 = new Post(0, "JavaRush");
        Post post2 = new Post(0, "Jo4j");
        Post post3 = new Post(0, "SberBank");
        List<Post> listBefore = (List<Post>)store.findAll();
        store.add(post1);
        store.add(post2);
        store.add(post3);
        List<Post> listAfter = (List<Post>)store.findAll();
        assertThat((listAfter.size() - listBefore.size()), is(3));
    }

    @Test
    public void whenCreatePost() {
        PostDbStore store = new PostDbStore(new Main().loadPool());
        Post post = new Post(0, "Java Job");
        store.add(post);
        Post postInDb = store.findById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }

    @Test
    public void whenUpdatePost() {
        PostDbStore store = new PostDbStore(new Main().loadPool());
        Post post = new Post(0, "Java Job");
        store.add(post);
        post.setName("Job4j");
        store.update(post);
        Post postInDb = store.findById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }

    @Test
    public void whenIdIsCorrectThenFindByIdIsSuccessful() {
        PostDbStore store = new PostDbStore(new Main().loadPool());
        Post post1 = new Post(0, "JavaRush");
        Post post2 = new Post(0, "Jo4j");
        Post post3 = new Post(0, "SberBank");
        store.add(post1);
        store.add(post2);
        store.add(post3);
        Post postInDb = store.findById(post2.getId());
        assertThat(postInDb.getName(), is(post2.getName()));
    }

    @Test
    public void whenIdIsIncorrectThenFindByIdGetNull() {
        PostDbStore store = new PostDbStore(new Main().loadPool());
        Post post1 = new Post(0, "JavaRush");
        Post post2 = new Post(0, "Jo4j");
        Post post3 = new Post(0, "SberBank");
        store.add(post1);
        store.add(post2);
        store.add(post3);
        Post postInDb = store.findById(500);
        assertNull(postInDb);
    }
}