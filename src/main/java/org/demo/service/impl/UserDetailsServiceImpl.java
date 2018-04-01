package org.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.demo.service.UserBusinessService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserBusinessService applicationUserRepository;

    public UserDetailsServiceImpl(UserBusinessService applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        org.demo.entity.User applicationUser = applicationUserRepository.getUser(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        List<GrantedAuthority> authorityList = new ArrayList<>();
        SimpleGrantedAuthority authority= new SimpleGrantedAuthority("ACTUATOR");
        authorityList.add(authority);
        return new User(applicationUser.getUserName(), applicationUser.getPassword(), authorityList);
    }
}