package com.airport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import com.airport.model.Flight;
import com.airport.repository.FlightRepository;

@Controller
public class FlightController 
{
    @Autowired
    private FlightRepository flightRepository;

    @GetMapping("/flights")
    public String viewFlights(Model model) 
    {
        model.addAttribute("flights", flightRepository.findAll());
        return "flights";
    }
    @PostMapping("/saveFlight")
    public String saveFlight(@ModelAttribute Flight flight)
    {
        flightRepository.save(flight);
        return "redirect:/flights";
    }
    @GetMapping("/deleteFlight/{id}")
    public String deleteFlight(@PathVariable int id)
    {
        flightRepository.deleteById(id);
        return "redirect:/flights";
    }
    @GetMapping("/searchFlight")
    public String searchFlight(@RequestParam("keyword") String keyword, Model model)
    {
        model.addAttribute("flights",
        flightRepository.findByFlightNameContainingIgnoreCase(keyword));
        
        return "flights";
    }
    @GetMapping("/editFlight/{id}")
    public String editFlight(@PathVariable int id, Model model)
    {
        Flight flight = flightRepository.findById(id).orElse(null);
        model.addAttribute("flight", flight);
        
        return "editFlight";
    }
    @PostMapping("/updateFlight")
    public String updateFlight(@ModelAttribute Flight flight)
    {
        flightRepository.save(flight);
        return "redirect:/flights";
    }
    
}
