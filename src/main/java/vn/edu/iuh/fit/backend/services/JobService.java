package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Job;
import vn.edu.iuh.fit.backend.repositories.JobRepositoryImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JobService {
    private JobRepositoryImpl jobRepository;
    @Autowired
    public JobService(JobRepositoryImpl jobRepository) {
        this.jobRepository = jobRepository;
    }
    public boolean save(Job job) {
        return jobRepository.save(job);
    }
    public boolean update(Job job) {
        return jobRepository.update(job);
    }
    public boolean delete(UUID jobID) {
        return jobRepository.delete(jobID);
    }
    public Optional<Job> getByID(UUID jobID) {
        return jobRepository.getByID(jobID);
    }
    public List<Job> getAll() {
        return jobRepository.getAll();
    }
}
