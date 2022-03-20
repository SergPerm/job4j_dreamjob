package ru.job4j.dreamjob.services;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dreamjob.model.Candidate;
import ru.job4j.dreamjob.persistence.CandidateStore;

import java.util.Collection;

@ThreadSafe
@Service
public class CandidateService {

    private final CandidateStore candidateStore;

    private CandidateService(CandidateStore candidateStore) {
        this.candidateStore = candidateStore;
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
