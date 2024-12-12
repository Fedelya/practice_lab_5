package vn.edu.iuh.fit.trananhtien_practicelab5.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.ids.CandidateSkillId;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.CandidateSkill;

@Repository
public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, CandidateSkillId> {
}
