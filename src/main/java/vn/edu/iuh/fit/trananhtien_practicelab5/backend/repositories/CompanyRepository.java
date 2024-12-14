package vn.edu.iuh.fit.trananhtien_practicelab5.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}