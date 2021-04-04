package com.deepdev.RNRGuideline.service;

import com.deepdev.RNRGuideline.exception.RNRAppException;
import com.deepdev.RNRGuideline.models.User;
import com.deepdev.RNRGuideline.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
        user.setPasswordSetDate(Instant.now());
        user.toString();
        userRepository.save(user);
    }

    public User getUserById(String userId) {
        User user = userRepository.findByUserId(userId);
        return user;
    }

    public void updateUser(String userId, User user) {
        User existingUser = userRepository.findByUserId(userId);

        if(existingUser == null)
        {
            throw new RNRAppException("Invalid Input. Incorrect input provided.");
        }

        existingUser.setPasswordSetDate(user.getPasswordSetDate());
        existingUser.setPassword(user.getPassword());
        existingUser.setPasswordExpirationDate(user.getPasswordExpirationDate());
        existingUser.setPasswordPolicy(user.getPasswordPolicy());
        existingUser.setResetPasswordDays(user.getResetPasswordDays());
        existingUser.setUserName(user.getUserName());
        existingUser.setDob(user.getDob());
        existingUser.setEmailId(user.getEmailId());

        userRepository.save(existingUser);
    }

    public void deleteUser(String userId) {
        User existingUser = userRepository.findByUserId(userId);

        if(existingUser == null)
        {
            throw new RNRAppException("Invalid Input. Incorrect input provided.");
        }

        userRepository.deleteByUserId(userId);
    }

    public List<User> getAllUsers() {

        return userRepository.findAll();

    }
}
