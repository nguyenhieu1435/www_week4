package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.JobSkill;
import vn.edu.iuh.fit.repositories.JobSkillRepositoryImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JobSkillService {
    private JobSkillRepositoryImpl jobSkillRepository;
    @Autowired
    public JobSkillService(JobSkillRepositoryImpl jobSkillRepository) {
        this.jobSkillRepository = jobSkillRepository;
    }
    public boolean save(JobSkill jobSkill) {
        return jobSkillRepository.save(jobSkill);
    }
    public boolean update(JobSkill jobSkill) {
        return jobSkillRepository.update(jobSkill);
    }
    public boolean delete(UUID jobID, UUID skillID) {
        return jobSkillRepository.delete(jobID, skillID);
    }
    public Optional<JobSkill> getByID(UUID jobID, UUID skillID) {
        return jobSkillRepository.getByID(jobID, skillID);
    }
    public List<JobSkill> getAll() {
        return jobSkillRepository.getAll();
    }
}
