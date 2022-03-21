package com.callcenter.callcenter.center.dto;

import com.callcenter.callcenter.common.dto.CommonDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CenterDto extends CommonDto {

    private String centerName;

    private String centerDistrict;

    private String centerState;

    private String centerFullAddress;

    private String centerHelplineNumber;

    private String centerEmail;

    private String centerStartingTime;

    private String centerCloseTime;

    private String managerUsername;
}
