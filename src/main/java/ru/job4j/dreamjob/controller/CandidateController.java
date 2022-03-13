package ru.job4j.dreamjob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.dreamjob.model.Candidate;
import ru.job4j.dreamjob.store.Store;

@Controller
public class CandidateController {
    private final Store store = Store.instOf();

    @GetMapping("/candidates")
    public String candidates(Model model) {
        model.addAttribute("candidates", store.findAllCandidates());
        return "candidates";
    }

    @GetMapping("/addCandidate")
    public String addCandidate(Model model) {
        model.addAttribute("addCandidate", new Candidate(0, "Задайте имя"));
        return "addCandidate";
    }
}
