package ru.job4j.dreamjob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.dreamjob.model.Post;
import ru.job4j.dreamjob.store.Store;

@Controller
public class PostController {

    private final Store store = Store.instOf();

    @GetMapping("/posts")
    public String posts(Model model) {
        model.addAttribute("posts", store.findAllPosts());
        return "posts";
    }

    @GetMapping("/addPost")
    public String addPost(Model model) {
        model.addAttribute("addPost", new Post(0, "Задайте имя"));
        return "addPost";
    }

}
