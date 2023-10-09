package vn.edu.iuh.fit.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.enums.SkillLevel;
import vn.edu.iuh.fit.models.CandidateSkill;
import vn.edu.iuh.fit.repositories.CandidateRepositoryImpl;
import vn.edu.iuh.fit.repositories.SkillRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class CandidateSkillMapper implements RowMapper<CandidateSkill> {
    @Autowired
    private CandidateRepositoryImpl candidateRepository;
    @Autowired
    private SkillRepositoryImpl skillRepository;
    @Override
    public CandidateSkill mapRow(ResultSet rs, int rowNum) throws SQLException {

        CandidateSkill candidateSkill = new CandidateSkill();

        candidateSkill.setCandidate(candidateRepository.getByID(UUID.fromString(rs.getString("can_id"))));
        candidateSkill.setSkill(skillRepository.getByID(UUID.fromString(rs.getString("skill_id"))));
        candidateSkill.setMoreInfos(rs.getString("more_infos"));
        candidateSkill.setSkillLevel(SkillLevel.getSkillLevel(rs.getInt("skill_level")));

        return candidateSkill;
    }
}
