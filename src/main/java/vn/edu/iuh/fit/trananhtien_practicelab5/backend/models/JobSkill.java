package vn.edu.iuh.fit.trananhtien_practicelab5.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.ids.JobSkillId;

@Getter
@Setter
@Entity
@Table(name = "job_skill")
public class JobSkill {
    @EmbeddedId
    private JobSkillId id;

    @MapsId("jobId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @MapsId("skillId") // Ensure this matches the field in JobSkillId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill; // Add this line to reference the Skill entity

    @Column(name = "more_infos", length = 1000)
    private String moreInfos;

    @Column(name = "skill_level", nullable = false)
    private Byte skillLevel;
}