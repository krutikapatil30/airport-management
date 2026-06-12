package com.airport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.airport.model.Passenger;
import com.airport.repository.PassengerRepository;

@Controller
public class PassengerController 
{

    @Autowired
    private PassengerRepository passengerRepository;

    @GetMapping("/passengers")
    public String viewPassengers(Model model) 
    {
        model.addAttribute("passengers", passengerRepository.findAll());

        return "passengers";
    }
    @PostMapping("/savePassenger")
    public String savePassenger(@ModelAttribute Passenger passenger)
    {
        passengerRepository.save(passenger);
        return "redirect:/passengers";
    }
    @GetMapping("/deletePassenger/{id}")
    public String deletePassenger(@PathVariable int id)
    {
        passengerRepository.deleteById(id);
        return "redirect:/passengers";
    }
    @GetMapping("/searchPassenger")
    public String searchPassenger(@RequestParam("keyword") String keyword,Model model)
    {
        model.addAttribute("passengers",passengerRepository.findByPassengerNameContainingIgnoreCase(keyword));
        return "passengers";
    }
    @GetMapping("/editPassenger/{id}")
    public String editPassenger(@PathVariable int id, Model model)
    {
        Passenger passenger = passengerRepository.findById(id).orElse(null);
        model.addAttribute("passenger", passenger);
        
        return "editPassenger";
    }
    @PostMapping("/updatePassenger")
    public String updatePassenger(@ModelAttribute Passenger passenger)
    {
        passengerRepository.save(passenger);
        return "redirect:/passengers";
    }
}