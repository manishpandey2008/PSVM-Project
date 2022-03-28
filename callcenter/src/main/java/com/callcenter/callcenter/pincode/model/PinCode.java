package com.callcenter.callcenter.pincode.model;


import com.callcenter.callcenter.common.entity.CommonEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class PinCode extends CommonEntity {
    @Column(nullable = false,length = 50)
    private String username;

    @Column(nullable = false,length = 6)
    private String pinCode;

    @Column(nullable = false,length = 10)
    private String activeStatus;

    @Column(nullable = false)
    private String village;

    @Column(length = 50)
    private String postOffice;
}
