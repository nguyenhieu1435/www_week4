package vn.edu.iuh.fit.backend.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.backend.enums.SkillLevel;
import vn.edu.iuh.fit.backend.models.CandidateSkill;
import vn.edu.iuh.fit.backend.repositories.CandidateRepositoryImpl;
import vn.edu.iuh.fit.backend.repositories.SkillRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class CandidateSkillMapper implements RowMapper<CandidateSkill> {
    private CandidateRepositoryImpl candidateRepository;
    private SkillRepositoryImpl skillRepository;
    @Autowired
    public CandidateSkillMapper(CandidateRepositoryImpl candidateRepository, SkillRepositoryImpl skillRepository) {
        this.candidateRepository = candidateRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public CandidateSkill mapRow(ResultSet rs, int rowNum) throws SQLException {

        CandidateSkill candidateSkill = new CandidateSkill();

        candidateSkill.setCandidate(candidateRepository.getByID(UUID.fromString(rs.getString("can_id"))).orElse(null));
        candidateSkill.setSkill(skillRepository.getByID(UUID.fromString(rs.getString("skill_id"))).orElse(null));
        candidateSkill.setMoreInfos(rs.getString("more_infos"));
        candidateSkill.setSkillLevel(SkillLevel.getSkillLevel(rs.getInt("skill_level")));

        return candidateSkill;
    }
}
