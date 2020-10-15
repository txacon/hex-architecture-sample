package com.txacon.hex.arch.application.adapter;

import com.txacon.hex.arch.application.api.UserService;
import com.txacon.hex.arch.application.exceptions.UserNotFoundException;
import com.txacon.hex.arch.domain.domain.User;
import com.txacon.hex.arch.domain.domain.ids.UserId;
import com.txacon.hex.arch.domain.domain.values.Email;
import com.txacon.hex.arch.domain.port.spi.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceAdapter implements UserService {

    private final UserRepository repository;


    @Override
    public User getUserById(UserId userId) throws UserNotFoundException {
        return repository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException("userId",userId));
    }

    @Override
    public User getUserByEmail(Email email) throws UserNotFoundException{
        return repository.findByEmail(email).orElseThrow(()-> new UserNotFoundException("email",email));
    }

    @Override
    public void removeUser(UserId user) {

    }

    @Override
    public void addUser(User user) {

    }
}
