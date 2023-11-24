package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.CandidateSkill;
import vn.edu.iuh.fit.backend.repositories.CandidateSkillRepositoryImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CandidateSkillService {
    private CandidateSkillRepositoryImpl candidateSkillRepository;
    @Autowired
    public CandidateSkillService(CandidateSkillRepositoryImpl candidateSkillRepository) {
        this.candidateSkillRepository = candidateSkillRepository;
    }
    public boolean save(CandidateSkill candidateSkill) {
        return candidateSkillRepository.save(candidateSkill);
    }
    public boolean update(CandidateSkill candidateSkill) {
        return candidateSkillRepository.update(candidateSkill);
    }
    public boolean delete(UUID canID, UUID skillID) {
        return candidateSkillRepository.delete(canID, skillID);
    }
    public Optional<CandidateSkill> getByID(UUID canID, UUID skillID) {
        return candidateSkillRepository.getByID(canID, skillID);
    }
    public List<CandidateSkill> getAll() {
        return candidateSkillRepository.getAll();
    }
}
