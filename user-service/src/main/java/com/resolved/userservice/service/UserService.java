package com.resolved.userservice.service;

import com.resolved.userservice.dto.ActivationCode;
import com.resolved.userservice.dto.LoginDto;
import com.resolved.userservice.dto.TokenResponce;
import com.resolved.userservice.entity.Role;
import com.resolved.userservice.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username,List<String> role);

    User getUser(String username);

    User getUserById(Long id);

    List<User> getUsers();

    List<Role> getRoles();


    User getUserByPhoneNumber(String phoneNumber);

    User getUserByEmail(String email);

    ResponseEntity<TokenResponce> authentication(LoginDto loginDto);

    ResponseEntity<TokenResponce> loginByCode(ActivationCode userActivationCode);

}
