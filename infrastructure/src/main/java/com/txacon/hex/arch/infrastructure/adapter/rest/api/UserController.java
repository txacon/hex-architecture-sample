package com.txacon.hex.arch.infrastructure.adapter.rest.api;

import com.txacon.hex.arch.domain.port.spi.UserRepository;
import com.txacon.hex.arch.infrastructure.adapter.rest.dto.UserDTO;
import com.txacon.hex.arch.infrastructure.adapter.rest.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository crud;
    private final UserMapper mapper;

    @GetMapping("/{userId")
    public ResponseEntity<UserDTO> findUser(@PathVariable UUID userId){
    }
}
