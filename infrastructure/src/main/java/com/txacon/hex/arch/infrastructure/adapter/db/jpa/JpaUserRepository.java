package com.txacon.hex.arch.infrastructure.adapter.db.jpa;

import com.txacon.hex.arch.infrastructure.adapter.db.jpa.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByEmail(String email);

    List<UserEntity> findAll();
}
