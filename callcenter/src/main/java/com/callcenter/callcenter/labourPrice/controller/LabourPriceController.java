package com.callcenter.callcenter.labourPrice.controller;

import com.callcenter.callcenter.common.dto.ResponceDto;
import com.callcenter.callcenter.labourPrice.dto.LabourPriceDto;
import com.callcenter.callcenter.labourPrice.service.LabourPriceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/labour-price")
public class LabourPriceController {

    private final LabourPriceService labourPriceService;

    @PostMapping("/")
    public ResponseEntity<LabourPriceDto> addLabourPrice(@RequestBody LabourPriceDto labourPriceDto) {
        log.info("Add new task {}",labourPriceDto.getTaskId());
        return ResponseEntity.ok().body(labourPriceService.addLabourPrice(labourPriceDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<LabourPriceDto>> getAllLabourPrices() {
        log.info("Get all Labour Price");
        return ResponseEntity.ok().body(labourPriceService.getAllLabourPrice());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponceDto> deleteLabourPrice(@PathVariable("id") Long id) {
        log.info("Delete Labour Price which id is {}",id);
        return ResponseEntity.ok().body(labourPriceService.deleteLabourPrice(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LabourPriceDto> getLabourPriceById(@PathVariable("id") Long id) {
        log.info("Get Labour Price which id is {}",id);
        return ResponseEntity.ok().body(labourPriceService.getLabourPriceById(id));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<List<LabourPriceDto>> getLabourPriceByUsername(@PathVariable("username") String username) {
        log.info("Get all Labour Price by username which username is {}",username);
        return ResponseEntity.ok().body(labourPriceService.getLabourPriceByUsername(username));
    }
}
