package com.example.PP_3_1_4_REST.init;

import com.example.PP_3_1_4_REST.model.Role;
import com.example.PP_3_1_4_REST.model.User;
import com.example.PP_3_1_4_REST.service.RoleServiceImp;
import com.example.PP_3_1_4_REST.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Init {
    private final UserServiceImp userService;
    private final RoleServiceImp roleService;

    @Autowired
    public Init(UserServiceImp userService, RoleServiceImp roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void initDB() {
        addRoleToDB();
        addAdminAndUserToDB();
        addAdminToDB();
        addUserToDB();
    }

    private void addRoleToDB() {
        roleService.addRole(new Role(1L, "ROLE_USER"));
        roleService.addRole(new Role(2L, "ROLE_ADMIN"));
    }

    private void addAdminAndUserToDB() {
        User adminUser;
        Set<Role> roleAdminUser = new HashSet<>();

        roleAdminUser.add(new Role(1L, "ROLE_USER"));
        roleAdminUser.add(new Role(2L, "ROLE_ADMIN"));

        adminUser = new User(1L, "admin", "adminov", 23, "admin@mail.ru", "admin", roleAdminUser);

        userService.saveUser(adminUser);
    }

    private void addAdminToDB() {
        User admin;
        Set<Role> roleAdmin = new HashSet<>();

        roleAdmin.add(new Role(2L, "ROLE_ADMIN"));

        admin = new User(2L, "user1", "user1ov", 42, "user1@mail.ru", "user1", roleAdmin);

        userService.saveUser(admin);
    }

    private void addUserToDB() {
        User user;
        Set<Role> roleUser = new HashSet<>();

        roleUser.add(new Role(1L, "ROLE_USER"));

        user = new User(3L, "user", "userov", 37, "user@mail.ru", "user", roleUser);

        userService.saveUser(user);
    }
}
