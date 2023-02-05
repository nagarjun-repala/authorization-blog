package com.nagarjun.authorizationblog.service;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.nagarjun.authorizationblog.GlobalMethods;
import com.nagarjun.authorizationblog.entity.Role;
import com.nagarjun.authorizationblog.entity.User;
import com.nagarjun.authorizationblog.exception.UserNotFoundException;
import com.nagarjun.authorizationblog.repository.RoleRepository;
import com.nagarjun.authorizationblog.repository.UserRepository;
import com.nagarjun.authorizationblog.security.SecurityConstants;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public User getUser(Long userId) {

        Optional<User> userEntity = userRepository.findById(userId);
        if(userEntity.isEmpty()) throw new UserNotFoundException(userId);
        return userEntity.get();
    }

    @Override
    public User getUser(String username) {

        Optional<User> userEntity = userRepository.findByUsername(username);
        if(userEntity.isEmpty()) throw new UserNotFoundException(username);
        return userEntity.get();
    }

    @Override
    public User createUser(User user) {
        
        Role role = roleRepository.findById(SecurityConstants.DEFAULT_ROLE).get();    
        user.setCreatedOn(GlobalMethods.dateTimeFormatter(LocalDateTime.now()));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        role.getUsers().add(user);
        User savedUser = userRepository.save(user);
        roleRepository.save(role);
        return savedUser;

    }

}
