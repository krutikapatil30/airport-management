package com.airport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.airport.model.Booking;
import com.airport.repository.BookingRepository;
import com.airport.repository.PassengerRepository;
import com.airport.repository.FlightRepository;
import com.airport.model.Flight;

@Controller
public class BookingController 
{
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private FlightRepository flightRepository;
    @GetMapping("/bookings")
    public String viewBookings(Model model) 
    {
        model.addAttribute("bookings", bookingRepository.findAll());
        return "bookings";
    }
    @GetMapping("/searchBooking")
    public String searchBooking(@RequestParam("keyword") String keyword, Model model)
    {
        model.addAttribute("bookings",bookingRepository.findByPassengerNameContainingIgnoreCase(keyword));
        return "bookings";
    }
    @PostMapping("/saveBooking")
    public String saveBooking(@ModelAttribute Booking booking,RedirectAttributes redirectAttributes)
    {
        String passengerName = booking.getPassengerName().trim();
        String flightName = booking.getFlightName().trim();
        
        boolean passengerExists =passengerRepository.existsByPassengerNameIgnoreCase(passengerName);
        boolean flightExists =flightRepository.existsByFlightNameIgnoreCase(flightName);
        
        booking.setPassengerName(passengerName);
        booking.setFlightName(flightName);
        
        if(!passengerExists || !flightExists)
        {
            redirectAttributes.addFlashAttribute(
                "error",
                "Passenger or Flight does not exist!");
                return "redirect:/bookings";
        }
        Flight flight = flightRepository.findFirstByFlightNameIgnoreCaseAndAvailableSeatsGreaterThanOrderByFlightIdDesc(flightName, 0);
        if(flight == null)
        {
            redirectAttributes.addFlashAttribute("error","No seats available for this flight!");
            return "redirect:/bookings";
        }
        flight.setAvailableSeats(flight.getAvailableSeats() - 1);
        flightRepository.save(flight);
        bookingRepository.save(booking);
        
        redirectAttributes.addFlashAttribute("success","Booking Saved Successfully!");
        return "redirect:/bookings";
    }

    @GetMapping("/deleteBooking/{id}")
    public String deleteBooking(@PathVariable int id)
    {
        bookingRepository.deleteById(id);
        return "redirect:/bookings";
    }
    @GetMapping("/editBooking/{id}")
    public String editBooking(@PathVariable int id, Model model)
    {
        Booking booking = bookingRepository.findById(id).orElse(null);
        model.addAttribute("booking", booking);
        
        return "editBooking";
    }
    @PostMapping("/updateBooking")
    public String updateBooking(@ModelAttribute Booking booking)
    {
        bookingRepository.save(booking);
        return "redirect:/bookings";
    }
}


