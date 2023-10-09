package vn.edu.iuh.fit.repositories.interfaces;

import vn.edu.iuh.fit.models.Job;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IJobRepositoryImpl {
    public boolean save(Job job);
    public boolean update(Job job);
    public boolean delete(UUID jobID);
    public Optional<Job> getByID(UUID jobID);
    public List<Job> getAll();
}
