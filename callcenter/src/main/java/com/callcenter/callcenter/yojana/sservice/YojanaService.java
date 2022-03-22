package com.callcenter.callcenter.yojana.sservice;

import com.callcenter.callcenter.common.dto.ResponceDto;
import com.callcenter.callcenter.task.dto.TaskDto;
import com.callcenter.callcenter.yojana.dto.YojanaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface YojanaService {
    YojanaDto addYojana(YojanaDto yojanaDto);
    List<YojanaDto> getAllYojanas();
    ResponceDto deleteYojana(Long id);
    YojanaDto getYojanaById(Long yojanaId);
    List<YojanaDto> getAllYojanaByCenterId(Long centerId);
}
