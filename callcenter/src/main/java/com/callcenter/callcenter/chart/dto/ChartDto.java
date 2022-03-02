package com.callcenter.callcenter.chart.dto;

import com.callcenter.callcenter.common.dto.CommonDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChartDto extends CommonDto {
    private String chartName;
    private Date chartStartDate;
    private boolean chartListStatus;
    private Long centerId;
}
