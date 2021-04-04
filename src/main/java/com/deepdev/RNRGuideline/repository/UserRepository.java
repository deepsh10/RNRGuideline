package com.deepdev.RNRGuideline.repository;

import com.deepdev.RNRGuideline.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByUserId(String userId);

    void deleteByUserId(String userId);
}
