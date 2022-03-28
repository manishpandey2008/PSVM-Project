package com.resolved.userservice.dto;

import lombok.Data;

@Data
public class PincodeDto {
    private String username;
    private String pinCode;
    private String activeStatus;
    private String village;
    private String postOffice;
}
