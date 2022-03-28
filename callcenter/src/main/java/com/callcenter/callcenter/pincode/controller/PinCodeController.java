package com.callcenter.callcenter.pincode.controller;

import com.callcenter.callcenter.common.dto.ResponceDto;
import com.callcenter.callcenter.pincode.dto.PinCodeDto;
import com.callcenter.callcenter.pincode.service.PinCodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/pincode")
public class PinCodeController {

    private final PinCodeService pinCodeService;

    @PostMapping("/")
    public ResponseEntity<PinCodeDto> addPinCode(@RequestBody PinCodeDto pinCodeDto){
        log.info("Add new pincode {}",pinCodeDto.getPinCode());
        return ResponseEntity.ok().body(pinCodeService.addPinCode(pinCodeDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<PinCodeDto>> getAllPinCodes(){
        log.info("Get all pincode list");
        return ResponseEntity.ok().body(pinCodeService.getAllPinCodes());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponceDto> deletePinCode(@PathVariable Long id){
        log.info("Deleted pincode which id is {}",id);
        return ResponseEntity.ok().body(pinCodeService.deletePinCode(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PinCodeDto> getPinCodeById(@PathVariable Long id){
        log.info("Cet pincode which id is {}",id);
        return ResponseEntity.ok().body(pinCodeService.getPinCodeById(id));
    }

    @GetMapping("username/{username}")
    public ResponseEntity<List<PinCodeDto>> getAllPinCodeByUsername(@PathVariable String username){
        log.info("Cet pincodes which username is {}",username);
        return ResponseEntity.ok().body(pinCodeService.getAllPinCodeByUsername(username));
    }
}
