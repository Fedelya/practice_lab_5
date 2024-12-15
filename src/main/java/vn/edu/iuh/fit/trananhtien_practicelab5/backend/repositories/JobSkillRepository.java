package vn.edu.iuh.fit.trananhtien_practicelab5.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.ids.JobSkillId;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.JobSkill;

import java.util.List;

@Repository
public interface JobSkillRepository extends JpaRepository<JobSkill, JobSkillId> {
    List<JobSkill> findAllByJob_Id(long id);
    List<JobSkill> findByJobIdIn(List<Long> jobIds);
}