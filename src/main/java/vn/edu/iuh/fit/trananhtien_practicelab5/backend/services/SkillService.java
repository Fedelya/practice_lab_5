package vn.edu.iuh.fit.trananhtien_practicelab5.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Skill;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.repositories.SkillRepository;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    public Skill getById(long id) {
        return skillRepository.findById(id).get();
    }
}
