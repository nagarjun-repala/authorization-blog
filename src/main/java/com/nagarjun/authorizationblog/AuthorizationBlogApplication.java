package com.nagarjun.authorizationblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import com.nagarjun.authorizationblog.repository.RoleRepository;
import com.nagarjun.authorizationblog.entity.Role;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class AuthorizationBlogApplication implements CommandLineRunner{

	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationBlogApplication.class, args);
	}

	@Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Override
	public void run(String... args) throws Exception {
		roleRepository.save(new Role("ADMIN"));
		roleRepository.save(new Role("USER"));
	}

}
