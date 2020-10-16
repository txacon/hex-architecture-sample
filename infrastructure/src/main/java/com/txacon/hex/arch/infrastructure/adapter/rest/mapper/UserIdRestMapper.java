package com.txacon.hex.arch.infrastructure.adapter.rest.mapper;

import com.txacon.hex.arch.domain.domain.ids.UserId;
import org.mapstruct.Mapper;

@Mapper
public interface UserIdRestMapper {

    default UserId mapStrToUserId(String userIdStr){
        return new UserId(userIdStr);
    }

    default String mapUserIdToStr(UserId userId){
        return (userId == null) ? null : userId.toString();
    }
}
