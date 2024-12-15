package vn.edu.iuh.fit.trananhtien_practicelab5.frontend.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Candidate;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.services.CandidateService;

@Controller
public class LoginController {
    @Autowired
    private CandidateService candidateService;

    @RequestMapping("/login")
    public String login(Model model) {
        String message = "";
        if (model.containsAttribute("message")) {
            message = (String) model.getAttribute("message");
        }
        model.addAttribute("message", message);
        return "companies/login-page";  // Trang login-page.html sẽ được hiển thị
    }

    @RequestMapping("/check")
    public ModelAndView checkLogin(@RequestParam("username") String username,
                                   @RequestParam("password") String password,
                                   HttpSession session) {

        ModelAndView mv = new ModelAndView();

        Candidate candidate = candidateService.findByEmail(username);

        if (candidate != null && candidate.getEmail().equals(username)) {
            if (candidate.getPhone().equals(password)) {
                session.setAttribute("candidate", candidate);
                mv.addObject("candidate", candidate);
                mv.setViewName("redirect:/companies");  // Chuyển hướng đến trang danh sách công việc
            } else {
                mv.addObject("message", "Invalid password");
                mv.setViewName("companies/login-page");  // Nếu sai mật khẩu, quay lại trang login
            }
        } else {
            mv.addObject("message", "Invalid username");
            mv.setViewName("companies/login-page");  // Nếu sai tên đăng nhập, quay lại trang login
        }

        return mv;
    }


    @RequestMapping("/logout")
    public String logout(SessionStatus sessionStatus, HttpSession session, Model model) {
        session.removeAttribute("candidate");  // Remove the candidate from the session
        sessionStatus.setComplete();  // Complete the session
        return "redirect:/login";  // Redirect to the login page
    }
}
