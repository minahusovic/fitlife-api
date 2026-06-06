package com.it355.fitlife_api;

import com.it355.fitlife_api.entity.Role;
import com.it355.fitlife_api.entity.User;
import com.it355.fitlife_api.repository.RoleRepository;
import com.it355.fitlife_api.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(RoleRepository roleRepository,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseGet(() -> roleRepository.save(new Role("ROLE_USER")));

        Role adminRole = roleRepository.findByName("ROLE_ADMIN")
                .orElseGet(() -> roleRepository.save(new Role("ROLE_ADMIN")));

        if (!userRepository.existsByEmail("admin@fitlife.com")) {
            User admin = new User(
                    "Admin",
                    "FitLife",
                    "admin@fitlife.com",
                    passwordEncoder.encode("admin123"),
                    30,
                    180.0,
                    80.0
            );

            admin.setRoles(Set.of(adminRole));
            userRepository.save(admin);
        }
    }
}