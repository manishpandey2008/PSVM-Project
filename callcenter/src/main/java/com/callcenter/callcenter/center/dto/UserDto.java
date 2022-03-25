package com.callcenter.callcenter.center.dto;

import java.util.ArrayList;
import java.util.Collection;

public class UserDto {
    private Long id;

    private String userFirstName;

    private String userLastName;

    private String username;

    private String password;

    private String userEmail;

    private String userPhone;

    private String pinCode;

    private String state;

    private String district;

    private String fullAddress;

    private Long centerId;

    private String managerUsername;

    private String activateCode;

    private boolean accountActiveStatus;

    private boolean currentActiveStatus;

    private Collection<RoleDto> roles=new ArrayList<>();
}
