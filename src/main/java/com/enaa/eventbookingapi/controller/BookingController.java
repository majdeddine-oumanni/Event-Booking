package com.enaa.eventbookingapi.controller;

import com.enaa.eventbookingapi.Model.Booking;
import com.enaa.eventbookingapi.service.BookingService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    @PreAuthorize("hasRole('CLIENT')")
    public Booking createBooking(@RequestBody BookingRequest request) {
        return bookingService.createBooking(request.getUserId(), request.getEventId());
    }
}

class BookingRequest {
    private Long userId;
    private Long eventId;

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }
}