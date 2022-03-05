package com.callcenter.callcenter.chart.entity;

import com.callcenter.callcenter.common.entity.CommonEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Data
@Entity
public class Chart extends CommonEntity {

    @Column(nullable = false,length = 50)
    private String chartName;

    @Column(nullable = false)
    private Date chartStartDate;

    private boolean chartListStatus=false;

    @Column(nullable = false)
    private Long centerId;
}