package com.callcenter.callcenter.common.controller;

import com.callcenter.callcenter.common.dto.ResponceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/")
public class CommonController {

        @GetMapping("info")
        public ResponseEntity<ResponceDto> getServiceInfo(){
            log.info("Get service information");
            return ResponseEntity.ok().body(new ResponceDto("Center service working fine.....!!", HttpStatus.OK));
        }
}
