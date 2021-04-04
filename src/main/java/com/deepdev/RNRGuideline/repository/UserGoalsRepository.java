package com.deepdev.RNRGuideline.repository;

import com.deepdev.RNRGuideline.models.UserGoals;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGoalsRepository extends MongoRepository<UserGoals, String> {
    List<UserGoals> findByUserId(String userId);

    void deleteByUserId(String userId);

    UserGoals findByUserGoalId(String userGoalId);

    void deleteByUserGoalId(String userGoalId);
}
