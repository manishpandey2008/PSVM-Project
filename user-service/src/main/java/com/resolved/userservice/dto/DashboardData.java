package com.resolved.userservice.dto;

import com.resolved.userservice.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class DashboardData {
    private CenterData centerData;
    private List<User> users;
}
