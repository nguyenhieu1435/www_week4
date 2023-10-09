package vn.edu.iuh.fit.mappers;

import org.springframework.jdbc.core.RowMapper;
import vn.edu.iuh.fit.models.Candidate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CandidateMapper implements RowMapper<Candidate> {
    @Override
    public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
        Candidate candidate = new Candidate();
        candidate.setId(UUID.fromString(rs.getString("id")));
        candidate.setDob(rs.getDate("dob").toLocalDate());
        candidate.setEmail(rs.getString("email"));
        candidate.setFullName(rs.getString("full_name"));
        candidate.setPhone(rs.getString("phone"));
        return candidate;
    }
}
