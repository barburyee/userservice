package com.kimeli.userservice.services;

import com.kimeli.userservice.model.AppUser;
import com.kimeli.userservice.model.Role;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser username);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUser();

}
