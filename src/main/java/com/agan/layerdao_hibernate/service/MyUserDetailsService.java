package com.agan.layerdao_hibernate.service;

import com.agan.layerdao_hibernate.config.MyUserDetails;
import com.agan.layerdao_hibernate.dao.MyUserDAO;
import com.agan.layerdao_hibernate.entity.MyUser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final MyUserDAO myUserDAO;

    @Override
    public UserDetails loadUserByUsername(String loginPhoneNumber) throws UsernameNotFoundException {

        Optional<MyUser> myUser = myUserDAO.findByLoginPhoneNumber(loginPhoneNumber);

        return myUser
                .map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(loginPhoneNumber + " not found!"));
    }
}
