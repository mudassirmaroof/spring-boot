package com.learning.service;

import com.learning.model.entity.User;
import com.learning.model.repository.UserRepository;
import com.learning.model.repository.UserRoleRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Collection;

/**
 * Created by mudassir on 21/02/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public UserServiceImpl(UserRepository userRepository,
                           UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException("Username " + username + " not found");
        }

        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), getGrantedAuthorities(username));
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthorities(String username) {
        return userRoleRepository.findRoleByUsername(username);
    }
}