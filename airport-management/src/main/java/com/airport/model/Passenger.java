package com.airport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Passenger 
{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int passengerId;
    private String passengerName;
    private int age;
    private String gender;

    public int getPassengerId() 
    {
        return passengerId;
    }

    public void setPassengerId(int passengerId) 
    {
        this.passengerId = passengerId;
    }

    public String getPassengerName() 
    {
        return passengerName;
    }

    public void setPassengerName(String passengerName) 
    {
        this.passengerName = passengerName;
    }

    public int getAge() 
    {
        return age;
    }

    public void setAge(int age) 
    {
        this.age = age;
    }

    public String getGender() 
    {
        return gender;
    }

    public void setGender(String gender) 
    {
        this.gender = gender;
    }
}

