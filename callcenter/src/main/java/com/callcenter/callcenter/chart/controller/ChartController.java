package com.callcenter.callcenter.chart.controller;

import com.callcenter.callcenter.chart.dto.ChartDto;
import com.callcenter.callcenter.chart.service.ChartService;
import com.callcenter.callcenter.common.dto.ResponceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/chart")
public class ChartController {

    private final ChartService chartService;

    @PostMapping("/")
    public ResponseEntity<ChartDto> addChart(@RequestBody ChartDto chartDto) {
        log.info("Add new cart {}",chartDto.getChartName());
        return ResponseEntity.ok().body(chartService.addChart(chartDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<ChartDto>> getAllCharts() {
        log.info("Get all carts");
        return ResponseEntity.ok().body(chartService.getAllCharts());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponceDto> deleteChart(@PathVariable Long id) {
        log.info("Delete chart which id is {}",id);
        return ResponseEntity.ok().body(chartService.deleteChart(id));
    }

    @GetMapping("/{chartId}")
    public ResponseEntity<ChartDto> getChatByChartId(@PathVariable Long chartId) {
        log.info("Get chart which id is {}",chartId);
        return ResponseEntity.ok().body(chartService.getChartById(chartId));
    }

    @GetMapping("/center/{centerId}")
    public ResponseEntity<List<ChartDto>> getAllChartsByCenter(@PathVariable Long centerId) {
        log.info("Get all charts by center which center id is {}",centerId);
        return ResponseEntity.ok().body(chartService.getAllChartsByCenter(centerId));
    }

}
