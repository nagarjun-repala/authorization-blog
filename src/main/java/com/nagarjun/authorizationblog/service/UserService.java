package com.nagarjun.authorizationblog.service;

import com.nagarjun.authorizationblog.entity.User;

public interface UserService {

    User getUser(Long userId);
    User getUser(String username);
    User createUser(User user);
    
}
