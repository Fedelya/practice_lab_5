package vn.edu.iuh.fit.trananhtien_practicelab5.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.ids.CandidateSkillId;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.CandidateSkill;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.repositories.CandidateSkillRepository;

@Service
public class CandidateSkillService {
    @Autowired
    private CandidateSkillRepository candidateSkillRepository;

    public CandidateSkill getById(CandidateSkillId id) {
        return candidateSkillRepository.findById(id).orElse(null);
    }
}
