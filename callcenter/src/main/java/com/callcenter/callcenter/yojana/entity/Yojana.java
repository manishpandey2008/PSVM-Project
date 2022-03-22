package com.callcenter.callcenter.yojana.entity;

import com.callcenter.callcenter.common.entity.CommonEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;


@Data
@Entity
public class Yojana extends CommonEntity {
    @Column(nullable = false,length = 50)
    private String yojanaName;

    @Column(nullable = false,length = 50)
    private Date yojanaLastDate;

    @Column(length = 255)
    private String yojanaDescription;

    private String yojanaLink;

    private String yojanaStatus;

    @Column(nullable = false)
    private Long centerId;
}
