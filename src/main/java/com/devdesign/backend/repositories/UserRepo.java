package com.devdesign.backend.repositories;

import com.devdesign.backend.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, String> {
    User findByToken(String token);
}
