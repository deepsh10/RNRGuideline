package com.deepdev.RNRGuideline.service;

import com.deepdev.RNRGuideline.exception.RNRAppException;

import com.deepdev.RNRGuideline.models.Role;
import com.deepdev.RNRGuideline.repository.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class RoleServices {

    @Autowired
    private RoleRepository roleRepository;

    public void addRole(Role role) {
        role.setRoleAddDate(Instant.now());
        role.toString();
        roleRepository.save(role);
    }

    public Role getRoleById(String roleId) {
        Role role = roleRepository.findByRoleId(roleId);
        return role;
    }

    public void updateRole(String roleId, Role role) {
        Role existingRole = roleRepository.findByRoleId(roleId);

        if(existingRole == null)
        {
            throw new RNRAppException("Invalid Input. Incorrect input provided.");
        }

        existingRole.setRoleName(role.getRoleName());
        existingRole.setRoleRemoveDate(role.getRoleRemoveDate());

        roleRepository.save(existingRole);
    }

    public void deleteRole(String roleId) {
        Role existingRole = roleRepository.findByRoleId(roleId);

        if(existingRole == null)
        {
            throw new RNRAppException("Invalid Input. Incorrect input provided.");
        }

        roleRepository.deleteByRoleId(roleId);
    }

    public List<Role> getAllRoles() {

        return roleRepository.findAll();

    }
}
