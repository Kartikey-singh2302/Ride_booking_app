package com.KartikeySingh.project.UberApp.Uber_Cl.Strategies.impl;


import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Driver;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.RideRequest;
import com.KartikeySingh.project.UberApp.Uber_Cl.Strategies.DriverMatchingStrategy;
import com.KartikeySingh.project.UberApp.Uber_Cl.repositories.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    @RequiredArgsConstructor
    public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {

        private final DriverRepository driverRepository;

        @Override
        public List<Driver> findMatchingDriver(RideRequest rideRequest) {
            return driverRepository.findTenNearestDrivers(rideRequest.getPickupLocation());
        }
    }


