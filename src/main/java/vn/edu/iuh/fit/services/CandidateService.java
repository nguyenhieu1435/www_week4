package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.repositories.CandidateRepositoryImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CandidateService {
    private CandidateRepositoryImpl candidateRepository;
    @Autowired
    public CandidateService(CandidateRepositoryImpl candidateRepository) {
        this.candidateRepository = candidateRepository;
    }
    public boolean save(Candidate candidate) {
        return candidateRepository.save(candidate);
    }
    public boolean update(Candidate candidate) {
        return candidateRepository.update(candidate);
    }
    public boolean detele(UUID uuid) {
        return candidateRepository.detele(uuid);
    }
    public Optional<Candidate> getByID(UUID uuid) {
        return candidateRepository.getByID(uuid);
    }
    public List<Candidate> getAll() {
        return candidateRepository.getAll();
    }
}
