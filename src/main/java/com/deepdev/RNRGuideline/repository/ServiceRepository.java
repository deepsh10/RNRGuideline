package com.deepdev.RNRGuideline.repository;

import com.deepdev.RNRGuideline.models.Service;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends MongoRepository<Service, String> {

}
