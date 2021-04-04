package com.deepdev.RNRGuideline.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "role")
public class Role {

    @Id
    private String roleId;

    private String roleName;

    private Instant roleAddDate;

    private Instant roleRemoveDate;
}
