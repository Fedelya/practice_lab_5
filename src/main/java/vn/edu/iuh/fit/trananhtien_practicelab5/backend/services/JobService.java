package vn.edu.iuh.fit.trananhtien_practicelab5.backend.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Company;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Job;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.JobSkill;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Skill;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.repositories.CompanyRepository;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.repositories.JobRepository;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.repositories.JobSkillRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class JobService {
    private final JobRepository jobRepository;

    @Autowired
    private JobSkillRepository jobSkillRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Page<Job> getJobsByCompanyId(Long companyId, Pageable pageable) {
        return jobRepository.findByCompanyId(companyId, pageable);
    }

    public Map<Long, List<Skill>> getSkillsForJobs(List<Job> jobs) {
        List<Long> jobIds = jobs.stream()
                .map(Job::getId)
                .collect(Collectors.toList());

        List<JobSkill> jobSkills = jobSkillRepository.findByJobIdIn(jobIds);

        return jobSkills.stream()
                .collect(Collectors.groupingBy(
                        jobSkill -> jobSkill.getJob().getId(),
                        Collectors.mapping(JobSkill::getSkill, Collectors.toList())
                ));
    }

    public Page<Job> getAll(int pageNo, int pageSize, String sortBy, String sortDirection, long comId){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        List<Job> jobs =  jobRepository.findAllByCompany_Id(comId);
        return new PageImpl<>(jobs, pageable, jobs.size());
    }
}
