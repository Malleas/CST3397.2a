package com.gcu.topic71a.data.repository;

import com.gcu.topic71a.data.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<UserEntity, String> {

    UserEntity findByUsername(String username);
}
