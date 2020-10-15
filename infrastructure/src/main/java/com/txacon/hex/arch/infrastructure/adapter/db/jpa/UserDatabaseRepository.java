package com.txacon.hex.arch.infrastructure.adapter.db.jpa;

import com.txacon.hex.arch.domain.domain.User;
import com.txacon.hex.arch.domain.domain.ids.UserId;
import com.txacon.hex.arch.domain.domain.values.Email;
import com.txacon.hex.arch.domain.port.spi.UserRepository;
import com.txacon.hex.arch.infrastructure.adapter.db.jpa.mapper.UserJpaEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Profile("!local")
@Repository
@RequiredArgsConstructor
public class UserDatabaseRepository implements UserRepository {

    private final JpaUserRepository repository;
    private final UserJpaEntityMapper mapper;

    @Override
    public Optional<User> findByUserId(UserId userId) {
        if (userId == null || userId.getIdValue() == null) return Optional.empty();
        return repository.findById(userId.getIdValue()).map(mapper::toDomainModel);
    }

    @Override
    public Optional<User> findByEmail(Email email) {
        if (email == null) Optional.empty();
        return repository.findByEmail(email.toString()).map(mapper::toDomainModel);
    }

    @Override
    public void save(User user) {
        Objects.requireNonNull(user);
        repository.save(mapper.toEntity(user));

    }

    @Override
    public void deleteByUserId(UserId userId) {
        if (userId == null || userId.getIdValue() == null) return;
        repository.deleteById(userId.getIdValue());
    }

    @Override
    public List<User> getUsers() {
        return repository.findAll().stream().map(mapper::toDomainModel).collect(Collectors.toList());
    }
}
