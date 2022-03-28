package com.resolved.userservice.repo;

import com.resolved.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByUserPhone(String phone);

    Optional<User> findByUserEmail(String email);

    Optional<User> findByActivateCode(String activationCode);

//    @Query(value = "insert into pin_code(active_status, pin_code, post_office, username, village) values (:active_status, :pin_code, :post_office, :username,:village)")
//    void addPincode(@Param("active_status") String active_status, @Param("pin_code") String pin_code,
//                    @Param("post_office") String post_office, @Param("username") String username,
//                    @Param("village") String village);

//
//    Optional<List<User>> findByOrganizationCodeEquals(String organizationCode);
//
//    Optional<List<User>> findByDepartmentCodeEquals(String departmentCode);
}
