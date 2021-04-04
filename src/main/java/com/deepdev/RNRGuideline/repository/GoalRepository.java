package com.deepdev.RNRGuideline.repository;

import com.deepdev.RNRGuideline.models.Goal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends MongoRepository<Goal, String> {
    List<Goal> findByGoalRole(String role);

    Goal findByGoalId(String goalId);

    void deleteByGoalId(String goalId);
}
