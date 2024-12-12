package vn.edu.iuh.fit.trananhtien_practicelab5.backend.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.ids.CandidateSkillId;

@Entity
@Table(name = "candidate_skill")
public class CandidateSkill {
    @EmbeddedId
    private CandidateSkillId id;

    @MapsId("canId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "can_id", nullable = false)
    private vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Candidate can;

    @MapsId("skillId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "skill_id", nullable = false)
    private vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Skill skill;

    @Column(name = "more_infos", length = 1000)
    private String moreInfos;

    @Column(name = "skill_level", nullable = false)
    private Byte skillLevel;

    public CandidateSkillId getId() {
        return id;
    }

    public void setId(CandidateSkillId id) {
        this.id = id;
    }

    public vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Candidate getCan() {
        return can;
    }

    public void setCan(vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Candidate can) {
        this.can = can;
    }

    public vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Skill getSkill() {
        return skill;
    }

    public void setSkill(vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Skill skill) {
        this.skill = skill;
    }

    public String getMoreInfos() {
        return moreInfos;
    }

    public void setMoreInfos(String moreInfos) {
        this.moreInfos = moreInfos;
    }

    public Byte getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(Byte skillLevel) {
        this.skillLevel = skillLevel;
    }

}