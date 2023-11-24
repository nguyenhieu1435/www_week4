package vn.edu.iuh.fit.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.backend.enums.SkillLevel;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.models.CandidateSkill;
import vn.edu.iuh.fit.backend.models.Skill;
import vn.edu.iuh.fit.backend.repositories.CandidateSkillRepositoryImpl;


import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CandidateSkillRepositoryImplTest {
    @Autowired
    private CandidateSkillRepositoryImpl candidateSkillRepository;
    @Test
    void save() {
        boolean actualResult = candidateSkillRepository.save(
                new CandidateSkill(new Candidate(UUID.fromString("351df01d-8bc0-47fa-83a7-b1c8c96506ef")),
                        new Skill(UUID.fromString("0cb4fdfe-4d7f-4bd7-94e0-881c4ddb04f4")), "more infos", SkillLevel.JUNIOR)
        );
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void update() {
        boolean actualResult = candidateSkillRepository.update(
                new CandidateSkill(new Candidate(UUID.fromString("928b88e7-60ac-4c68-bf91-2f7970ed9f0e")),
                        new Skill(UUID.fromString("6969aa0e-b05b-434c-bdfa-1d67e8872310")), "info edit", SkillLevel.JUNIOR)
        );
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void delete() {
        boolean actualResult = candidateSkillRepository.delete(UUID.fromString("351df01d-8bc0-47fa-83a7-b1c8c96506ef")
                , UUID.fromString("0cb4fdfe-4d7f-4bd7-94e0-881c4ddb04f4"));
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getByID() {
        CandidateSkill candidateSkill = candidateSkillRepository.getByID(UUID.fromString("928b88e7-60ac-4c68-bf91-2f7970ed9f0e")
                , UUID.fromString("6969aa0e-b05b-434c-bdfa-1d67e8872310")).orElse(null);
        assertNotNull(candidateSkill);
    }

    @Test
    void getAll() {
        List<CandidateSkill> candidateSkills = candidateSkillRepository.getAll();
        assertNotNull(candidateSkills);
    }
}