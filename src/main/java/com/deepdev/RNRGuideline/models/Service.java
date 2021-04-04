package com.deepdev.RNRGuideline.models;

import lombok.*;

import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "service")
public class Service {

    @Id
    private String serviceId;

    private String utility;

    private AllowDeny allowDenyInd;

    private AllowDeny defaultAccessInd;

    private Instant createdTime;

    private Instant lastModified;

}