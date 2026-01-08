package com.hazem.demo.controllers;

import com.hazem.demo.dtos.UserDto;
import com.hazem.demo.entities.User;
import com.hazem.demo.mapper.UserMapper;
import com.hazem.demo.repositories.UserRepository;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    //  @GetMapping("/users")
    @GetMapping
    public Iterable<UserDto> getAllUsers(@RequestParam(required = false, defaultValue = "" ,name = "sort") String sort) {
        //contains fun can not have null parameter so we have to give it an initial value
        //name = "sort" do if i want to change the variable from sort to any name the postman side didn't affect
        if (!Set.of("name", "email").contains(sort)) {
            sort = "name";
        }
        return userRepository
                .findAll(Sort.by(sort))
                .stream()
                .map(userMapper::toDto).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        var user = userRepository.findById(id).orElse(null);
        if (user == null) {
            // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return ResponseEntity.notFound().build();
        }
        // return new ResponseEntity<>(user, HttpStatus.OK);
        return ResponseEntity.ok(userMapper.toDto(user));


    }
}
