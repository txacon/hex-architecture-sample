package com.txacon.hex.arch.infrastructure.adapter.rest.api;


import com.txacon.hex.arch.application.api.UserService;
import com.txacon.hex.arch.application.exceptions.InvalidUserException;
import com.txacon.hex.arch.application.exceptions.UserNotFoundException;
import com.txacon.hex.arch.domain.domain.ids.UserId;
import com.txacon.hex.arch.domain.domain.values.Email;
import com.txacon.hex.arch.infrastructure.adapter.rest.dto.UserDTO;
import com.txacon.hex.arch.infrastructure.adapter.rest.mapper.UserRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRestMapper userMapper;

    // Single Item

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> findUser(@PathVariable UUID userId) throws UserNotFoundException {
        return ResponseEntity.ok(userMapper.toDto(userService.getUserById(new UserId(userId))));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> removeUser(@PathVariable UUID userId) throws UserNotFoundException {
        userService.removeUser(new UserId(userId));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/")
    public ResponseEntity<UserDTO> findByEmail(@RequestParam String email) throws UserNotFoundException {
        return ResponseEntity.ok(userMapper.toDto(userService.getUserByEmail(Email.of(email))));
    }

    // Aggregate root

    @PostMapping("")
    public ResponseEntity<Void> addNewUser(@RequestBody UserDTO userDTO) throws InvalidUserException {
        userService.addUser(userMapper.toEntity(userDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> findAllUsers() throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUserList().stream().map(userMapper::toDto).collect(Collectors.toList()));
    }

}

