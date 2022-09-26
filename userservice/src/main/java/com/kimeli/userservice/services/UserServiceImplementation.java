package com.kimeli.userservice.services;

import com.kimeli.userservice.model.AppUser;
import com.kimeli.userservice.model.Role;
import com.kimeli.userservice.repository.RoleRepository;
import com.kimeli.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
//@RequiredArgsConstructor
@Transactional
@Slf4j      //For Logging things while app is running
public class UserServiceImplementation implements UserService{
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  RoleRepository roleRepository;

    @Override
    public AppUser saveUser(AppUser user) {
        log.info("Saving the User {} to the db",user.getUsername());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving the ROle {} to the db",role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding the role {} to the User {}",roleName, username);
        //first find the user with the supplied user name
        AppUser user = userRepository.findByUserName((username));
        //find the new role to be added to user
        Role role = roleRepository.findByName(roleName);
        //take the user and add this new role to it
        user.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String username) {
        //to reurn the user details bearing username supplied
        log.info("Fetching User {} Details From Db",username);
        return userRepository.findByUserName(username);
    }

    @Override
    public List<AppUser> getUser() {
        //to return all the users in the db
        log.info("Fetching All the users from to the db");
        return userRepository.findAll();
    }
}
