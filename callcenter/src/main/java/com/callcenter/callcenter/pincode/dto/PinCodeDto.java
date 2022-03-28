package com.callcenter.callcenter.pincode.dto;

import com.callcenter.callcenter.common.dto.CommonDto;
import lombok.Data;


@Data
public class PinCodeDto extends CommonDto {
    private String username;
    private String pinCode;
    private String activeStatus;
    private String village;
    private String postOffice;
}
