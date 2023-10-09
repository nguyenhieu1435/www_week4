package vn.edu.iuh.fit.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.repositories.AddressRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class CandidateMapper implements RowMapper<Candidate> {

    private AddressRepositoryImpl addressRepository;
    @Autowired
    public CandidateMapper(AddressRepositoryImpl addressRepository){
        this.addressRepository = addressRepository;
    }
    @Override
    public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
        Candidate candidate = new Candidate();
        candidate.setId(UUID.fromString(rs.getString("id")));
        candidate.setDob(rs.getDate("dob").toLocalDate());
        candidate.setEmail(rs.getString("email"));
        candidate.setFullName(rs.getString("full_name"));
        candidate.setPhone(rs.getString("phone"));
        candidate.setAddress(addressRepository.getByID(UUID.fromString(rs.getString("address"))).orElse(null));

        return candidate;
    }
}
