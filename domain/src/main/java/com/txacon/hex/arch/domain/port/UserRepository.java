package com.txacon.hex.arch.domain.port;

import com.txacon.hex.arch.domain.domain.User;
import com.txacon.hex.arch.domain.domain.ids.UserId;
import com.txacon.hex.arch.domain.domain.values.Email;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User> findByUserId(UserId userId);

    Optional<User> findByEmail(Email email);

    void save(User user);

    void deleteByUserId(UserId userId);

    List<User> getUsers();


}
