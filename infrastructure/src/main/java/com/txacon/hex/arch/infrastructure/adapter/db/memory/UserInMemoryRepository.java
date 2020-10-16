package com.txacon.hex.arch.infrastructure.adapter.db.memory;

import com.txacon.hex.arch.domain.domain.User;
import com.txacon.hex.arch.domain.domain.ids.UserId;
import com.txacon.hex.arch.domain.domain.values.Email;
import com.txacon.hex.arch.domain.port.spi.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
@Profile("local")
public class UserInMemoryRepository implements UserRepository {

    private final Map<Email, UserId> storeEmailKey;
    private final Map<UserId, User> store;

    public UserInMemoryRepository() {
        store = new HashMap<>();
        storeEmailKey = new HashMap<>();
    }


    @Override
    public Optional<User> findByUserId(UserId userId) {
        if (userId == null) return Optional.empty();
        return Optional.ofNullable(store.get(userId));
    }

    @Override
    public Optional<User> findByEmail(Email email) {
        if (email == null) return Optional.empty();
        return Optional.ofNullable(storeEmailKey.get(email)).map(store::get);
    }

    @Override
    public void save(User user) {
        if (user == null) return;
        synchronized (this) {
            storeEmailKey.put(user.getEmail(), user.getUserId());
            store.put(user.getUserId(), user);
        }

    }

    @Override
    public void deleteByUserId(UserId userId) {
        if (userId == null) return;
        synchronized (this) {
            User user = store.get(userId);
            if (user == null) return;
            storeEmailKey.remove(user.getEmail());
            store.remove(user.getUserId());
        }
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(store.values());
    }
}
