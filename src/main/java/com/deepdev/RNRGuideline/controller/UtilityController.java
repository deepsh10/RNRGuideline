package com.deepdev.RNRGuideline.controller;

import com.deepdev.RNRGuideline.models.Service;
import com.deepdev.RNRGuideline.service.UtilityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utility")
@AllArgsConstructor
@Slf4j
public class UtilityController {

    @Autowired
    private UtilityService utilityService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public HttpStatus addUtility(@RequestBody Service service)
    {
        HttpStatus returnStatus = HttpStatus.CREATED;

        System.out.println("Received add Utility Request... ");
        try {
            utilityService.addUtility(service);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            returnStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return returnStatus;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public ResponseEntity getUtilities()
    {
        HttpStatus returnStatus = HttpStatus.OK;
        List<Service> serviceList = null;
        try {
            serviceList = utilityService.getUtility();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            returnStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity(serviceList,returnStatus);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update/{utilityId}")
    public ResponseEntity updateUtilities(@PathVariable String utilityId, @RequestBody Service updateService)
    {
        HttpStatus returnStatus = HttpStatus.OK;
        Service service = null;
        try {
            service = utilityService.updateUtility(utilityId,updateService);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            returnStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity(service,returnStatus);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/expire/{utilityId}")
    public HttpStatus deleteUtilities(@PathVariable String utilityId)
    {
        HttpStatus returnStatus = HttpStatus.ACCEPTED;
        try {
            returnStatus = utilityService.deleteUtility(utilityId);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            returnStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return returnStatus;
    }

}
