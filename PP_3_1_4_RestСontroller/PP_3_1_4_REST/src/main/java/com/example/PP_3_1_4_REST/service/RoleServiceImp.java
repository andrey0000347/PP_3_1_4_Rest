package com.example.PP_3_1_4_REST.service;

import com.example.PP_3_1_4_REST.repository.RoleRepository;
import com.example.PP_3_1_4_REST.model.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RoleServiceImp implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }
}

