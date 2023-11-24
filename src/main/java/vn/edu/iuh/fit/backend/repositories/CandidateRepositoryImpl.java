package vn.edu.iuh.fit.backend.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.backend.mappers.CandidateMapper;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.repositories.interfaces.ICandidateRepository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Component
public class CandidateRepositoryImpl implements ICandidateRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private CandidateMapper candidateMapper;
    @Autowired
    public CandidateRepositoryImpl(DataSource dataSource, CandidateMapper candidateMapper) {
        this.dataSource = dataSource;
        this.candidateMapper = candidateMapper;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(Candidate candidate) {
        String sqlQuery = "insert into candidate(id, address, dob, email, full_name, phone) values(?, ?, ?, ?, ? ,?)";
        int result = jdbcTemplate.update(sqlQuery, candidate.getId(), candidate.getAddress().getId(), candidate.getDob()
                , candidate.getEmail(), candidate.getFullName(), candidate.getPhone());
        return result > 0;
    }

    @Override
    public boolean update(Candidate candidate) {
        String sqlQuery = "update candidate set address = ?, dob = ?, email = ?, full_name = ?, phone = ? where id = ?";
        int result = jdbcTemplate.update(sqlQuery, candidate.getAddress().getId(), candidate.getDob()
                , candidate.getEmail(), candidate.getFullName(), candidate.getPhone(), candidate.getId());
        return result > 0;
    }

    @Override
    public boolean detele(UUID uuid) {
        String sqlQuery = "delete from candidate where id = ?";
        int result = jdbcTemplate.update(sqlQuery, uuid);
        return result > 0;
    }

    @Override
    public Optional<Candidate> getByID(UUID uuid) {
        String sqlQuery = "select * from candidate where id = ?";
        Candidate candidate = jdbcTemplate.queryForObject(sqlQuery, candidateMapper, uuid);
        return candidate != null ? Optional.of(candidate) : Optional.empty();
    }

    @Override
    public List<Candidate> getAll() {
        String sqlQuery = "select * from candidate";
        return jdbcTemplate.query(sqlQuery, candidateMapper);
    }
}
