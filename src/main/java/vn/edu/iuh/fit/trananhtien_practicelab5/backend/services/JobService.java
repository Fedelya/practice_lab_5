package vn.edu.iuh.fit.trananhtien_practicelab5.backend.services;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Job;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.repositories.JobRepository;

import java.util.List;

@Service
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Page<Job> getAll(int pageNo, int pageSize, String sortBy, String sortDirection, long comId){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        List<Job> jobs =  jobRepository.findAllByCompany_Id(comId);
        return new PageImpl<>(jobs, pageable, jobs.size());
    }
}
