package com.airport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    private String passengerName;
    private String flightName;
    private double ticketPrice;
    private String pnr;

    public int getBookingId() 
    {
        return bookingId;
    }

    public void setBookingId(int bookingId) 
    {
        this.bookingId = bookingId;
    }

    public String getPassengerName() 
    {
        return passengerName;
    }

    public void setPassengerName(String passengerName) 
    {
        this.passengerName = passengerName;
    }

    public String getFlightName() 
    {
        return flightName;
    }

    public void setFlightName(String flightName) 
    {
        this.flightName = flightName;
    }

    public double getTicketPrice()
    {
        return ticketPrice;
    }
    public void setTicketPrice(double ticketPrice)
    {
        this.ticketPrice = ticketPrice;
    }

    public String getPnr()
    {
        return pnr;
    }
    public void setPnr(String pnr)
    {
        this.pnr = pnr;
    }
}