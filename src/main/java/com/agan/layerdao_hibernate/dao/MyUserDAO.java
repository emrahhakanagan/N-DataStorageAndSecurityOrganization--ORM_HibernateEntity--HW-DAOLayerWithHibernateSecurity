package com.agan.layerdao_hibernate.dao;

import com.agan.layerdao_hibernate.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MyUserDAO extends JpaRepository<MyUser, Long> {

    Optional<MyUser> findByLoginPhoneNumber(String loginPhoneNumber);

}
