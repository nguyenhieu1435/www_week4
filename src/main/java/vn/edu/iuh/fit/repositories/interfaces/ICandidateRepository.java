package vn.edu.iuh.fit.repositories.interfaces;

import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.models.Candidate;

import java.util.List;
import java.util.UUID;

public interface ICandidateRepository {
    public boolean save(Candidate candidate);

    public boolean update(Candidate candidate);
    public boolean detele(UUID uuid);

    public Candidate getByID(UUID uuid);

    public List<Candidate> getAll();
}
