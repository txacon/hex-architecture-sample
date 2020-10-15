package com.txacon.hex.arch.application.api;

import com.txacon.hex.arch.application.exceptions.UserNotFoundException;
import com.txacon.hex.arch.domain.domain.User;
import com.txacon.hex.arch.domain.domain.ids.UserId;
import com.txacon.hex.arch.domain.domain.values.Email;

import java.util.UUID;

public interface UserService {

    User getUserById(UserId uuid) throws UserNotFoundException;

    User getUserByEmail(Email email) throws UserNotFoundException;

    void removeUser(UserId user);

    void addUser(User user);
}
