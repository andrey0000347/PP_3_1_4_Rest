package com.example.PP_3_1_4_REST.service;

import com.example.PP_3_1_4_REST.dao.RoleDaoImp;
import com.example.PP_3_1_4_REST.model.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RoleServiceImp implements RoleService {
    private final RoleDaoImp roleRepository;

    public RoleServiceImp(RoleDaoImp roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }
}

