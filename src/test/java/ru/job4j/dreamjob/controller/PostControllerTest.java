package ru.job4j.dreamjob.controller;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.job4j.dreamjob.model.City;
import ru.job4j.dreamjob.model.Post;
import ru.job4j.dreamjob.model.User;
import ru.job4j.dreamjob.services.CityService;
import ru.job4j.dreamjob.services.PostService;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class PostControllerTest {

    @Test
    public void whenPosts() {
        List<Post> posts = Arrays.asList(
                new Post(1, "New post"),
                new Post(2, "New post")
        );
        Model model = mock(Model.class);
        HttpSession session = mock(HttpSession.class);
        PostService postService = mock(PostService.class);
        when(postService.findAllPosts()).thenReturn(posts);
        CityService cityService = mock(CityService.class);
        PostController postController = new PostController(
                postService,
                cityService);
        String page = postController.posts(model, session);
        verify(model).addAttribute("posts", posts);
        assertThat(page, is("posts"));
    }

    @Test
    void addPost() {
        List<City> cities = Arrays.asList(
                new City(1, "prm"),
                new City(2, "ekb")
        );
        User user = new User(1, "serg", "str@ya.ru", "passwor");
        Post post = new Post(0, "Задайте имя");
        Model model = mock(Model.class);
        HttpSession session = mock(HttpSession.class);
        PostService postService = mock(PostService.class);
        CityService cityService = mock(CityService.class);
        when(cityService.getAllCities()).thenReturn(cities);
        when(session.getAttribute("user")).thenReturn(user);
        PostController postController = new PostController(
                postService,
                cityService);
        String page = postController.addPost(model, session);
        verify(model).addAttribute("user", user);
        verify(model).addAttribute("addPost", post);
        verify(model).addAttribute("cities", cities);
        assertThat(page, is("addPost"));
    }

    @Test
    public void whenCreatePost() {
        Post input = new Post(1, "New post");
        City city = new City(1, "Prm");
        int cityId = 1;
        PostService postService = mock(PostService.class);
        CityService cityService = mock(CityService.class);
        when(cityService.findById(1)).thenReturn(city);
        PostController postController = new PostController(
                postService,
                cityService);
        String page = postController.createPost(input, cityId);
        verify(postService).createPost(input);
        assertThat(page, is("redirect:/posts"));
    }

    @Test
    void postMappingUpdatePost() {
        Post post = new Post(1, "New post");
        City city = new City(1, "Prm");
        int cityId = 1;
        PostService postService = mock(PostService.class);
        CityService cityService = mock(CityService.class);
        when(cityService.findById(1)).thenReturn(city);
        PostController postController = new PostController(
                postService,
                cityService);
        String page = postController.updatePost(post, cityId);
        verify(postService).updatePost(post);
        assertThat(page, is("redirect:/posts"));
    }

    @Test
    void getMappingUpdatePost() {
        List<City> cities = Arrays.asList(
                new City(1, "prm"),
                new City(2, "ekb")
        );
        int postId = 1;
        Post post = new Post(1, "Задайте имя");
        Model model = mock(Model.class);
        PostService postService = mock(PostService.class);
        CityService cityService = mock(CityService.class);
        when(cityService.getAllCities()).thenReturn(cities);
        when(postService.findPostById(postId)).thenReturn(post);
        PostController postController = new PostController(
                postService,
                cityService);
        String page = postController.updatePost(model, postId);
        verify(model).addAttribute("post", post);
        verify(model).addAttribute("cities", cities);
        assertThat(page, is("updatePost"));
    }
}