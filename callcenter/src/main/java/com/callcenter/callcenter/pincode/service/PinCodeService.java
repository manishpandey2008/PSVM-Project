package com.callcenter.callcenter.pincode.service;

import com.callcenter.callcenter.common.dto.ResponceDto;
import com.callcenter.callcenter.pincode.dto.PinCodeDto;
import com.callcenter.callcenter.task.dto.TaskDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PinCodeService {
    PinCodeDto addPinCode(PinCodeDto pinCodeDto);
    List<PinCodeDto> getAllPinCodes();
    ResponceDto deletePinCode(Long id);
    PinCodeDto getPinCodeById(Long taskId);
    List<PinCodeDto> getAllPinCodeByUsername(String username);
}
