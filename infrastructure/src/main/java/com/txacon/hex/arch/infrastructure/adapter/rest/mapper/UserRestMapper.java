package com.txacon.hex.arch.infrastructure.adapter.rest.mapper;

import com.txacon.hex.arch.domain.domain.User;
import com.txacon.hex.arch.infrastructure.adapter.rest.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserIdRestMapper.class, EmailMapper.class})
public interface UserRestMapper {

    User toEntity(UserDTO userDTO);

    UserDTO toDto(User user);

}
