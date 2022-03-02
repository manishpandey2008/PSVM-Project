package com.callcenter.callcenter.task.service;

import com.callcenter.callcenter.chart.dto.ChartDto;
import com.callcenter.callcenter.common.dto.ResponceDto;
import com.callcenter.callcenter.task.dto.TaskDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    TaskDto addTask(TaskDto taskDto);
    List<TaskDto> getAllTasks();
    ResponceDto deleteTask(Long id);
    TaskDto getTaskById(Long taskId);
    List<TaskDto> getAllTasksByChart(Long chartId);
}
