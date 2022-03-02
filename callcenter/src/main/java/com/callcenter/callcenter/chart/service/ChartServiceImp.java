package com.callcenter.callcenter.chart.service;

import com.callcenter.callcenter.center.dto.CenterDto;
import com.callcenter.callcenter.center.entity.CenterEntity;
import com.callcenter.callcenter.chart.dto.ChartDto;
import com.callcenter.callcenter.chart.entity.Chart;
import com.callcenter.callcenter.chart.repo.ChartRepo;
import com.callcenter.callcenter.common.dto.ResponceDto;
import com.callcenter.callcenter.common.service.ModelMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class ChartServiceImp implements ChartService{

    private final ChartRepo chartRepo;
    private final ModelMapper modelMapper;

    @Override
    public ChartDto addChart(ChartDto chartDto) {
       try{
           Chart chart=modelMapper.map(chartDto,Chart.class);
           chart.setCreatedTime(new Date());
           chart.setUpdatedTime(new Date());
           return modelMapper.map(chartRepo.save(chart),ChartDto.class);
       }catch(Exception ex){
            log.info("Error: add new chart error is {}",ex.getMessage());
            return null;
       }
    }

    @Override
    public List<ChartDto> getAllCharts() {
        try{
            return this.conversion(chartRepo.findAll());
        }catch(Exception ex){
            log.info("Error: Find all charts error is {}",ex.getMessage());
            return null;
        }
    }

    @Override
    public ResponceDto deleteChart(Long id) {
        try{
            chartRepo.deleteById(id);
            return new ResponceDto("Delete Successfully", HttpStatus.OK);
        }catch(Exception ex){
            log.info("Error: Delete error is {}",ex.getMessage());
            return null;
        }
    }

    @Override
    public ChartDto getChartById(Long chartId) {
        try{
            return modelMapper.map(chartRepo.findById(chartId),ChartDto.class);
        }catch(Exception ex){
            log.info("Error: Get chart by id error is {}",ex.getMessage());
            return null;
        }
    }

    @Override
    public List<ChartDto> getAllChartsByCenter(Long centerId) {
        try{
            return this.conversion(chartRepo.findAllByCenterId(centerId));
        }catch(Exception ex){
            log.info("Error: Get all charts by center id error is {}",ex.getMessage());
            return null;
        }
    }

    public List<ChartDto> conversion(List<Chart> list ){
        List<ChartDto> result=new LinkedList<>();
        for(Chart chart:list){
            result.add( modelMapper.map(chart,ChartDto.class));
        }
        return result;
    }
}
