package com.KartikeySingh.project.UberApp.Uber_Cl.services.impl;


import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Driver;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.User;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.Role;
import com.KartikeySingh.project.UberApp.Uber_Cl.Security.JWTService;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.DriverDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.SignupDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.UserDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.exceptions.ResourceNotFoundException;
import com.KartikeySingh.project.UberApp.Uber_Cl.exceptions.RuntimeConflictExceptions;
import com.KartikeySingh.project.UberApp.Uber_Cl.repositories.UserRepository;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.AuthService;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.DriverService;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.RiderService;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.WalletService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.Role.DRIVER;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private  final RiderService riderService;
    private final WalletService walletService;
    private final DriverService driverService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
        private final JWTService jwtService;

    @Override
    public String refreshToken(String refreshToken) {
        Long userId = jwtService.getUserIdFromToken(refreshToken);
        User user = userRepository.findById(userId).orElseThrow
                (()->new ResourceNotFoundException("User not found with id"+userId));
        return jwtService.generateAccessToken(user);
    }

    @Override
        public String[] login(String email, String password) {
            String tokens[] = new String[2];
           Authentication authentication  = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );

           User user = (User) authentication.getPrincipal();

           String accessToken = jwtService.generateAccessToken(user);
           String refreshToken = jwtService.generateRefreshToken(user);

            return new String[]{accessToken, refreshToken};
        }

        @Override
        @Transactional
        public UserDTO signup(SignupDTO signupDTO) {
            User user = userRepository.findByEmail(signupDTO.getEmail()).orElse(null);
            if(user != null)
                throw new RuntimeConflictExceptions("Cannot signup, User already exists with email "+signupDTO.getEmail());

            User mappedUser = modelMapper.map(signupDTO, User.class);
            mappedUser.setRoles(Set.of(Role.RIDER));
            mappedUser.setPassword(passwordEncoder.encode(mappedUser.getPassword()));
            User savedUser = userRepository.save(mappedUser);

            // create user related entities
            riderService.createNewRider(savedUser);
            walletService.createNewWallet(savedUser);


            return modelMapper.map(savedUser, UserDTO.class);
        }

        @Override
        public DriverDTO onboardNewDriver(Long userId, String vehicleId )
        {
            User user = userRepository.findById(userId)
                    .orElseThrow(()-> new ResourceNotFoundException(" user not found with Id "+userId));

            if(user.getRoles().contains(DRIVER))
                throw new RuntimeConflictExceptions("user with id"+userId+"is already a driver");

            Driver createDriver =Driver.builder()
                    .user(user)
                    .rating(0.0)
                    .vehicleId(vehicleId)
                    .available(true)
                    .build();
            user.getRoles().add(DRIVER);
            userRepository.save(user);
            Driver savedDriver = driverService.createNewDriver(createDriver);
            return modelMapper.map(savedDriver, DriverDTO.class);
        }
    }


