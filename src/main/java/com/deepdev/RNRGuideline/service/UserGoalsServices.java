package com.deepdev.RNRGuideline.service;

import com.deepdev.RNRGuideline.exception.RNRAppException;
import com.deepdev.RNRGuideline.models.UserGoals;
import com.deepdev.RNRGuideline.repository.UserGoalsRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class UserGoalsServices {

    @Autowired
    private UserGoalsRepository userGoalRepository;

    public void addUserGoal(UserGoals userGoals) {
        userGoals.setGoalAddDate(Instant.now());
        userGoals.toString();
        userGoalRepository.save(userGoals);
    }

    public List<UserGoals> getUserById(String userId) {
        List<UserGoals> userGoals = userGoalRepository.findByUserId(userId);
        return userGoals;
    }

    public void updateUser(String userGoalId, UserGoals userGoals) {
        UserGoals existingUser = userGoalRepository.findByUserGoalId(userGoalId);

        if(existingUser == null)
        {
            throw new RNRAppException("Invalid Input. Incorrect input provided.");
        }

        existingUser.setGoalExpirationDate(userGoals.getGoalExpirationDate());
        existingUser.setGoalId(userGoals.getGoalId());
        existingUser.setGoalStatus(userGoals.getGoalStatus());
        existingUser.setUserId(userGoals.getUserId());

        userGoalRepository.save(existingUser);
    }

    public void deleteUserGoal(String userGoalId) {
        UserGoals existingUserGoal = userGoalRepository.findByUserGoalId(userGoalId);

        if(existingUserGoal == null)
        {
            throw new RNRAppException("Invalid Input. Incorrect input provided.");
        }

        userGoalRepository.deleteByUserGoalId(userGoalId);
    }

    public List<UserGoals> getAllUserGoals() {

        return userGoalRepository.findAll();

    }

}
