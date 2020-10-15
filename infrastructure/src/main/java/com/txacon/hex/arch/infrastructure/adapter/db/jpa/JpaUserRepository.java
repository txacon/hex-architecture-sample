package com.txacon.hex.arch.infrastructure.adapter.db.jpa;

import com.txacon.hex.arch.domain.domain.User;
import com.txacon.hex.arch.domain.domain.ids.UserId;
import com.txacon.hex.arch.domain.port.UserRepository;
import org.springframework.data.repository.CrudRepository;

public interface JpaUserRepository extends UserRepository, CrudRepository<UserId, User> {


}
