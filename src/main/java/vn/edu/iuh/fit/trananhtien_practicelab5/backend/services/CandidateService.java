package vn.edu.iuh.fit.trananhtien_practicelab5.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Candidate;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.repositories.CandidateRepository;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public Page<Candidate> findAll(int pageNo, int pageSize, String sortBy,
                                   String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return candidateRepository.findAll(pageable);//findFirst.../findTop...
    }
    public Candidate findByEmail(String username) {
        return candidateRepository.findByEmail(username);
    }
}
