package com.enaa.eventbookingapi.controller;

import com.enaa.eventbookingapi.DTO.EventDto;
import com.enaa.eventbookingapi.Model.Event;
import com.enaa.eventbookingapi.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public EventDto addEvent(@RequestBody EventDto dto){
        return eventService.saveEvent(dto);
    }

    @GetMapping
    public List<EventDto> getEvents(){
        return eventService.getAll();
    }

    @PutMapping("/{id}")
    public EventDto updateEvent(@PathVariable Long id ,EventDto dto){
        return eventService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(Long id){
        eventService.delete(id);
    }
}
