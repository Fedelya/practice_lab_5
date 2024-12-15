package vn.edu.iuh.fit.trananhtien_practicelab5.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id", nullable = false)
    private Long id;

    @Column(name = "job_desc", nullable = false, length = 2000)
    private String jobDesc;

    @Column(name = "job_name", nullable = false)
    private String jobName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "com_id")
    private Company company;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobSkill> jobSkills = new ArrayList<>();

    @Override
    public String toString() {
        return jobSkills == null ?
                jobDesc + '\'' +
                ", " + jobName + '\'' +
                ", " + company +
                '}' :
                jobDesc + '\'' +
                ", " + jobName + '\'' +
                ", " + company +
                ", " + jobSkills +
                '}';
    }
}