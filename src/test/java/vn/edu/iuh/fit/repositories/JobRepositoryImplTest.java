package vn.edu.iuh.fit.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.backend.models.Company;
import vn.edu.iuh.fit.backend.models.Job;
import vn.edu.iuh.fit.backend.repositories.JobRepositoryImpl;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class JobRepositoryImplTest {
    @Autowired
    private JobRepositoryImpl jobRepository;
    @Test
    void save() {
        boolean actualResult = jobRepository.save(
                new Job(UUID.randomUUID(), new Company(UUID.fromString("56aa6ed5-947d-4ed9-852f-806870ebf86b")), "desc", "job name")
        );
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);

    }

    @Test
    void update() {
        boolean actualResult = jobRepository.update(
                new Job(UUID.fromString("b7617016-5ec4-40e4-aa75-78da08e11fc0")
                        , new Company(UUID.fromString("a86f885f-1057-48d1-93c5-633e81398f07")), "desc edit", "name dit")
        );
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void delete() {
        boolean actualResult = jobRepository.delete(UUID.fromString("d28c466a-d8c0-4902-989b-f55aed6e06da"));
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getByID() {
        Job job = jobRepository.getByID(UUID.fromString("b7617016-5ec4-40e4-aa75-78da08e11fc0"))
                .orElse(null);
        assertNotNull(job);
    }

    @Test
    void getAll() {
        List<Job> jobs = jobRepository.getAll();
        assertNotNull(jobs);
    }
}