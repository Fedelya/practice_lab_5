package vn.edu.iuh.fit.trananhtien_practicelab5.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.converters.SkillInformation;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Company;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Job;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.JobSkill;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Skill;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.repositories.CompanyRepository;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.repositories.JobRepository;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.repositories.JobSkillRepository;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.repositories.SkillRepository;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.services.JobService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class JobController {
    @Autowired
    private JobService jobService;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private JobSkillRepository jobSkillRepository;
    @Autowired
    private SkillRepository skillRepository;

    @GetMapping("/{companyID}/jobs")
    public String showJobList(Model model,
                              @PathVariable("companyID") long companyID,
                              @RequestParam Optional<Integer> page,
                              @RequestParam Optional<Integer> size) {
        int currPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Job> jobPage = jobService.getJobsByCompanyId(companyID, Pageable.ofSize(pageSize));
        model.addAttribute("jobPage", jobPage);
        Company company = companyRepository.findById(companyID).orElse(null);
        model.addAttribute("company", company);

        // Create a map to hold SkillInformation objects
        Map<Long, List<SkillInformation>> skillsMap = new HashMap<>();
        for (Job job : jobPage.getContent()) {
            List<SkillInformation> skillInfos = job.getJobSkills().stream()
                    .map(jobSkill -> new SkillInformation(
                            jobSkill.getSkill(),
                            jobSkill.getSkillLevel(),
                            jobSkill.getMoreInfo()
                    ))
                    .collect(Collectors.toList());
            skillsMap.put(job.getId(), skillInfos);
        }
        model.addAttribute("skillsMap", skillsMap);
        return "jobs/jobs-paging";
    }

//    @RequestMapping("/jobs/{id}")
//    public String showJobDetail(Model model, @PathVariable("id") long id){
//        Job job = jobRepository.findById(id).orElse(null);
//        List<JobSkill> jobSkills = jobSkillRepository.findAllByJob_Id(id);
//        List<Skill> skills = new ArrayList<>();
//        for (JobSkill jobSkill : jobSkills){
//            Skill skill = skillRepository.findById(jobSkill.getSkill().getId()).orElse(null);
//            skills.add(skill);
//        }
//        model.addAttribute("job", job);
//        model.addAttribute("skills", skills);
//        return "jobs/jobs-detail";
//    }

}
