package vn.edu.iuh.fit.repositories.interfaces;

import vn.edu.iuh.fit.models.JobSkill;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IJobSkillRepository {
    public boolean save(JobSkill jobSkill);
    public boolean update(JobSkill jobSkill);
    public boolean delete(UUID jobID, UUID skillID);
    public Optional<JobSkill> getByID(UUID jobID, UUID skillID);
    public List<JobSkill> getAll();
}
