package com.deepdev.RNRGuideline.controller;

import com.deepdev.RNRGuideline.models.Goal;
import com.deepdev.RNRGuideline.service.GoalServices;
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
@RequestMapping("/goal")
public class GoalController {

    @Autowired
    private GoalServices goalServices;

    @RequestMapping(method= RequestMethod.POST,value= "/import")
    public ResponseEntity importRnRGoals() //TODO: Implement Kafka for importing goals
    {
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(method= RequestMethod.POST,value= "/add")
    public ResponseEntity addGoal(@RequestBody Goal goal)
    {
        HttpStatus returnStatus = HttpStatus.CREATED;

        System.out.println("Received add Utility Request... ");
        try {
            goalServices.addGoal(goal);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            returnStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity(returnStatus);
    }

    @RequestMapping(method= RequestMethod.GET,value= "/get/goalId/{goalId}")
    public ResponseEntity getGoal(@PathVariable String goalId)
    {
        HttpStatus returnStatus = HttpStatus.OK;

        Goal goal = null;
        try {
            goal = goalServices.getGoal(goalId);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            returnStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity(goal,returnStatus);
    }

    @RequestMapping(method= RequestMethod.GET,value= "/get/roleName/{roleName}")
    public ResponseEntity getGoalByRole(@PathVariable String roleName)
    {
        HttpStatus returnStatus = HttpStatus.OK;

        List<Goal> goal = null;
        try {
            goal = goalServices.getGoalByRole(roleName);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            returnStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity(goal,returnStatus);
    }

    @RequestMapping(method= RequestMethod.POST,value= "/update/goalId/{goalId}")
    public ResponseEntity updateGoal(@PathVariable String goalId,@RequestBody Goal goal)
    {
        HttpStatus returnStatus = HttpStatus.OK;
        Goal service = null;
        try {
            service = goalServices.updateGoals(goalId,goal);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            returnStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity(service,returnStatus);
    }

    @RequestMapping(method= RequestMethod.POST,value= "/delete/goalId/{goalId}")
    public ResponseEntity deleteGoal(@PathVariable String goalId)
    {
        HttpStatus returnStatus = HttpStatus.ACCEPTED;
        try {
            goalServices.deleteGoal(goalId);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            returnStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity(returnStatus);
    }
}
