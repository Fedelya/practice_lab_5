package vn.edu.iuh.fit.trananhtien_practicelab5.frontend.controllers;

import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Address;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Candidate;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.repositories.AddressRepository;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.services.CandidateService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/list")
    public String showCandidateList(Model model) {
        model.addAttribute("candidates", candidateRepository.findAll());
        return "candidates/candidates";
    }

    @GetMapping("/candidates")
    public String showCandidateListPage(Model model,
                                        @RequestParam("page") Optional<Integer> page,
                                        @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Candidate> candidatePage = candidateService.findAll(
                currentPage - 1, pageSize, "id", "asc");
        model.addAttribute("candidatePage", candidatePage);
        int totalPages = candidatePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "candidates/candidates-paging";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<Candidate> opt = candidateRepository.findById(id);
        if (opt.isPresent()) {
            Candidate candidate = opt.get();
            modelAndView.addObject("candidate", candidate);
            modelAndView.addObject("address", candidate.getAddress());
            modelAndView.addObject("countries", CountryCode.values());
            modelAndView.setViewName("candidates/update-candidates");
        }
        return modelAndView;
    }

    @PostMapping("candidates/update-candidates")
    public String updateCandidate(
            @ModelAttribute("candidate") Candidate candidate,
            @ModelAttribute("address") Address address,
            BindingResult result, Model model
    ) {
        try {
            // Kiểm tra lỗi binding
            if (result.hasErrors()) {
                model.addAttribute("candidate", candidate);
                model.addAttribute("address", address);
                return "candidates/update-candidates";
            }
            addressRepository.save(address);
            candidate.setAddress(address);
            candidateRepository.save(candidate);
            return "redirect:/candidates";
        } catch (EntityNotFoundException e) {
            model.addAttribute("error", e.getMessage());
            return "candidates/update-candidates";
        } catch (Exception e) {
            throw new RuntimeException("Error updating candidate: " + e.getMessage(), e);
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        try{
            candidateRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Error deleting candidate: " + e.getMessage(), e);
        }
        return "redirect:/candidates";
    }
}
