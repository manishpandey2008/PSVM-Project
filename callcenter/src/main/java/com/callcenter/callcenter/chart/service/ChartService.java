package com.callcenter.callcenter.chart.service;

import com.callcenter.callcenter.chart.dto.ChartDto;
import com.callcenter.callcenter.common.dto.ResponceDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChartService {
    ChartDto addChart(ChartDto chartDto);
    List<ChartDto> getAllCharts();
    ResponceDto deleteChart(Long id);
    ChartDto getChartById(Long chartId);
    List<ChartDto> getAllChartsByCenter(Long centerId);
}
