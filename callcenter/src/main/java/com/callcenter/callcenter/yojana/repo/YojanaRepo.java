package com.callcenter.callcenter.yojana.repo;

import com.callcenter.callcenter.yojana.entity.Yojana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YojanaRepo extends JpaRepository<Yojana,Long> {

       List<Yojana> findAllByCenterId(Long id);
}
