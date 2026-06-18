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
            return "redirect:/admin/dashboard";
        }
        model.addAttribute("error", "Invalid Username or Password");
        return "login";
    }
    @GetMapping("/changePassword")
    public String changePasswordPage(HttpSession session)
    {
        if(session.getAttribute("admin") == null)
        {
            return "redirect:/login";
        }
        return "change-password";
    }
    @GetMapping("/forgotPassword")
    public String forgotPasswordPage()
    {
        return "forgot-password";
    }
    @PostMapping("/forgotPassword")
    public String forgotPassword(@RequestParam String username,
                             @RequestParam String newPassword,
                             Model model)
    {
        Admin admin = adminRepository.findByUsername(username);
        if(admin == null)
        {
            model.addAttribute("error", "Username not found");
            return "forgot-password";
        }
        
        admin.setPassword(newPassword);
        adminRepository.save(admin);

        model.addAttribute("success", "Password Reset Successfully");

        return "login";
    }
    @PostMapping("/updatePassword")
    public String updatePassword(@RequestParam String oldPassword,
                             @RequestParam String newPassword,
                             Model model,
                             HttpSession session)
    {
        String username = (String) session.getAttribute("admin");
        
        if(username == null)
        {
            return "redirect:/login";
        }
        Admin admin = adminRepository.findByUsernameAndPassword(username, oldPassword);
        if(admin == null)
        {
            model.addAttribute("error", "Old password is incorrect");
            return "change-password";
        }
        admin.setPassword(newPassword);
        adminRepository.save(admin);
        model.addAttribute("success", "Password changed successfully");
        return "change-password";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/";
    }
}
