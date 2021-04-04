package com.deepdev.RNRGuideline.service;

import com.deepdev.RNRGuideline.exception.RNRAppException;
import com.deepdev.RNRGuideline.models.Goal;
import com.deepdev.RNRGuideline.repository.GoalRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@org.springframework.stereotype.Service
public class GoalServices {

    @Autowired
    private GoalRepository goalRepository;

    public Goal getGoal(String goalId) {

        Optional<Goal> goalList = goalRepository.findById(goalId);

        return goalList.get();
    }

    public List<Goal> getGoalByRole(String role) {
        List<Goal> goalList = goalRepository.findByGoalRole(role);
        return goalList;
    }

    public void addGoal(Goal goal) {
        goal.setGoalAddDate(Instant.now());
        goalRepository.save(goal);
    }

    public Goal updateGoals(String goalId, Goal updatedGoal) {

        Goal goal = goalRepository.findByGoalId(goalId);

        if(goal== null)
        {
            throw new RNRAppException("Invalid Input. Incorrect input provided.");
        }

        goal.setGoalCategory(updatedGoal.getGoalCategory());
        goal.setGoalExpirationDate(updatedGoal.getGoalExpirationDate());
        goal.setGoalRole(updatedGoal.getGoalRole());
        goal.setGoalText(updatedGoal.getGoalText());

        goalRepository.save(goal);

        return goal;
    }

    public void deleteGoal(String goalId) {

        Goal goal = goalRepository.findByGoalId(goalId);

        if(goal== null)
        {
            throw new RNRAppException("Invalid Input. Incorrect input provided.");
        }

        goalRepository.deleteByGoalId(goalId);
    }

}
