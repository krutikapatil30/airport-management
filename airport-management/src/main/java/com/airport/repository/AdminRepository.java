package com.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.airport.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, String>
{
    Admin findByUsernameAndPassword(String username, String password);
    Admin findByUsername(String username);
}
