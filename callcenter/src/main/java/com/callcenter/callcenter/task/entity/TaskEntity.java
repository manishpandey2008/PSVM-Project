package com.callcenter.callcenter.task.entity;

import com.callcenter.callcenter.common.entity.CommonEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class TaskEntity extends CommonEntity {

    @Column(nullable = false,length = 50)
    private String taskName;

    @Column(length = 50)
    private String taskSubName;

    @Column(nullable = false,length = 10)
    private String taskMinPrice;

    @Column(length = 255)
    private String taskDescription;

    private boolean taskStatus=true;

    @Column(nullable = false)
    private Long chartId;
}
