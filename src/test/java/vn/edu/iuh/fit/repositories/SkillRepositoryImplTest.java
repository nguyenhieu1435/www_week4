package vn.edu.iuh.fit.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.backend.enums.SkillType;
import vn.edu.iuh.fit.backend.models.Skill;
import vn.edu.iuh.fit.backend.repositories.SkillRepositoryImpl;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SkillRepositoryImplTest {
    @Autowired
    private SkillRepositoryImpl skillRepository;
    @Test
    void save() {
        boolean actualResult = skillRepository.save(
                new Skill(UUID.randomUUID(), "description text", "skill name"
                        , SkillType.BEGINNER)
        );
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void update() {
       boolean actualResult = skillRepository.update(
               new Skill(UUID.fromString("6969aa0e-b05b-434c-bdfa-1d67e8872310"),
                       "abc descp", "skill text", SkillType.INTERMEDIATE)
       );
       boolean expectedResult = true;
       assertEquals(expectedResult, actualResult);
    }

    @Test
    void detele() {
        boolean actualResult = skillRepository.detele(UUID.fromString("e0cd1386-940d-48f8-b89e-698d3c11b858"));
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getByID() {
        Skill skill = skillRepository.getByID(UUID.fromString("6969aa0e-b05b-434c-bdfa-1d67e8872310")).orElse(null);
        assertNotNull(skill);
    }

    @Test
    void getAll() {
        List<Skill> skillList = skillRepository.getAll();
        assertNotNull(skillList);
    }
}