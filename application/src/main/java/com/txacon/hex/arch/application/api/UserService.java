package com.txacon.hex.arch.application.api;

import com.txacon.hex.arch.application.exceptions.InvalidUserException;
import com.txacon.hex.arch.application.exceptions.UserNotFoundException;
import com.txacon.hex.arch.domain.domain.User;
import com.txacon.hex.arch.domain.domain.ids.UserId;
import com.txacon.hex.arch.domain.domain.values.Email;

import java.util.List;

public interface UserService {

    User getUserById(UserId userId) throws UserNotFoundException;

    User getUserByEmail(Email email) throws UserNotFoundException;

    void removeUser(UserId userId) throws UserNotFoundException;

    void addUser(User user) throws InvalidUserException;

    List<User> getUserList();
}
