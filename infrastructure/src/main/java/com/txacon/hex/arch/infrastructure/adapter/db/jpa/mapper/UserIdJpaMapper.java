package com.txacon.hex.arch.infrastructure.adapter.db.jpa.mapper;

import com.txacon.hex.arch.domain.domain.ids.UserId;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface UserIdJpaMapper {

    default UserId toDomainModel(UUID userId) {
        return new UserId(userId);
    }

    default UUID toEntity(UserId userId) {
        return (userId == null) ? null : userId.getIdValue();
    }

}
