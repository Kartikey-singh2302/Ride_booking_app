package com.KartikeySingh.project.UberApp.Uber_Cl.controller;

import com.KartikeySingh.project.UberApp.Uber_Cl.dto.RideRequestDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rider")
@RequiredArgsConstructor
public class RiderController {

    private final RiderService riderService;


    @PostMapping("/requestRide")
    public ResponseEntity<RideRequestDTO> requestRide(@RequestBody RideRequestDTO riderequestDTO)
    {
       return ResponseEntity.ok( riderService.requestRide(riderequestDTO));
    }

}
