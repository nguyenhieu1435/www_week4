package vn.edu.iuh.fit.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.mappers.CandidateSkillMapper;
import vn.edu.iuh.fit.models.CandidateSkill;
import vn.edu.iuh.fit.repositories.interfaces.ICandidateSkillRepository;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

@Component
public class CandidateSkillRepositoryImpl implements ICandidateSkillRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CandidateSkillRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(CandidateSkill candidateSkill) {
        String sqlQuery = "insert into candidate_skill(can_id, skill_id, more_infos, skill_level) values (?, ?, ?, ?)";
        int result = jdbcTemplate.update(sqlQuery, candidateSkill.getCandidate().getId()
                , candidateSkill.getSkill().getId(), candidateSkill.getMoreInfos(), candidateSkill.getSkillLevel().getLevelNumber());
        return result > 0;
    }

    @Override
    public boolean update(CandidateSkill candidateSkill) {
       String sqlQuery = "update candidate_skill set more_infos = ?, skill_level = ? where can_id = ? and skill_id = ?";
       int result = jdbcTemplate.update(sqlQuery, candidateSkill.getMoreInfos()
               , candidateSkill.getSkillLevel().getLevelNumber()
               , candidateSkill.getCandidate().getId(), candidateSkill.getSkill().getId());
       return result > 0;
    }

    @Override
    public boolean delete(UUID canID, UUID skillID) {
        String sqlQuery = "delete from candidate_skill where can_id = ? and skill_id = ?";
        int result = jdbcTemplate.update(sqlQuery, canID, skillID);
        return result > 0;
    }

    @Override
    public CandidateSkill getByID(UUID canID, UUID skillID) {
        String sqlQuery = "select * from candidate_skill where can_id = ? and skill_id = ?";
        return jdbcTemplate.queryForObject(sqlQuery, new CandidateSkillMapper(), canID, skillID);
    }

    @Override
    public List<CandidateSkill> getAll() {
        String sqlQuery = "select * from candidate_skill";
        return jdbcTemplate.query(sqlQuery, new CandidateSkillMapper());
    }
}
