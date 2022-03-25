package com.callcenter.callcenter.common.dto;

import lombok.Data;

@Data
public class DashboardDto {
    private Long totalLabour;
    private Long totalOwner;
    private Long workList;
    private Long claims;
    private Long pendingClaims;
    private Long yojana;
}
