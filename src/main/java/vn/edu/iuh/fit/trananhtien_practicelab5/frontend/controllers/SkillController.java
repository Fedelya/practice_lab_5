package vn.edu.iuh.fit.trananhtien_practicelab5.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Skill;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.repositories.SkillRepository;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.services.SkillService;

@Controller
public class SkillController {
    @Autowired
    private SkillService skillService;
    @Autowired
    private SkillRepository skillRepository;



}
