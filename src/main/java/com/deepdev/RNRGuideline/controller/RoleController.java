package com.deepdev.RNRGuideline.controller;

import com.deepdev.RNRGuideline.models.Role;
import com.deepdev.RNRGuideline.service.RoleServices;
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

@Controller
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleServices roleServices;

    @RequestMapping(method= RequestMethod.POST,value= "/add")
    public ResponseEntity addRole(@RequestBody Role role)
    {
        roleServices.addRole(role);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(method= RequestMethod.GET,value= "/get/{roleId}")
    public ResponseEntity getRole(@PathVariable String roleId)
    {
        Role role = roleServices.getRoleById(roleId);
        return new ResponseEntity(role,HttpStatus.OK);
    }

    @RequestMapping(method= RequestMethod.POST,value= "/update/{roleId}")
    public ResponseEntity updateRole(@PathVariable String roleId,@RequestBody Role role)
    {
        roleServices.updateRole(roleId,role);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(method= RequestMethod.POST,value= "/delete/{roleId}")
    public ResponseEntity deleteRole(@PathVariable String roleId)
    {
        roleServices.deleteRole(roleId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
