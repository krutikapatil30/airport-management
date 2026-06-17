package com.airport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.airport.model.Admin;
import com.airport.repository.AdminRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController
{
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/login")
    public String loginPage()
    {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                    @RequestParam String password,
                    Model model,
                    HttpSession session)
    {
        Admin admin =adminRepository.findByUsernameAndPassword(username, password);
        if(admin != null)
        {
            session.setAttribute("admin", username);
            return "redirect:/";
        }
        model.addAttribute("error", "Invalid Username or Password");
        return "login";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/login";
    }
}
