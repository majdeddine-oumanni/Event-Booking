package com.enaa.eventbookingapi.Mapper;

import com.enaa.eventbookingapi.DTO.BookingDto;
import com.enaa.eventbookingapi.Model.Booking;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    Booking toEntity(BookingDto dto);
    BookingDto toDTO(Booking booking);
    List<BookingDto> toDTOs(List<Booking> bookingList);
}
