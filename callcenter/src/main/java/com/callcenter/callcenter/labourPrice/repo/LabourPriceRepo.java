package com.callcenter.callcenter.labourPrice.repo;

import com.callcenter.callcenter.labourPrice.model.LabourPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LabourPriceRepo extends JpaRepository<LabourPrice,Long> {
    Optional<List<LabourPrice>> findAllByUsername(String username);
}
