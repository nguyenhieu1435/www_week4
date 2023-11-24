package vn.edu.iuh.fit.backend.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.backend.mappers.JobSkillMapper;
import vn.edu.iuh.fit.backend.models.JobSkill;
import vn.edu.iuh.fit.backend.repositories.interfaces.IJobSkillRepository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class JobSkillRepositoryImpl implements IJobSkillRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private JobSkillMapper jobSkillMapper;
    @Autowired
    public JobSkillRepositoryImpl(DataSource dataSource, JobSkillMapper jobSkillMapper) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jobSkillMapper = jobSkillMapper;
    }

    @Override
    public boolean save(JobSkill jobSkill) {
        String sqlQuery = "insert into job_skill(job_id, skill_id, more_infos, skill_level) values (?, ?, ?, ?)";
        int result = jdbcTemplate.update(sqlQuery, jobSkill.getJob().getId(), jobSkill.getSkill().getId()
                , jobSkill.getMoreInfos(), jobSkill.getSkillLevel().getLevelNumber());
        return result > 0;
    }

    @Override
    public boolean update(JobSkill jobSkill) {
        String sqlQuery = "update job_skill set more_infos = ?, skill_level = ? where job_id = ? and skill_id = ?";
        int result = jdbcTemplate.update(sqlQuery, jobSkill.getMoreInfos()
                , jobSkill.getSkillLevel().getLevelNumber(), jobSkill.getJob().getId(), jobSkill.getSkill().getId());
        return result > 0;
    }

    @Override
    public boolean delete(UUID jobID, UUID skillID) {
        String sqlQuery = "delete from job_skill where job_id = ? and skill_id = ?";
        int result = jdbcTemplate.update(sqlQuery, jobID, skillID);
        return result > 0;
    }

    @Override
    public Optional<JobSkill> getByID(UUID jobID, UUID skillID) {
        String sqlQuery = "select * from job_skill where job_id = ? and skill_id = ?";
        JobSkill jobSkill =  jdbcTemplate.queryForObject(sqlQuery, jobSkillMapper, jobID, skillID);
        return jobSkill != null ? Optional.of(jobSkill) : Optional.empty();
    }

    @Override
    public List<JobSkill> getAll() {
        String sqlQuery = "select * from job_skill";
        return jdbcTemplate.query(sqlQuery, jobSkillMapper);
    }
}
