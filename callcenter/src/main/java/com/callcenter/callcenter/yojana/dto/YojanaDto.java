package com.callcenter.callcenter.yojana.dto;

import com.callcenter.callcenter.common.dto.CommonDto;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class YojanaDto extends CommonDto {
    private String yojanaName;
    private Date yojanaLastDate;
    private String yojanaDescription;
    private String yojanaLink;
    private String yojanaStatus;
    private Long centerId;
}
