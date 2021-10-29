package com.psu.ist412.team2.projectplannerwebsite.controller;

import com.psu.ist412.team2.projectplannerwebsite.business.dto.request.form.SignupForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/signup")
public class SignupController {

    @GetMapping
    public String getSignupPage(Model model) {
        model.addAttribute("signupForm", new SignupForm());

        return "signup";
    }

    @PostMapping(value = "/process-signup")
    public String processSignup(SignupForm signupForm, Model model) {
        SignupFormService signupFormService = new SignupFormService(this.customerRepository,
                this.deliveryAddressRepository);
        SignupResponseEnum signupResponseEnum = signupFormService.processNewSignup(signupForm);
        model.addAttribute("signupResponseEnum", signupResponseEnum);
        return "signup-response";
    }

    @ModelAttribute
    public void checkAuth(HttpServletResponse response) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if ((auth != null) && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)) {
            response.sendRedirect("/account");
        }
    }
}

