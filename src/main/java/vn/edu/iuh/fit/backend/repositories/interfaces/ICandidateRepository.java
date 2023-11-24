package vn.edu.iuh.fit.backend.repositories.interfaces;

import vn.edu.iuh.fit.backend.models.Address;
import vn.edu.iuh.fit.backend.models.Candidate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ICandidateRepository {
    public boolean save(Candidate candidate);

    public boolean update(Candidate candidate);
    public boolean detele(UUID uuid);

    public Optional<Candidate> getByID(UUID uuid);

    public List<Candidate> getAll();
}
