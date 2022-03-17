package com.resolved.userservice.service;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import com.resolved.userservice.communication.mail.MailDto;
import com.resolved.userservice.communication.mail.MailService;
import com.resolved.userservice.communication.sms.SmsDto;
import com.resolved.userservice.communication.sms.SmsService;
import com.resolved.userservice.dto.ActivationCode;
import com.resolved.userservice.dto.TokenResponce;
import com.resolved.userservice.entity.Role;
import com.resolved.userservice.entity.User;
import com.resolved.userservice.repo.RoleRepo;
import com.resolved.userservice.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserSerciceImp implements UserService, UserDetailsService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final MailService mailService;
    private final SmsService smsService;

    @Value("${server.port}")
    private String PORT;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepo.findByUsername(username);
        if(user==null){
            log.error("Uase {} not found in database",username);
            throw new UsernameNotFoundException("Uase not found in database");
        }else{
            log.info("Uase found in database:{}",username);
        }
        Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
        user.getRoles().forEach(e->{
            authorities.add(new SimpleGrantedAuthority(e.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }

    @Override
    public User saveUser(User user) {
        try{
            List<String> roleList=getRolesInForm(user.getRoles().stream().toList());
            String password = NanoIdUtils.randomNanoId();
            if(roleList.contains("LOBOUR")){
                user.setPassword(password);
            }
            user.setActivateCode(password);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(null);
            user=userRepo.save(user);
            addRoleToUser(user.getUsername(),roleList);
            user.setUserPhone("+91"+user.getUserPhone());
            sendRegistrationMessage(user,roleList);
            return user;
        }catch (RuntimeException e){
            log.info((e.getMessage()));
            return null;
        }
    }

    private void sendRegistrationMessage(User user,List<String> roleList){
        if(roleList.contains("LOBOUR")){
            String message=" Congratulation !! "+user.getUserFirstName()+" "+user.getUserLastName()+" you have registered successfully. "+
                    "Your activation key : "+user.getActivateCode();
            smsService.send(new SmsDto(user.getUserPhone(),message));
        }else{
            String message=" Congratulation !! "+user.getUserFirstName()+" "+user.getUserLastName()+" you have registered successfully. "+
                    "Your activation key : "+user.getActivateCode();
            MailDto mailDto=new MailDto();
            mailDto.setSendFrom("balmukundpandey20oct1997@gmail.com");
            mailDto.setSendTo(user.getUserEmail());
            mailDto.setMailSubject("Email verification code of PSVM");
            mailDto.setMailBody(message);
            mailService.sendMailToUser(mailDto);
        }
    }

    private List<String> getRolesInForm(List<Role> roles){
        List<String> list=new ArrayList<>();
        roles.forEach(e->list.add(e.getName()));
        return list;
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Add new role successfully");
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, List<String> roleName) {
        log.info("Add {} role to {} user successfully",roleName,username);
        for (String r:roleName) {
            User user=userRepo.findByUsername(username);
            Role role=roleRepo.findByName(r);
            var check=user.getRoles();
            if(check==null){
                user.setRoles(new ArrayList<>());
            }
            user.getRoles().add(role);
        }
    }

    @Override
    public User getUser(String username) {
        log.info("Get user {} by username",username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Get All users");
        return userRepo.findAll();
    }

    @Override
    public List<Role> getRoles() {
       log.info("Fetching all roles");
       return roleRepo.findAll();
    }

    @Override
    public User getUserByPhoneNumber(String phoneNumber) {
        try {
            return userRepo.findByUserPhone(phoneNumber).orElse(null);
        }catch(Exception e){
            log.info(e.getMessage());
            return null;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        try {
            return userRepo.findByUserEmail(email).orElse(null);
        }catch(Exception e){
            log.info(e.getMessage());
            return null;
        }
    }

    @Override
    public ResponseEntity<TokenResponce> loginByCode(ActivationCode userActivationCode) {
        User user=userRepo.findByActivateCode(userActivationCode.getActivationCode()).orElse(null);
        log.info("User name of user is =",user.getUsername(),user.getPassword());
        return this.sendRequest(user);
    }

    private ResponseEntity<TokenResponce> sendRequest(User user){
        RestTemplate restTemplate=new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("username", user.getUsername());
        map.add("password",user.getActivateCode());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        return restTemplate.postForEntity( "http://localhost:"+PORT+"/api/login", request , TokenResponce.class );
    }

}
