package vn.edu.iuh.fit.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.backend.models.Address;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.repositories.CandidateRepositoryImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CandidateRepositoryImplTest {
    @Autowired
    private CandidateRepositoryImpl candidateRepository;
    @Test
    void save() {
        boolean actualResult = candidateRepository.save(
                new Candidate(UUID.randomUUID(), "Nguyen Van Aa", "hieuab3c@gmail.com2"
                        , "0123169999", new Address(UUID.fromString("9a97337e-980a-4699-b649-22d91e871fcb"))
                        , LocalDate.now()));
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void update() {
         boolean actualResult = candidateRepository.update(
                 new Candidate(UUID.fromString("928b88e7-60ac-4c68-bf91-2f7970ed9f0e"), "Hieu Nguyen", "hieuabc@gmail.com2"
                         , "0123199111", new Address(UUID.fromString("f1fd5b76-0491-476e-ac85-1a613d25b24e"))
                         , LocalDate.now()));
         boolean expectedResult = true;
         assertEquals(expectedResult, actualResult);
    }

    @Test
    void detele() {
        boolean actualResult = candidateRepository.detele(
                UUID.fromString("cda23ba6-4d60-4320-9263-a7b1e2b14c1e")
        );
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getByID() {
        Candidate candidate = candidateRepository.getByID(UUID.fromString("928b88e7-60ac-4c68-bf91-2f7970ed9f0e")).orElse(null);
        System.out.println(candidate);
        assertNotNull(candidate);
    }

    @Test
    void getAll() {
        List<Candidate> candidateList = candidateRepository.getAll();
        System.out.println(candidateList);
        assertNotNull(candidateList);
    }
}