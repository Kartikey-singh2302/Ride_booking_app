package com.KartikeySingh.project.UberApp.Uber_Cl.services;

import com.KartikeySingh.project.UberApp.Uber_Cl.dto.DriverDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.SignupDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.UserDTO;

public interface AuthService {
    String  login(String email,String password);
     UserDTO signup(SignupDTO signupdto);
     DriverDTO onboardNewDriver(Long userId);
}
