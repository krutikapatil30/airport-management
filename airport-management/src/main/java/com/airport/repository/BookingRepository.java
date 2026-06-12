package com.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.airport.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> 
{
    List<Booking> findByPassengerNameContainingIgnoreCase(String keyword);
}
