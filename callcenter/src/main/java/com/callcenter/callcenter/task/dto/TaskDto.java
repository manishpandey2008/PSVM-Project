package com.callcenter.callcenter.task.dto;

import com.callcenter.callcenter.common.dto.CommonDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDto extends CommonDto {
    private String taskName;
    private String taskSubName;
    private String taskMinPrice;
    private boolean taskStatus;
    private Long chartId;
}
