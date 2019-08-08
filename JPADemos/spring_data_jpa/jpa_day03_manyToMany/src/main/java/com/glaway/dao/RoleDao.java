package com.glaway.dao;

import com.glaway.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface RoleDao extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {
}
