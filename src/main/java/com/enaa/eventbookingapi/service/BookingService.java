package com.enaa.eventbookingapi.service;

import com.enaa.eventbookingapi.Model.Booking;
import com.enaa.eventbookingapi.Model.Event;
import com.enaa.eventbookingapi.Model.User;
import com.enaa.eventbookingapi.repositories.BookingRepo;
import com.enaa.eventbookingapi.repositories.EventRepo;
import com.enaa.eventbookingapi.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepo bookingRepository;
    private final UserRepo userRepository;
    private final EventRepo eventRepository;

    public BookingService(BookingRepo bookingRepository, UserRepo userRepository, EventRepo eventRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    public Booking createBooking(Long userId, Long eventId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setEvent(event);
        booking.setBookingDate(LocalDate.from(LocalDateTime.now()));
        return bookingRepository.save(booking);
    }

    public List<Booking> getUserBookings(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
}
