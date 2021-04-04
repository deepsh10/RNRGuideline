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
@Document(collection = "goal")
public class Goal {

    @Id
    private String goalId;

    private String goalRole;

    private String goalCategory;

    private String goalText;

    private Instant goalAddDate;

    private Instant goalExpirationDate;
}
