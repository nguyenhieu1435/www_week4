package vn.edu.iuh.fit.backend.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.backend.enums.SkillLevel;
import vn.edu.iuh.fit.backend.models.JobSkill;
import vn.edu.iuh.fit.backend.repositories.JobRepositoryImpl;
import vn.edu.iuh.fit.backend.repositories.SkillRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class JobSkillMapper implements RowMapper<JobSkill> {
    private SkillRepositoryImpl skillRepository;
    private JobRepositoryImpl jobRepository;
    @Autowired

    public JobSkillMapper(SkillRepositoryImpl skillRepository, JobRepositoryImpl jobRepository) {
        this.skillRepository = skillRepository;
        this.jobRepository = jobRepository;
    }

    @Override
    public JobSkill mapRow(ResultSet rs, int rowNum) throws SQLException {
        JobSkill jobSkill = new JobSkill();
        jobSkill.setSkill(skillRepository.getByID(UUID.fromString(rs.getString("skill_id"))).orElse(null));
        jobSkill.setJob(jobRepository.getByID(UUID.fromString(rs.getString("job_id"))).orElse(null));
        jobSkill.setMoreInfos(rs.getString("more_infos"));
        jobSkill.setSkillLevel(SkillLevel.getSkillLevel(rs.getInt("skill_level")));
        return jobSkill;
    }
}
