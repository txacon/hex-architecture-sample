package com.txacon.hex.arch.application.adapter;

import com.txacon.hex.arch.application.api.UserService;
import com.txacon.hex.arch.application.exceptions.ApiError;
import com.txacon.hex.arch.application.exceptions.InvalidUserException;
import com.txacon.hex.arch.application.exceptions.UserNotFoundException;
import com.txacon.hex.arch.domain.domain.User;
import com.txacon.hex.arch.domain.domain.ids.UserId;
import com.txacon.hex.arch.domain.domain.values.Email;
import com.txacon.hex.arch.domain.port.spi.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceAdapter implements UserService {

    private final UserRepository repository;


    @Override
    public User getUserById(UserId userId) throws UserNotFoundException {
        return repository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException(ApiError.ERROR_USER_NOT_FOUND_BY_ID));
    }

    @Override
    public User getUserByEmail(Email email) throws UserNotFoundException {
        return repository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(ApiError.ERROR_USER_NOT_FOUND_BY_EMAIL));
    }

    @Override
    public void removeUser(UserId userId) throws UserNotFoundException {
        if (userId == null) throw new UserNotFoundException(ApiError.ERROR_USER_NOT_FOUND_BY_ID);
        repository.deleteByUserId(userId);

    }

    @Override
    public void addUser(User user) throws InvalidUserException {
        if (user == null) throw new InvalidUserException(ApiError.ERROR_USER_IS_NULL);
        if (user.getEmail() == null) throw new InvalidUserException(ApiError.ERROR_USER_WITHOUT_EMAIL);
        if (repository.findByEmail(user.getEmail()).isPresent()) throw new InvalidUserException(ApiError.ERROR_USER_ALLREADY_EXITS);
        if (user.getUserId() == null) user.setUserId(new UserId());
        repository.save(user);
    }

    @Override
    public List<User> getUserList() {
        return repository.getUsers();
    }
}
