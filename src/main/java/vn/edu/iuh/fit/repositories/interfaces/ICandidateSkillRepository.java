package vn.edu.iuh.fit.repositories.interfaces;

import vn.edu.iuh.fit.models.CandidateSkill;

import java.util.List;
import java.util.UUID;

public interface ICandidateSkillRepository {
    public boolean save(CandidateSkill candidateSkill);
    public boolean update(CandidateSkill candidateSkill);
    public boolean delete(UUID canID, UUID skillID);
    public CandidateSkill getByID(UUID canID, UUID skillID);
    public List<CandidateSkill> getAll();
}
