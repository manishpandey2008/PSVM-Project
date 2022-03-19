package com.callcenter.callcenter.center.entity;

import com.callcenter.callcenter.common.entity.CommonEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "resolved_call_center")
public class CenterEntity extends CommonEntity {

    @Column(nullable = false,length = 100)
    private String centerName;

    @Column(nullable = false,length = 50)
    private String centerDistrict;

    @Column(nullable = false,length = 50)
    private String centerState;

    @Column(nullable = false,length = 150)
    private String centerFullAddress;

    @Column(nullable = false)
    private String centerHelplineNumber;

    @Column(length = 50)
    private String centerEmail;

    @Column(nullable = false,length = 10)
    private String centerStartingTime;

    @Column(nullable = false,length = 10)
    private String centerCloseTime;

    private String managerUsername;
}
