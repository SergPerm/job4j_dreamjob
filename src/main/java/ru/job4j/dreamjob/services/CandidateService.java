package ru.job4j.dreamjob.services;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dreamjob.model.Candidate;
import ru.job4j.dreamjob.persistence.CandidateDbStore;
import ru.job4j.dreamjob.persistence.Store;

import java.util.Collection;

@ThreadSafe
@Service
public class CandidateService {

    private final Store<Candidate> store;

    private CandidateService(CandidateDbStore candidateStore) {
        this.store = candidateStore;
    }

    public Collection<Candidate> findAllCandidates() {
        return store.findAll();
    }

    public void createCandidate(Candidate candidate) {
        store.add(candidate);
    }

    public void updateCandidate(Candidate candidate) {
        store.update(candidate);
    }

    public Candidate findCandidateById(int id) {
        return store.findById(id);
    }
}
