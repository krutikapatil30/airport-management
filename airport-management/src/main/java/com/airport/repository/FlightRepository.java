package com.airport.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.airport.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> 
{
    List<Flight> findByFlightNameContainingIgnoreCase(String flightName);
    boolean existsByFlightNameIgnoreCase(String flightName);

}
