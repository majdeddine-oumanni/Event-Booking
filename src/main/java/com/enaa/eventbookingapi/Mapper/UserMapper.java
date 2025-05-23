package com.enaa.eventbookingapi.Mapper;

import com.enaa.eventbookingapi.DTO.UserDto;
import com.enaa.eventbookingapi.Model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto dto);
    UserDto toDTO(User user);
    List<UserDto> toDTOs(List<User> users);
}
