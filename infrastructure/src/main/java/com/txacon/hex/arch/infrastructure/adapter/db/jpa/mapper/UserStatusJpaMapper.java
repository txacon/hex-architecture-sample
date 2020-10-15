package com.txacon.hex.arch.infrastructure.adapter.db.jpa.mapper;

import com.txacon.hex.arch.domain.domain.UserStatus;
import com.txacon.hex.arch.infrastructure.adapter.db.jpa.model.UserStatusValue;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;

@Mapper
public interface UserStatusJpaMapper {

    @ValueMapping(source = "ACTIVE", target = "ACTIVE")
    @ValueMapping(source = "INACTIVE", target = "INACTIVE")
    UserStatusValue toEntity(UserStatus userStatus);

    @ValueMapping(source = "ACTIVE", target = "ACTIVE")
    @ValueMapping(source = "INACTIVE", target = "INACTIVE")
    UserStatus toDomainModel(UserStatusValue userStatus);


}
