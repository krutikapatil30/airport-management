package com.airport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.airport.repository.FlightRepository;
import com.airport.repository.PassengerRepository;
import com.airport.repository.BookingRepository;

@Controller
public class HomeController 
{

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/")
    public String home(Model model) 
    {

        model.addAttribute("flightCount", flightRepository.count());
        model.addAttribute("passengerCount", passengerRepository.count());
        model.addAttribute("bookingCount", bookingRepository.count());

        return "index";
    }
}
