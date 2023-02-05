package com.nagarjun.authorizationblog.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.nagarjun.authorizationblog.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{

    Optional<Role> findByName(String roleName);
}
