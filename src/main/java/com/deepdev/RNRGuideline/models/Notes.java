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
@Document(collection = "notes")
public class Notes {

    @Id
    private String noteId;

    private String goalId;

    private String noteText;

    private Instant noteCreationDate;
}
