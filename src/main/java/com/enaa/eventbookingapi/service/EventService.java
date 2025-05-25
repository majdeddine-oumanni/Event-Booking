package com.enaa.eventbookingapi.service;

import com.enaa.eventbookingapi.DTO.EventDto;
import com.enaa.eventbookingapi.Mapper.EventMapper;
import com.enaa.eventbookingapi.Model.Event;
import com.enaa.eventbookingapi.repositories.EventRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventRepo eventRepo;
    private final EventMapper eventMapper;

    public EventService(EventRepo eventRepo, EventMapper eventMapper) {
        this.eventRepo = eventRepo;
        this.eventMapper = eventMapper;
    }
    public EventDto saveEvent(EventDto dto){
        Event event = eventMapper.toEntity(dto);
        Event savedEvent = eventRepo.save(event);
        return eventMapper.toDTO(savedEvent);
    }

    public List<EventDto> getAll(){
        List<Event> events = eventRepo.findAll();
        return eventMapper.toDTOs(events);
    }

    public EventDto update(Long id, EventDto dto){
        Event event = eventRepo.findEventById(id);
        EventDto foundDto = eventMapper.toDTO(event);
        foundDto.setName(dto.getName());
        foundDto.setCategory(dto.getCategory());
        foundDto.setDate(dto.getDate());
        foundDto.setLocation(dto.getLocation());
        return foundDto;
    }

    public void delete(Long id){
        eventRepo.deleteById(id);
    }
}
