package com.callcenter.callcenter.center.service;

import com.callcenter.callcenter.center.dto.CenterDto;
import com.callcenter.callcenter.center.entity.CenterEntity;
import com.callcenter.callcenter.common.dto.DashboardDto;
import com.callcenter.callcenter.common.dto.ResponceDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CenterService {
    CenterDto addCenter(CenterDto centerDto);
    List<CenterDto>  getAllCenter();
    ResponceDto deleteCenter(Long id);
    List<CenterDto> getAllCenterByState(String stateName);
//    List<CenterDto> getByUsername(String username);
    List<CenterDto> getAllCenterByDistrict(String districtName);
}
