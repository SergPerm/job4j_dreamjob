package ru.job4j.dreamjob.persistence;

import org.junit.jupiter.api.Test;
import ru.job4j.dreamjob.Main;
import ru.job4j.dreamjob.model.Candidate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNull;

class CandidateDbStoreTest {

    @Test
    public void findAll() {
        CandidateDbStore store = new CandidateDbStore(new Main().loadPool());
        Candidate candidate1 = new Candidate(0, "Serg");
        Candidate candidate2 = new Candidate(0, "Petr");
        Candidate candidate3 = new Candidate(0, "Stas");
        List<Candidate> listBefore = (List<Candidate>) store.findAll();
        store.add(candidate1);
        store.add(candidate2);
        store.add(candidate3);
        List<Candidate> listAfter = (List<Candidate>) store.findAll();
        assertThat((listAfter.size() - listBefore.size()), is(3));
    }

    @Test
    public void whenCreateCandidate() {
        CandidateDbStore store = new CandidateDbStore(new Main().loadPool());
        Candidate candidate = new Candidate(0, "Serg");
        store.add(candidate);
        Candidate candidateInDb = store.findById(candidate.getId());
        assertThat(candidateInDb.getName(), is(candidate.getName()));
    }

    @Test
    public void update() {
        CandidateDbStore store = new CandidateDbStore(new Main().loadPool());
        Candidate candidate = new Candidate(0, "Serg");
        store.add(candidate);
        candidate.setName("Petr");
        store.update(candidate);
        Candidate candidateInDb = store.findById(candidate.getId());
        assertThat(candidateInDb.getName(), is(candidate.getName()));
    }

    @Test
    public void whenIdIsCorrectThenFindById() {
        CandidateDbStore store = new CandidateDbStore(new Main().loadPool());
        Candidate candidate1 = new Candidate(0, "Serg");
        Candidate candidate2 = new Candidate(0, "Petr");
        Candidate candidate3 = new Candidate(0, "Stas");
        store.add(candidate1);
        store.add(candidate2);
        store.add(candidate3);
        Candidate candidateInDb = store.findById(candidate2.getId());
        assertThat(candidateInDb.getName(), is(candidate2.getName()));
    }

    @Test
    public void whenIdIsIncorrectThenFindByIdGetNull() {
        CandidateDbStore store = new CandidateDbStore(new Main().loadPool());
        Candidate candidate1 = new Candidate(0, "Serg");
        Candidate candidate2 = new Candidate(0, "Petr");
        Candidate candidate3 = new Candidate(0, "Stas");
        store.add(candidate1);
        store.add(candidate2);
        store.add(candidate3);
        Candidate candidateInDb = store.findById(500);
        assertNull(candidateInDb);
    }
}