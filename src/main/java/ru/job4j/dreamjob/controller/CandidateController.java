package ru.job4j.dreamjob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/createCandidate")
    public String createCandidate(@ModelAttribute Candidate candidate) {
        store.createCandidate(candidate);
        return "redirect:/candidates";
    }

    @PostMapping("/updateCandidate")
    public String updateCandidate(@ModelAttribute Candidate candidate) {
        store.updateCandidate(candidate);
        return "redirect:/candidates";
    }

    @GetMapping("/updateCandidate/{candidateId}")
    public String updateCandidate(Model model, @PathVariable("candidateId") int id) {
        model.addAttribute("candidate", store.findCandidateById(id));
        return "updateCandidate";
    }
}
