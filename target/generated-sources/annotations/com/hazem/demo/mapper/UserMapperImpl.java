package com.hazem.demo.mapper;

import com.hazem.demo.dtos.UserDto;
import com.hazem.demo.entities.User;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-07T22:09:24+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String email = null;

        id = user.getId();
        name = user.getName();
        email = user.getEmail();

        LocalDateTime createdAt = java.time.LocalDateTime.now();

        UserDto userDto = new UserDto( id, name, email, createdAt );

        return userDto;
    }
}
