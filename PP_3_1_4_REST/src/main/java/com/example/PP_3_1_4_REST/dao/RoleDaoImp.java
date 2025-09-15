package com.example.PP_3_1_4_REST.dao;

import com.example.PP_3_1_4_REST.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDaoImp extends JpaRepository<Role, Long> {
}
