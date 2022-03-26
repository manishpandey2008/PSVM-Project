package com.callcenter.callcenter.common.service;


import com.callcenter.callcenter.center.repo.CenterRepo;
import com.callcenter.callcenter.chart.repo.ChartRepo;
import com.callcenter.callcenter.common.dto.CenterData;
import com.callcenter.callcenter.task.repo.TaskRepo;
import com.callcenter.callcenter.yojana.repo.YojanaRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommonSercvice {
    private final YojanaRepo yojanaRepo;
    private final CenterRepo centerRepo;
    private final TaskRepo taskRepo;
    private final ChartRepo chartRepo;

    public CenterData getCenterData(){
            CenterData centerData=new CenterData();
            centerData.setTotalCenter(centerRepo.count());
            centerData.setTotalChart(chartRepo.count());
            centerData.setTotalWorkList(taskRepo.count());
            centerData.setTotalYojana(yojanaRepo.count());
        return centerData;
    }
}
