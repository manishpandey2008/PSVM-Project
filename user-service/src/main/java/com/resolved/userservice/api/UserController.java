package com.resolved.userservice.api;

import com.resolved.userservice.dto.ActivationCode;
import com.resolved.userservice.dto.RollToUser;
import com.resolved.userservice.dto.TokenResponce;
import com.resolved.userservice.entity.Role;
import com.resolved.userservice.entity.User;
import com.resolved.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/info")
    public ResponseEntity<String> getUserServiceInfo(){
        return ResponseEntity.ok().body("User service working fine");
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles(){
        return userService.getRoles();
    }

    @PostMapping("/new")
    public ResponseEntity<User> addUser(@RequestBody User user){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @GetMapping("{username}")
    public ResponseEntity<User> getlUser(@PathVariable String username){
        return ResponseEntity.ok().body(userService.getUser(username));
    }

//    @PostMapping("/role")
//    public ResponseEntity<Role> addRole(@RequestBody  Role role){
//        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/").toUriString());
//        return ResponseEntity.created(uri).body(userService.saveRole(role));
//    }

//    @PostMapping("/roletouser")
//    public ResponseEntity<?> addRoleForUser(@RequestBody RollToUser rollToUser){
//        userService.addRoleToUser(rollToUser.getUsername(),rollToUser.getRollNames());
//        return null;
//    }

    @GetMapping("/phoneNumber/{phoneNumber}")
    public ResponseEntity<User> getUserByPhoneNumber(String phoneNumber){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/phoneNumber/"+phoneNumber).toUriString());
        return ResponseEntity.created(uri).body(userService.getUserByPhoneNumber(phoneNumber));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(String email){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/email/"+email).toUriString());
        return ResponseEntity.created(uri).body(userService.getUserByEmail(email));
    }


    @PostMapping("/activation-code/login")
    public ResponseEntity<TokenResponce> loginByActivationCode(@RequestBody ActivationCode activationCode){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/activation-code/login").toUriString());
        return userService.loginByCode(activationCode);
    }



}
