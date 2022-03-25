package com.callcenter.callcenter.center.controller;

import com.callcenter.callcenter.center.dto.CenterDto;
import com.callcenter.callcenter.center.dto.UserDto;
import com.callcenter.callcenter.center.service.CenterService;
import com.callcenter.callcenter.common.dto.DashboardDto;
import com.callcenter.callcenter.common.dto.ResponceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/center")
public class CenterController {
    private final CenterService centerService;

    @Value("${server.userService.port}")
    private String PORT;

    @PostMapping("/")
    public ResponseEntity<CenterDto> addCenter(@RequestBody CenterDto centerDto) {
        log.info("Add new center {}",centerDto.getCenterName());
        return ResponseEntity.ok().body(centerService.addCenter(centerDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<CenterDto>> getAllCenter() {
        log.info("Get all center list");
        return ResponseEntity.ok().body(centerService.getAllCenter());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponceDto> deleteCenter(@PathVariable Long id) {
        log.info("Deleted center id number is {}",id);
        return ResponseEntity.ok().body(centerService.deleteCenter(id));
    }

    @PutMapping("/")
    public ResponseEntity<CenterDto> updateCenter(@RequestBody CenterDto centerDto) {
        log.info("Updated center {}",centerDto.getCenterName());
        return ResponseEntity.ok().body(centerService.addCenter(centerDto));
    }

    @GetMapping("/state/{stateName}")
    public ResponseEntity<List<CenterDto>> getAllCenterByState(@PathVariable String stateName) {
        log.info("Get all center which state name is {}",stateName);
        return ResponseEntity.ok().body(centerService.getAllCenterByState(stateName));
    }

    @GetMapping("/district/{districtName}")
    public ResponseEntity<List<CenterDto>> getAllCenterByDistrict(@PathVariable  String districtName) {
        log.info("Get all center which districtName name is {}",districtName);
        return ResponseEntity.ok().body(centerService.getAllCenterByDistrict(districtName));
    }


    @GetMapping("/dashboard")
    public DashboardDto dashboard() {
        RestTemplate restTemplate=new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        UserDto[] list= restTemplate.getForObject( "http://localhost:"+PORT+"/api/user/" , UserDto[].class);

        return centerService.dashboard();
    }
}
