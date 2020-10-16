package com.txacon.hex.arch.infrastructure.adapter.rest.mapper;

import com.txacon.hex.arch.domain.domain.values.Email;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmailMapper {

    default Email mapStrToEmail(String email) {
        return Email.of(email);
    }

    default String mapEmailToStr(Email email) {
        return email == null ? null : email.toString();
    }
}
