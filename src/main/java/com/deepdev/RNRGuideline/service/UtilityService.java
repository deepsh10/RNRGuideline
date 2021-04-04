package com.deepdev.RNRGuideline.service;

import com.deepdev.RNRGuideline.exception.RNRAppException;
import com.deepdev.RNRGuideline.models.Service;
import com.deepdev.RNRGuideline.repository.UtilityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class UtilityService {

    @Autowired
    private UtilityRepository utilityRepository;

    public void addUtility(Service service) {
        System.out.println("Adding Utility ");
        service.setCreatedTime(Instant.now());
        service.setLastModified(Instant.now());

        service.toString();
        utilityRepository.save(service);
    }

    public List<Service> getUtility() {

        return utilityRepository.findAll();

    }

    public Service updateUtility(String utilityId, Service updateService) {

        Service service = utilityRepository.findByServiceId(utilityId);

        if(service == null){
            throw new RNRAppException("Invalid Input. Incorrect input provided.");
        }

        service.setLastModified(Instant.now());
        service.setAllowDenyInd(updateService.getAllowDenyInd());
        service.setDefaultAccessInd(updateService.getDefaultAccessInd());
        service.setUtility(updateService.getUtility());

        Service returnService = utilityRepository.save(service);

        return returnService;
    }

    public HttpStatus deleteUtility(String utilityId) {

        Service service = utilityRepository.findByServiceId(utilityId);

        if(service == null){
            throw new RNRAppException("Invalid Input. Incorrect input provided.");
        }

        utilityRepository.deleteByServiceId(utilityId);
        return HttpStatus.ACCEPTED;
    }
}
