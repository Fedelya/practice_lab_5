package vn.edu.iuh.fit.trananhtien_practicelab5.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.ids.CandidateSkillId;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.CandidateSkill;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.services.CandidateSkillService;

@Controller
public class CandidateSkillController {
    @Autowired
    private CandidateSkillService candidateSkillService;

}
