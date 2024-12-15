package vn.edu.iuh.fit.trananhtien_practicelab5.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id", nullable = false)
    private Long id;

    @Column(name = "company", nullable = false, length = 120)
    private String companyName;

    @Column(name = "from_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fromDate;

    @Column(name = "to_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate toDate;

    @Column(name = "role", nullable = false, length = 100)
    private String role;

    @Column(name = "work_desc", nullable = false, length = 400)
    private String workDescription;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "can_id")
    private Candidate candidate;
}
