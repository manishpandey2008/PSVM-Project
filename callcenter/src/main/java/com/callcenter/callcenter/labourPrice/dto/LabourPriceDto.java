package com.callcenter.callcenter.labourPrice.dto;

import com.callcenter.callcenter.common.dto.CommonDto;
import lombok.Data;

@Data
public class LabourPriceDto extends CommonDto {
    private String username;
    private Long taskId;
    private String minPrice;
    private String taskName;
    private String centerPrice;
}
