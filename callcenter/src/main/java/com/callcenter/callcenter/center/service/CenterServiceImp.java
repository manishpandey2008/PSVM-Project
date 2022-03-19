package com.callcenter.callcenter.center.service;

import com.callcenter.callcenter.center.dto.CenterDto;
import com.callcenter.callcenter.center.entity.CenterEntity;
import com.callcenter.callcenter.center.repo.CenterRepo;
import com.callcenter.callcenter.common.dto.ResponceDto;
import com.callcenter.callcenter.common.service.ModelMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
public record CenterServiceImp(CenterRepo centerRepo, ModelMapper modelMapper) implements CenterService{

    @Override
    public CenterDto addCenter(CenterDto centerDto) {
        try{
            CenterEntity center=modelMapper.map(centerDto, CenterEntity.class);
            center.setCreatedTime(new Date());
            center.setUpdatedTime(new Date());
            return modelMapper.map(centerRepo.save(center),CenterDto.class);
        }catch(Exception ex){
            log.info("Error at save time is {}", ex.getMessage());
            return null;
        }
    }

    @Override
    public List<CenterDto> getAllCenter() {
        try{
            return this.conversion(centerRepo.findAll());
        }catch(Exception ex){
            log.info("Error at get all time is {}", ex.getMessage());
            return null;
        }
    }

    @Override
    public ResponceDto deleteCenter(Long id) {
        try{
            centerRepo.deleteById(id);
            return new ResponceDto("Delete Successfully", HttpStatus.OK);
        }catch(Exception ex){
            log.info("Error at delete time is {}", ex.getMessage());
            return null;
        }
    }

    @Override
    public List<CenterDto> getAllCenterByState(String stateName) {
        try{
            return this.conversion(centerRepo.findAllByCenterState(stateName));
        }catch(Exception ex){
            log.info("Error at get all state in district {}", stateName);
            return null;
        }
    }

    @Override
    public List<CenterDto> getAllCenterByDistrict(String districtName) {
        try{
            return this.conversion(centerRepo.findAllByCenterDistrict(districtName));
        }catch(Exception ex){
            log.info("Error at get all center in district {}", districtName);
            return null;
        }
    }

    public List<CenterDto> conversion(List<CenterEntity> list ){
        List<CenterDto> result=new LinkedList<>();
        for(CenterEntity centerEntity:list){
            result.add( modelMapper.map(centerEntity,CenterDto.class));
        }
        return result;
    }


//    public boolean authentication(List<CenterEntity> list ){
//        List<CenterDto> result=new LinkedList<>();
//        for(CenterEntity centerEntity:list){
//            result.add( modelMapper.map(centerEntity,CenterDto.class));
//        }
//        return result;
//    }
}
