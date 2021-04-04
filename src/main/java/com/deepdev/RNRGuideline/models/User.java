package com.deepdev.RNRGuideline.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private String userId;

    private String userName;

    private String emailId;

    private Date dob;

    private Instant passwordSetDate;

    private Integer resetPasswordDays;

    private String passwordPolicy;

    private String password;

    private Date passwordExpirationDate;

}
