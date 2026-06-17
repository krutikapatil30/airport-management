package com.airport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
public class Flight 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int flightId;
    @Column(name = "flight_number")
    private String flightNumber;
    @Column(name = "flight_name")
    private String flightName;
    private String source;
    private String destination;
    private String status;
    @Column(name = "departure_time")
    private String departureTime;
    @Column(name = "arrival_time")
    private String arrivalTime;
    @Column(name = "flight_class")
    private String flightClass;
    @Column(name = "ticket_price")
    private double ticketPrice;
    @Column(name = "available_seats")
    private int availableSeats;


    public int getFlightId() 
    {
        return flightId;
    }
    public void setFlightId(int flightId) 
    {
        this.flightId = flightId;
    }

    public String getFlightNumber()
    {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber)
    {
        this.flightNumber = flightNumber;
    }

    public String getFlightName() 
    {
        return flightName;
    }
    public void setFlightName(String flightName) 
    {
        this.flightName = flightName;
    }

    public String getSource() 
    {
        return source;
    }
    public void setSource(String source) 
    {
        this.source = source;
    }

    public String getDestination() 
    {
        return destination;
    }
    public void setDestination(String destination) 
    {
        this.destination = destination;
    }

    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getDepartureTime()
    {
        return departureTime;
    }
    public void setDepartureTime(String departureTime)
    {
        this.departureTime = departureTime;
    }

    public String getArrivalTime()
    {
        return arrivalTime;
    }
    public void setArrivalTime(String arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }

    public String getFlightClass()
    {
        return flightClass;
    }
    public void setFlightClass(String flightClass)
    {
        this.flightClass = flightClass;
    }

    public double getTicketPrice()
    {
        return ticketPrice;
    }
    public void setTicketPrice(double ticketPrice)
    {
        this.ticketPrice = ticketPrice;
    }

    public int getAvailableSeats()
    {
        return availableSeats;
    }
    public void setAvailableSeats(int availableSeats)
    {
        this.availableSeats = availableSeats;
    }  
}