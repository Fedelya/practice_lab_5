package vn.edu.iuh.fit.trananhtien_practicelab5.frontend.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Candidate;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Company;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.repositories.CompanyRepository;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.services.CompanyService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies")
    public String showCompanies(HttpSession session, Model model,
                                @RequestParam("page") Optional<Integer> page,
                                @RequestParam("size") Optional<Integer> size) {
        int currPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Company> companyPage = companyService.findAll(currPage - 1, pageSize, "id", "asc");

        Candidate candidate = (Candidate) session.getAttribute("candidate");
        if (candidate != null) {
            model.addAttribute("candidate", candidate);
        } else {
            model.addAttribute("message", "Please login!");
        }

        model.addAttribute("companyPage", companyPage);
        if (companyPage.getTotalPages() > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, companyPage.getTotalPages()).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "companies/companies-paging";
    }


    @RequestMapping("/companies")
    public String showCompaniesPage(HttpSession session, Model model, @RequestParam("page") Optional<Integer> page,
                                    @RequestParam("size") Optional<Integer> size) {
        int currPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Company> companyPage = companyService.findAll(currPage - 1, pageSize, "id", "asc");
        Candidate candidate = (Candidate) session.getAttribute("candidate");

        if (candidate != null) {
            model.addAttribute("candidate", candidate);
        } else {
            model.addAttribute("message", "Please login!");
        }

        model.addAttribute("companyPage", companyPage);
        int totalPage = companyPage.getTotalPages();
        if (totalPage > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "companies/companies-paging";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "/companies/register";  // Tên của view hoặc file HTML của trang đăng ký
    }
}
