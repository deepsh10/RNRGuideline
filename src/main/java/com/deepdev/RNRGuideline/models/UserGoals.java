package com.deepdev.RNRGuideline.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "userGoals")
public class UserGoals {

    @Id
    private String userGoalId;

    private String userId;

    private String goalId;

    private Instant goalAddDate;

    private String goalStatus;

    private Instant goalExpirationDate;
}
