package vn.edu.iuh.fit.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.models.Job;
import vn.edu.iuh.fit.repositories.CompanyRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class JobMapper implements RowMapper<Job> {
    private CompanyRepositoryImpl companyRepository;
    @Autowired
    public JobMapper(CompanyRepositoryImpl companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
        Job job  = new Job();
        job.setId(UUID.fromString(rs.getString("job_id")));
        job.setName(rs.getString("job_name"));
        job.setDescription(rs.getString("job_desc"));
        job.setCompany(companyRepository.getByID(UUID.fromString(rs.getString("company"))).orElse(null));
        return job;
    }
}
