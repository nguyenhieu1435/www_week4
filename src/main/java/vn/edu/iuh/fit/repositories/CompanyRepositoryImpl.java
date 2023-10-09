package vn.edu.iuh.fit.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.mappers.CompanyMapper;
import vn.edu.iuh.fit.models.Company;
import vn.edu.iuh.fit.repositories.interfaces.ICompanyRepository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class CompanyRepositoryImpl implements ICompanyRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private CompanyMapper companyMapper;

    @Autowired
    public CompanyRepositoryImpl(DataSource dataSource, CompanyMapper companyMapper) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.companyMapper = companyMapper;
    }
    @Override
    public boolean save(Company company) {
        String sqlQuery = "insert into company(comp_id, about, address, comp_name, email, phone, web_url) values (?, ?, ?, ?, ?, ?, ?)";
        int result = jdbcTemplate.update(sqlQuery, company.getId(), company.getAbout(), company.getAddress().getId()
                , company.getCompName(), company.getEmail(), company.getPhone(), company.getWebUrl());
        return result > 0;
    }

    @Override
    public boolean update(Company company) {
        String sqlQuery = "update company set about = ?, address = ?, comp_name = ?, email = ?, phone = ?, web_url = ? where comp_id = ?";
        int result = jdbcTemplate.update(sqlQuery, company.getAbout(), company.getAddress().getId(), company.getCompName()
              ,company.getEmail()  , company.getPhone(), company.getWebUrl(), company.getId());
        return result > 0;
    }

    @Override
    public boolean delete(UUID compID) {
        String sqlQuery = "delete from company where comp_id = ?";
        int result = jdbcTemplate.update(sqlQuery, compID);
        return result > 0;
    }

    @Override
    public Optional<Company> getByID(UUID compID) {
        String sqlQuery = "select * from company where comp_id = ?";
        Company company = jdbcTemplate.queryForObject(sqlQuery, companyMapper, compID);
        return company != null ? Optional.of(company) : Optional.empty();
    }

    @Override
    public List<Company> getAll() {
        String sqlQuery = "select * from company";
        return jdbcTemplate.query(sqlQuery, companyMapper);
    }
}
