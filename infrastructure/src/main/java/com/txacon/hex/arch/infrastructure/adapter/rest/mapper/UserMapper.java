package com.txacon.hex.arch.infrastructure.adapter.rest.mapper;

import com.txacon.hex.arch.domain.domain.User;
import com.txacon.hex.arch.infrastructure.adapter.rest.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(uses = {UserIdMapper.class, EmailMapper.class})
public interface UserMapper {

    User toEntity(UserDTO userDTO);

    UserDTO toDto(User user);

}
