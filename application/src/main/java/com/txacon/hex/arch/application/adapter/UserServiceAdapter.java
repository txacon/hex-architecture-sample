package com.txacon.hex.arch.application.adapter;

import com.txacon.hex.arch.application.api.UserService;
import com.txacon.hex.arch.application.exceptions.InvalidUserException;
import com.txacon.hex.arch.application.exceptions.UserNotFoundException;
import com.txacon.hex.arch.domain.domain.User;
import com.txacon.hex.arch.domain.domain.ids.UserId;
import com.txacon.hex.arch.domain.domain.values.Email;
import com.txacon.hex.arch.domain.port.spi.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceAdapter implements UserService {

    private final UserRepository repository;


    @Override
    public User getUserById(UserId userId) throws UserNotFoundException {
        return repository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException("userId", userId));
    }

    @Override
    public User getUserByEmail(Email email) throws UserNotFoundException {
        return repository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("email", email));
    }

    @Override
    public void removeUser(UserId userId) throws UserNotFoundException {
        if (userId == null) throw new UserNotFoundException("userId", userId);
        repository.deleteByUserId(userId);

    }

    @Override
    public void addUser(User user) throws InvalidUserException {
        if (user == null) throw new InvalidUserException("user", "is null");
        if (user.getEmail() == null) throw new InvalidUserException("email", "is null or invalid");
        if (user.getUserId() == null) user.setUserId(new UserId());
        repository.save(user);
    }

    @Override
    public List<User> getUserList() {
        return repository.getUsers();
    }
}
