package com.deepdev.RNRGuideline.controller;

import com.deepdev.RNRGuideline.models.UserGoals;
import com.deepdev.RNRGuideline.service.UserGoalsServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/userGoal")
public class UserGoalsController {

    @Autowired
    private UserGoalsServices userGoalsServices;

    @RequestMapping(method= RequestMethod.POST,value= "/add")
    public ResponseEntity addUserGoal(@RequestBody UserGoals goal)
    {
        userGoalsServices.addUserGoal(goal);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(method= RequestMethod.GET,value= "/get/{userId}")
    public ResponseEntity getUserGoalByUserId(@PathVariable String userId)
    {
        List<UserGoals> userGoalsList = userGoalsServices.getUserById(userId);
        return new ResponseEntity(userGoalsList,HttpStatus.OK);
    }

    @RequestMapping(method= RequestMethod.POST,value= "/update/{userGoalId}")
    public ResponseEntity updateGoal(@PathVariable String userGoalId,@RequestBody UserGoals goal)
    {
        userGoalsServices.updateUser(userGoalId,goal);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(method= RequestMethod.POST,value= "/delete/{userGoalId}")
    public ResponseEntity deleteGoal(@PathVariable String userGoalId)
    {
        userGoalsServices.deleteUserGoal(userGoalId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
