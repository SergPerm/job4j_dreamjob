package ru.job4j.dreamjob.services;

import ru.job4j.dreamjob.model.Candidate;
import ru.job4j.dreamjob.persistence.CandidateStore;
import ru.job4j.dreamjob.persistence.PostStore;

import java.util.Collection;

public class CandidateService {

    private static CandidateService INST = new CandidateService();
    private final CandidateStore candidateStore;

    private CandidateService() {
        this.candidateStore = CandidateStore.instOf();
    }

    public static CandidateService instOf() {
        return INST;
    }

    public Collection<Candidate> findAllCandidates() {
        return candidateStore.findAllCandidates();
    }

    public void createCandidate(Candidate candidate) {
        candidateStore.createCandidate(candidate);
    }

    public void updateCandidate(Candidate candidate) {
        candidateStore.updateCandidate(candidate);
    }

    public Candidate findCandidateById(int id) {
        return candidateStore.findCandidateById(id);
    }
}
