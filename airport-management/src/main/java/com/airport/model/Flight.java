package com.airport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Flight 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int flightId;
    private String flightNumber;
    private String flightName;
    private String source;
    private String destination;
    private String status;

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
}