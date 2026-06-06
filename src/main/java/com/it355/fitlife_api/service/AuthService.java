package com.it355.fitlife_api.service;

import com.it355.fitlife_api.dto.AuthResponse;
import com.it355.fitlife_api.dto.LoginRequest;
import com.it355.fitlife_api.dto.RegisterRequest;
import com.it355.fitlife_api.entity.Role;
import com.it355.fitlife_api.entity.User;
import com.it355.fitlife_api.repository.RoleRepository;
import com.it355.fitlife_api.repository.UserRepository;
import com.it355.fitlife_api.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager,
                       JwtService jwtService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Transactional
    public AuthResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email je već registrovan.");
        }

        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("ROLE_USER ne postoji."));

        User user = new User(
                request.getIme(),
                request.getPrezime(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                request.getGodine(),
                request.getVisina(),
                request.getTezina()
        );

        user.setRoles(Set.of(userRole));

        User savedUser = userRepository.save(user);

        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(savedUser.getEmail())
                .password(savedUser.getPassword())
                .authorities("ROLE_USER")
                .build();

        String token = jwtService.generateToken(userDetails);

        return new AuthResponse(token, savedUser.getEmail(), "ROLE_USER");
    }

    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Korisnik nije pronađen."));

        String role = user.getRoles()
                .stream()
                .findFirst()
                .map(Role::getName)
                .orElse("ROLE_USER");

        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities(role)
                .build();

        String token = jwtService.generateToken(userDetails);

        return new AuthResponse(token, user.getEmail(), role);
    }
}