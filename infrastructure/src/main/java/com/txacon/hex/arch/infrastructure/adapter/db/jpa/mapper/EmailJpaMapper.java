package com.txacon.hex.arch.infrastructure.adapter.db.jpa.mapper;

import com.txacon.hex.arch.domain.domain.values.Email;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmailJpaMapper {

    default Email toDomainModel(String email) {
        return Email.of(email);
    }

    default String toEntity(Email email) {
        return email == null ? null : email.toString();
    }
}
