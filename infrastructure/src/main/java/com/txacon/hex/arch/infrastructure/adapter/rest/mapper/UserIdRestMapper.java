package com.txacon.hex.arch.infrastructure.adapter.rest.mapper;

import com.txacon.hex.arch.domain.domain.ids.UserId;
import org.apache.logging.log4j.util.Strings;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserIdRestMapper {

    default UserId mapStrToUserId(String userIdStr) {
        return (userIdStr == null || Strings.isEmpty(userIdStr)) ?  null : new UserId(userIdStr);
    }

    default String mapUserIdToStr(UserId userId) {
        return (userId == null) ? null : userId.toString();
    }
}
