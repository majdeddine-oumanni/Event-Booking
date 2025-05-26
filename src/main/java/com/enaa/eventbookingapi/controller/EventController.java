package com.enaa.eventbookingapi.controller;

import com.enaa.eventbookingapi.DTO.EventDto;
import com.enaa.eventbookingapi.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public EventDto createEvent(@RequestBody EventDto event) {
        return eventService.saveEvent(event);
    }

    @GetMapping
    public List<EventDto> getAllEvents() {
        return eventService.getAll();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public EventDto updateEvent(@PathVariable Long id, @RequestBody EventDto event) {
        return eventService.update(id, event);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        eventService.delete(id);
        return ResponseEntity.ok("Event deleted");
    }
}