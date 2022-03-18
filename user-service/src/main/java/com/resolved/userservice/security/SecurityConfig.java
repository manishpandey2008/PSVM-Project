package com.resolved.userservice.security;


import com.resolved.userservice.filter.CustomAuthFilter;
import com.resolved.userservice.filter.CustomAuthorizetionFilter;
import com.resolved.userservice.service.UserSerciceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserSerciceImp userSerciceImp;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        CustomAuthFilter customAuthFilter=new CustomAuthFilter(authenticationManagerBean(),userSerciceImp);
        customAuthFilter.setFilterProcessesUrl("/api/login");
            http.csrf().disable();
            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            http.authorizeRequests().antMatchers("/api/login","/api/user/new","/api/user/info","/api/user/activation-code/login","/api/user/authentication").permitAll();
            http.authorizeRequests().antMatchers(GET,"/api/user/**").hasAnyAuthority("MANAGER");
            http.authorizeRequests().antMatchers(POST,"/api/user/**").hasAnyAuthority("MANAGER");
            http.authorizeRequests().anyRequest().authenticated();
            http.addFilter(customAuthFilter);
            http.addFilterBefore(new CustomAuthorizetionFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
