package vn.edu.iuh.fit.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.models.Company;
import vn.edu.iuh.fit.repositories.AddressRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class CompanyMapper implements RowMapper<Company> {
    private AddressRepositoryImpl addressRepository;
    @Autowired
    public CompanyMapper(AddressRepositoryImpl addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
        Company company = new Company();
        company.setId(UUID.fromString(rs.getString("comp_id")));
        company.setAbout(rs.getString("about"));
        company.setAddress(addressRepository.getByID(UUID.fromString(rs.getString("address"))).orElse(null));
        company.setCompName(rs.getString("comp_name"));
        company.setEmail(rs.getString("email"));
        company.setPhone(rs.getString("phone"));
        company.setWebUrl(rs.getString("web_url"));
        return company;
    }

}
