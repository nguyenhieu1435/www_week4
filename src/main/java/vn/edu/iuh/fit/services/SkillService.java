package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.Skill;
import vn.edu.iuh.fit.repositories.SkillRepositoryImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SkillService {

    private SkillRepositoryImpl skillRepository;
    @Autowired
    public SkillService(SkillRepositoryImpl skillRepository) {
        this.skillRepository = skillRepository;
    }
    public boolean save(Skill skill) {
        return skillRepository.save(skill);
    }
    public boolean update(Skill skill) {
        return skillRepository.save(skill);
    }
    public boolean detele(UUID uuid) {
        return skillRepository.detele(uuid);
    }
    public Optional<Skill> getByID(UUID uuid) {
        return skillRepository.getByID(uuid);
    }
    public List<Skill> getAll() {
        return skillRepository.getAll();
    }
}
