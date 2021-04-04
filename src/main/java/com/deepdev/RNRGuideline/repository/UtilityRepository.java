package com.deepdev.RNRGuideline.repository;

import com.deepdev.RNRGuideline.models.Service;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilityRepository extends MongoRepository<Service, Long> {

    Service findByServiceId(String serviceId);

    Service deleteByServiceId(String serviceId);

}
