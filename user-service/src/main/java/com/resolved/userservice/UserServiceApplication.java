package com.resolved.userservice;

import com.resolved.userservice.entity.Role;
import com.resolved.userservice.entity.User;
import com.resolved.userservice.service.UserSerciceImp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}


	@Bean
	PasswordEncoder getPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	@LoadBalanced
	RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@Bean
	CommandLineRunner run(UserSerciceImp userSerciceImp){
		return args -> {
			if(userSerciceImp.getRoles().size()==0){
				userSerciceImp.saveRole(new Role(null,"ADMIN"));
				userSerciceImp.saveRole(new Role(null,"MANAGER"));
				userSerciceImp.saveRole(new Role(null,"LOBOUR"));
				userSerciceImp.saveRole(new Role(null,"OWNER"));
			}
			if (userSerciceImp.getUser("admin@123")==null){
				User user=new User();
				user.setId(null);
				user.setUserFirstName("Admin");
				user.setUserLastName("User");
				user.setUsername("admin@123");
				user.setPassword("password");
				user.setUserEmail("admin@gmail.com");
				user.setUserPhone("9898767654");
				user.setPinCode("878767");
				user.setState("Rajasthan");
				user.setDistrict("Kota");
				user.setFullAddress("Shreenathpuram kota Rajasthan");
				user.setActivateCode("admincode");
				user.setAccountActiveStatus(true);
				user.setCurrentActiveStatus(true);
				ArrayList<Role> list=new ArrayList<>();
				list.add(new Role(null,"ADMIN"));
				user.setRoles(list);
				userSerciceImp.saveUser(user);
			}
		};
	}
}
