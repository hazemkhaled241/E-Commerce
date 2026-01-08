package com.hazem.demo.mapper;

import com.hazem.demo.dtos.UserDto;
import com.hazem.demo.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "createdAt",expression = "java(java.time.LocalDateTime.now())")
    UserDto toDto(User user);
}
