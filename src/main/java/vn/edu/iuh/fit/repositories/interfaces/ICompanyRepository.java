package vn.edu.iuh.fit.repositories.interfaces;

import vn.edu.iuh.fit.models.Company;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ICompanyRepository {
    public boolean save(Company company);
    public boolean update(Company company);
    public boolean delete(UUID compID);
    public Optional<Company> getByID(UUID compID);
    public List<Company> getAll();
}
