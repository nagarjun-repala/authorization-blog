package com.nagarjun.authorizationblog.repository;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import com.nagarjun.authorizationblog.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

    Optional<User> findByUsername(String username);
    @Transactional
    void deleteUserByUsername(String username);
    
}
