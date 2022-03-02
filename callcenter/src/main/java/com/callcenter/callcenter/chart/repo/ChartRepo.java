package com.callcenter.callcenter.chart.repo;

import com.callcenter.callcenter.chart.entity.Chart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChartRepo extends JpaRepository<Chart,Long> {
    List<Chart> findAllByCenterId(Long centerId);
}
