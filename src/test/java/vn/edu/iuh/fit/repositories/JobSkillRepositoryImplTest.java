package vn.edu.iuh.fit.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.enums.SkillLevel;
import vn.edu.iuh.fit.models.Job;
import vn.edu.iuh.fit.models.JobSkill;
import vn.edu.iuh.fit.models.Skill;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class JobSkillRepositoryImplTest {
    @Autowired
    private JobSkillRepositoryImpl jobSkillRepository;
    @Test
    void save() {
        boolean actualResult = jobSkillRepository.save(
            new JobSkill(new Job(UUID.fromString("b7617016-5ec4-40e4-aa75-78da08e11fc0"))
            , new Skill(UUID.fromString("bfb3a760-2e7b-489a-8a7a-3aa928046f96")), "moreInfos", SkillLevel.SENIOR)
        );
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void update() {
        boolean actualResult = jobSkillRepository.update(
            new JobSkill(new Job(UUID.fromString("2f7d779f-bb6b-4b91-a86e-4f6913c57a3a")),
                    new Skill(UUID.fromString("6969aa0e-b05b-434c-bdfa-1d67e8872310")), "moreInfos Edit", SkillLevel.JUNIOR)
        );
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void delete() {
        boolean actualResult = jobSkillRepository.delete(UUID.fromString("b7617016-5ec4-40e4-aa75-78da08e11fc0"), UUID.fromString("bfb3a760-2e7b-489a-8a7a-3aa928046f96"));
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getByID() {
        JobSkill jobSkill = jobSkillRepository.getByID
                (UUID.fromString("2f7d779f-bb6b-4b91-a86e-4f6913c57a3a"), UUID.fromString("6969aa0e-b05b-434c-bdfa-1d67e8872310")).orElse(null);
        assertNotNull(jobSkill);
    }

    @Test
    void getAll() {
        List<JobSkill> jobSkills = jobSkillRepository.getAll();
        assertNotNull(jobSkills);
    }
}