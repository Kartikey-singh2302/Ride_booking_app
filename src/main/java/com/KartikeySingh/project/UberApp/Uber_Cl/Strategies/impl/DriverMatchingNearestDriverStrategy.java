package com.KartikeySingh.project.UberApp.Uber_Cl.strategies.impl;

import com.KartikeySingh.project.UberApp.Uber_Cl.entities.Driver;
import com.KartikeySingh.project.UberApp.Uber_Cl.entities.RideRequest;
import com.KartikeySingh.project.UberApp.Uber_Cl.strategies.DriverMatchingStrategy;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional

public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {

    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return List.of();
    }
}
