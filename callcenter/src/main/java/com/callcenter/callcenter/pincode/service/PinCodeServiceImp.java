package com.callcenter.callcenter.pincode.service;

import com.callcenter.callcenter.common.dto.ResponceDto;
import com.callcenter.callcenter.common.service.ModelMapper;
import com.callcenter.callcenter.pincode.dto.PinCodeDto;
import com.callcenter.callcenter.pincode.model.PinCode;
import com.callcenter.callcenter.pincode.repo.PinCodeRepo;
import com.callcenter.callcenter.task.dto.TaskDto;
import com.callcenter.callcenter.task.entity.TaskEntity;
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
public class PinCodeServiceImp implements PinCodeService{

    private final PinCodeRepo pinCodeRepo;
    private final ModelMapper modelMapper;

    @Override
    public PinCodeDto addPinCode(PinCodeDto pinCodeDto) {
        try{
            PinCode pinCode=modelMapper.map(pinCodeDto,PinCode.class);
            pinCode.setCreatedTime(new Date());
            pinCode.setUpdatedTime(new Date());
            return modelMapper.map(pinCodeRepo.save(pinCode),PinCodeDto.class);
        }catch(Exception ex){
            log.info("Error: add new pincode error is {}",ex.getMessage());
            return null;
        }
    }

    @Override
    public List<PinCodeDto> getAllPinCodes() {
        try{
            return this.conversion(pinCodeRepo.findAll());
        }catch(Exception ex){
            log.info("Error: find all pincodes error is {}",ex.getMessage());
            return null;
        }
    }

    @Override
    public ResponceDto deletePinCode(Long id) {
        try{
            pinCodeRepo.deleteById(id);
            return new ResponceDto("Delete Successfully.......!!", HttpStatus.OK);
        }catch(Exception ex){
            log.info("Error: Delete pincode error is {}",ex.getMessage());
            return null;
        }
    }

    @Override
    public PinCodeDto getPinCodeById(Long id) {
        try{
            return modelMapper.map(pinCodeRepo.findById(id),PinCodeDto.class);
        }catch(Exception ex){
            log.info("Error: Get pincode by id error is {}",ex.getMessage());
            return null;
        }
    }

    @Override
    public List<PinCodeDto> getAllPinCodeByUsername(String username) {
        try{
            return this.conversion(pinCodeRepo.findAllByUsername(username).orElse(null));
        }catch(Exception ex){
            log.info("Error: Get all tasks by chart id error is {}",ex.getMessage());
            return null;
        }
    }

    public List<PinCodeDto> conversion(List<PinCode> list ){
        List<PinCodeDto> result=new LinkedList<>();
        for(PinCode pinCode:list){
            result.add( modelMapper.map(pinCode,PinCodeDto.class));
        }
        return result;
    }
}
