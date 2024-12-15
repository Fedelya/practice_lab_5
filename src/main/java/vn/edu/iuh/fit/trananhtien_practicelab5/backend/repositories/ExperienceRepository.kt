package vn.edu.iuh.fit.trananhtien_practicelab5.backend.repositories

import org.springframework.data.jpa.repository.JpaRepository
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Experience

interface ExperienceRepository : JpaRepository<Experience, Long> {
}