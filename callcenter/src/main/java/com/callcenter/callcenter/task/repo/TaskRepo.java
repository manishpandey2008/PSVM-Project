package com.callcenter.callcenter.task.repo;

import com.callcenter.callcenter.task.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<TaskEntity,Long> {
    List<TaskEntity> findAllByChartId(Long chartId);
}
