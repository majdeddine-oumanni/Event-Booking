package com.enaa.eventbookingapi.Mapper;

import com.enaa.eventbookingapi.DTO.EventDto;
import com.enaa.eventbookingapi.Model.Event;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {
    Event toEntity(EventDto dto);
    EventDto toDTO(Event event);
    List<EventDto> toDTOs(List<Event> eventList);
}
