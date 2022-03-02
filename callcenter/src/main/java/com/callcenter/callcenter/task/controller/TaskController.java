package com.callcenter.callcenter.task.controller;

import com.callcenter.callcenter.common.dto.ResponceDto;
import com.callcenter.callcenter.task.dto.TaskDto;
import com.callcenter.callcenter.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/task")
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/")
    public ResponseEntity<TaskDto> addTask(@RequestBody TaskDto taskDto) {
        log.info("Add new task {}",taskDto.getTaskName());
        return ResponseEntity.ok().body(taskService.addTask(taskDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        log.info("Get all tasks");
        return ResponseEntity.ok().body(taskService.getAllTasks());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponceDto> deleteTask(@PathVariable Long id) {
        log.info("Delete task which id is {}",id);
        return ResponseEntity.ok().body(taskService.deleteTask(id));
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long taskId) {
        log.info("Get chart which id is {}",taskId);
        return ResponseEntity.ok().body(taskService.getTaskById(taskId));
    }

    @GetMapping("/chart/{chartId}")
    public ResponseEntity<List<TaskDto>> getAllTasksByChart(@PathVariable Long chartId) {
        log.info("Get all tasks by chart which chart id is {}",chartId);
        return ResponseEntity.ok().body(taskService.getAllTasksByChart(chartId));
    }
}
