package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.Company;
import vn.edu.iuh.fit.repositories.CompanyRepositoryImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyService {
    private CompanyRepositoryImpl companyRepository;
    @Autowired
    public CompanyService(CompanyRepositoryImpl companyRepository) {
        this.companyRepository = companyRepository;
    }
    public boolean save(Company company) {
        return companyRepository.save(company);
    }
    public boolean update(Company company) {
        return companyRepository.update(company);
    }
    public boolean delete(UUID compID) {
        return companyRepository.delete(compID);
    }
    public Optional<Company> getByID(UUID compID) {
        return companyRepository.getByID(compID);
    }
    public List<Company> getAll() {
        return companyRepository.getAll();
    }
}
