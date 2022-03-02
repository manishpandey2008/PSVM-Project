package com.callcenter.callcenter.task.service;

import com.callcenter.callcenter.common.dto.ResponceDto;
import com.callcenter.callcenter.common.service.ModelMapper;
import com.callcenter.callcenter.task.dto.TaskDto;
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
public class TaskServiceImp implements TaskService{

    private final TaskRepo taskRepo;
    private final ModelMapper modelMapper;

    @Override
    public TaskDto addTask(TaskDto taskDto) {
        try{
            TaskEntity taskEntity=modelMapper.map(taskDto,TaskEntity.class);
            taskEntity.setCreatedTime(new Date());
            taskEntity.setUpdatedTime(new Date());
            return modelMapper.map(taskRepo.save(taskEntity),TaskDto.class);
        }catch(Exception ex){
            log.info("Error: add new task error is {}",ex.getMessage());
            return null;
        }
    }

    @Override
    public List<TaskDto> getAllTasks() {
        try{
            return this.conversion(taskRepo.findAll());
        }catch(Exception ex){
            log.info("Error: find all tasks error is {}",ex.getMessage());
            return null;
        }
    }

    @Override
    public ResponceDto deleteTask(Long id) {
        try{
            taskRepo.deleteById(id);
            return new ResponceDto("Delete Successfully.......!!", HttpStatus.OK);
        }catch(Exception ex){
            log.info("Error: Delete task error is {}",ex.getMessage());
            return null;
        }
    }

    @Override
    public TaskDto getTaskById(Long taskId) {
        try{
            return modelMapper.map(taskRepo.findById(taskId),TaskDto.class);
        }catch(Exception ex){
            log.info("Error: Get task by task id error is {}",ex.getMessage());
            return null;
        }
    }

    @Override
    public List<TaskDto> getAllTasksByChart(Long chartId) {
        try{
            return this.conversion(taskRepo.findAllByChartId(chartId));
        }catch(Exception ex){
            log.info("Error: Get all tasks by chart id error is {}",ex.getMessage());
            return null;
        }
    }

    public List<TaskDto> conversion(List<TaskEntity> list ){
        List<TaskDto> result=new LinkedList<>();
        for(TaskEntity taskEntity:list){
            result.add( modelMapper.map(taskEntity,TaskDto.class));
        }
        return result;
    }
}
