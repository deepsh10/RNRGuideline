package com.deepdev.RNRGuideline.repository;

import com.deepdev.RNRGuideline.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByRoleId(String roleId);

    void deleteByRoleId(String roleId);
}
