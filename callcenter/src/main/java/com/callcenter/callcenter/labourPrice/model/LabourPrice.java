package com.callcenter.callcenter.labourPrice.model;

import com.callcenter.callcenter.common.entity.CommonEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "labour_price")
public class LabourPrice extends CommonEntity {
    private String username;
    private Long taskId;
    private String minPrice;
}
