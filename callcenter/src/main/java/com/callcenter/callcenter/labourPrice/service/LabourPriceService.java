package com.callcenter.callcenter.labourPrice.service;

import com.callcenter.callcenter.common.dto.ResponceDto;
import com.callcenter.callcenter.common.service.ModelMapper;
import com.callcenter.callcenter.labourPrice.dto.LabourPriceDto;
import com.callcenter.callcenter.labourPrice.model.LabourPrice;
import com.callcenter.callcenter.labourPrice.repo.LabourPriceRepo;
import com.callcenter.callcenter.task.entity.TaskEntity;
import com.callcenter.callcenter.task.repo.TaskRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LabourPriceService {

    private final ModelMapper modelMapper;
    private final LabourPriceRepo labourPriceRepo;
    private final TaskRepo taskRepo;

    public LabourPriceDto addLabourPrice(LabourPriceDto labourPriceDto) {
        try{
            LabourPrice labourPrice=modelMapper.map(labourPriceDto,LabourPrice.class);
            labourPrice.setCreatedTime(new Date());
            labourPrice.setUpdatedTime(new Date());
            return modelMapper.map(labourPriceRepo.save(labourPrice), LabourPriceDto.class);
        }catch(Exception ex){
            log.info("Error: add new Labour Price error is {}",ex.getMessage());
            return null;
        }
    }

    public List<LabourPriceDto> getAllLabourPrice() {
        try{
            return this.conversion(labourPriceRepo.findAll());
        }catch(Exception ex){
            log.info("Error: find all labour Price error is {}",ex.getMessage());
            return null;
        }
    }

    public ResponceDto deleteLabourPrice(Long id) {
        try{
            labourPriceRepo.deleteById(id);
            return new ResponceDto("Delete Successfully.......!!", HttpStatus.OK);
        }catch(Exception ex){
            log.info("Error: Delete pincode error is {}",ex.getMessage());
            return null;
        }
    }

    public LabourPriceDto getLabourPriceById(Long id) {
        try{
            return modelMapper.map(labourPriceRepo.findById(id),LabourPriceDto.class);
        }catch(Exception ex){
            log.info("Error: Get labour price by id error is {}",ex.getMessage());
            return null;
        }
    }

    public List<LabourPriceDto> getLabourPriceByUsername(String username) {
        try{
            List<LabourPriceDto> list=this.conversion(labourPriceRepo.findAllByUsername(username).orElse(null));
            list.forEach(e->{
                TaskEntity taskEntity=this.taskRepo.findById(e.getTaskId()).orElse(null);
                if (taskEntity != null) {
                    e.setTaskName(taskEntity.getTaskName());
                    e.setCenterPrice(taskEntity.getTaskMinPrice());
                } else {
                    e.setTaskName(null);
                }
            });
            return list;
        }catch(Exception ex){
            log.info("Error: Get all Labour Price  by username error is {}",ex.getMessage());
            return null;
        }
    }

    public List<LabourPriceDto> conversion(List<LabourPrice> list ){
        List<LabourPriceDto> result=new LinkedList<>();
        for(LabourPrice labourPrice:list){
            result.add( modelMapper.map(labourPrice,LabourPriceDto.class));
        }
        return result;
    }
}
