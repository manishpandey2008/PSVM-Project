package com.callcenter.callcenter.yojana.sservice;

import com.callcenter.callcenter.common.dto.ResponceDto;
import com.callcenter.callcenter.common.service.ModelMapper;
import com.callcenter.callcenter.task.dto.TaskDto;
import com.callcenter.callcenter.task.entity.TaskEntity;
import com.callcenter.callcenter.task.repo.TaskRepo;
import com.callcenter.callcenter.yojana.dto.YojanaDto;
import com.callcenter.callcenter.yojana.entity.Yojana;
import com.callcenter.callcenter.yojana.repo.YojanaRepo;
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
public class YojanaServiceImp implements YojanaService{

    private final ModelMapper modelMapper;
    private final YojanaRepo yojanaRepo;


    @Override
    public YojanaDto addYojana(YojanaDto yojanaDto) {
        try{
            Yojana yojana=modelMapper.map(yojanaDto,Yojana.class);
            yojana.setCreatedTime(new Date());
            yojana.setUpdatedTime(new Date());
            return modelMapper.map(yojanaRepo.save(yojana), YojanaDto.class);
        }catch(Exception ex){
            log.info("Error: add new yojana error is {}",ex.getMessage());
            return null;
        }
    }

    @Override
    public List<YojanaDto> getAllYojanas() {
        try{
            return this.conversion(yojanaRepo.findAll());
        }catch(Exception ex){
            log.info("Error: find all yojanas error is {}",ex.getMessage());
            return null;
        }
    }

    @Override
    public ResponceDto deleteYojana(Long id) {
        try{
            yojanaRepo.deleteById(id);
            return new ResponceDto("Delete Successfully.......!!", HttpStatus.OK);
        }catch(Exception ex){
            log.info("Error: Delete yojana error is {}",ex.getMessage());
            return null;
        }
    }

    @Override
    public YojanaDto getYojanaById(Long yojanaId) {
        try{
            return modelMapper.map(yojanaRepo.findById(yojanaId),YojanaDto.class);
        }catch(Exception ex){
            log.info("Error: Get task by yojana id error is {}",ex.getMessage());
            return null;
        }
    }

    @Override
    public List<YojanaDto> getAllYojanaByCenterId(Long centerId) {
        try{
            return this.conversion(yojanaRepo.findAllByCenterId(centerId));
        }catch(Exception ex){
            log.info("Error: Get all yojana by chart id error is {}",ex.getMessage());
            return null;
        }
    }

    public List<YojanaDto> conversion(List<Yojana> list ){
        List<YojanaDto> result=new LinkedList<>();
        for(Yojana yojana:list){
            result.add( modelMapper.map(yojana,YojanaDto.class));
        }
        return result;
    }
}
