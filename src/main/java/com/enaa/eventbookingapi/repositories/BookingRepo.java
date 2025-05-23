package com.enaa.eventbookingapi.repositories;

import com.enaa.eventbookingapi.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long id);
}
