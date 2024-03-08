package com.in.instore.repository;

import com.in.instore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);

    Optional<User> findByMobileNumber(String mobileNumber);

    Optional<User> findByEmail(String email);

    Boolean existsByUserName(String userName);

    Boolean existsByMobileNumber(String mobileNumber);

    Boolean existsByEmail(String email);


    Optional<User> findByUserNameOrEmail(String username, String email);

//    Boolean existsByEmail(String email);

//    Boolean existsByUsername(String username);
}
