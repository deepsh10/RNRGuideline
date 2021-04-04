package com.deepdev.RNRGuideline.controller;

import com.deepdev.RNRGuideline.models.User;
import com.deepdev.RNRGuideline.service.UserServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/user")
@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserServices userServices;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public ResponseEntity addUser(@RequestBody User user)
    {
        HttpStatus returnStatus= HttpStatus.CREATED;
        try {
            userServices.addUser(user);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            returnStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity(returnStatus);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/{userId}")
    public ResponseEntity getUser(@PathVariable String userId)
    {
        HttpStatus returnStatus = HttpStatus.OK;
        User user= null;
        try{
            user = userServices.getUserById(userId);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            returnStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity(user, returnStatus);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update/{userId}")
    public ResponseEntity updateUser(@PathVariable String userId, @RequestBody User user)
    {
        HttpStatus returnStatus = HttpStatus.ACCEPTED;

        try{
            userServices.updateUser(userId,user);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            returnStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity(returnStatus);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{userId}")
    public ResponseEntity deleteUser(@PathVariable String userId)
    {
        HttpStatus returnStatus = HttpStatus.ACCEPTED;

        try{
            userServices.deleteUser(userId);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            returnStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity(returnStatus);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public ResponseEntity getUserAll()
    {
        log.info("-- Getting all the users");
        List<User> userList = userServices.getAllUsers();
        return new ResponseEntity(userList,HttpStatus.OK);
    }

}
