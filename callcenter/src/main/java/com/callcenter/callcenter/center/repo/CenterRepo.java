package com.callcenter.callcenter.center.repo;

import com.callcenter.callcenter.center.dto.CenterDto;
import com.callcenter.callcenter.center.entity.CenterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CenterRepo extends JpaRepository<CenterEntity,Long> {

    List<CenterEntity> findAllByCenterState(String centerStateName);

    List<CenterEntity> findAllByCenterDistrict(String centerDistrictName);
}
