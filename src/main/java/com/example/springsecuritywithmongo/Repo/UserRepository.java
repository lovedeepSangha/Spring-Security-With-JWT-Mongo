package com.example.springsecuritywithmongo.Repo;

import com.example.springsecuritywithmongo.Domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * created by lovedeep in com.example.springsecuritywithmongo.Repo
 */
@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}
