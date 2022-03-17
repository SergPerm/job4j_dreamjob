package ru.job4j.dreamjob.persistence;

import ru.job4j.dreamjob.model.Candidate;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CandidateStore {

    private static final CandidateStore INST = new CandidateStore();
    private static final AtomicInteger CANDIDATE_ID = new AtomicInteger(4);

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private CandidateStore() {
        candidates.put(1, new Candidate(1, "Junior Java"));
        candidates.put(2, new Candidate(2, "Middle Java"));
        candidates.put(3, new Candidate(3, "Senior Java"));
    }

    public static CandidateStore instOf() {
        return INST;
    }

    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }

    public void createCandidate(Candidate candidate) {
        this.saveCandidate(candidate);
    }

    public void updateCandidate(Candidate candidate) {
        this.saveCandidate(candidate);
    }

    public Candidate findCandidateById(int id) {
        return candidates.get(id);
    }

    private void saveCandidate(Candidate candidate) {
        if (candidate.getId() == 0) {
            candidate.setId(CANDIDATE_ID.getAndIncrement());
        }
        candidates.put(candidate.getId(), candidate);
    }
}
