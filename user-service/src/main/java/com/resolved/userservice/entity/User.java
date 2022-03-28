package com.resolved.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false,length = 50)
    private String userFirstName;

    @Column(nullable = false,length = 50)
    private String userLastName;

    @Column(length = 20,unique = true,nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(length = 30)
    private String userEmail;

    @Column(nullable = false,length = 15,unique = true)
    private String userPhone;

    @Column(nullable = false,length = 6)
    private String pinCode;

    @Column(nullable = false,length = 50)
    private String state;

    @Column(nullable = false,length = 50)
    private String district;

    @Column(nullable = false,length = 100)
    private String village;

    @Column(nullable = false,length = 100)
    private String post;


    @Column(nullable = false,length = 200)
    private String fullAddress;

    private Long centerId;

    private String managerUsername;

    @Column(nullable = false,length = 50)
    private String activateCode;

    @Column(nullable = false)
    private boolean accountActiveStatus;

    @Column(nullable = false)
    private boolean currentActiveStatus;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles=new ArrayList<>();
}
