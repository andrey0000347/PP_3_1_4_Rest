package com.example.PP_3_1_4_REST.repository;

import com.example.PP_3_1_4_REST.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
