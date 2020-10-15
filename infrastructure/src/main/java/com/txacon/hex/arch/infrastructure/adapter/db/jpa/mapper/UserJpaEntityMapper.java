package com.txacon.hex.arch.infrastructure.adapter.db.jpa.mapper;

import com.txacon.hex.arch.domain.domain.User;
import com.txacon.hex.arch.infrastructure.adapter.db.jpa.model.UserEntity;
import org.mapstruct.Mapper;

@Mapper(uses = {EmailJpaMapper.class, UserIdJpaMapper.class, UserStatusJpaMapper.class})
public interface UserJpaEntityMapper {

    UserEntity toEntity(User user);

    User toDomainModel(UserEntity userEntity);
}
