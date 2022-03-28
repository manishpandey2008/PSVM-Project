package com.callcenter.callcenter.pincode.repo;

import com.callcenter.callcenter.pincode.model.PinCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PinCodeRepo extends JpaRepository<PinCode,Long> {
    Optional<List<PinCode>> findAllByUsername(String username);
}
