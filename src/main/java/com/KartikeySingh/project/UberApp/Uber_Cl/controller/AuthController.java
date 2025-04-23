package com.KartikeySingh.project.UberApp.Uber_Cl.controller;

import com.KartikeySingh.project.UberApp.Uber_Cl.dto.SignupDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.UserDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping("/sign")
    UserDTO signup(@RequestBody SignupDTO signupDTO)
    {
        return authService.signup(signupDTO);
    }



}
