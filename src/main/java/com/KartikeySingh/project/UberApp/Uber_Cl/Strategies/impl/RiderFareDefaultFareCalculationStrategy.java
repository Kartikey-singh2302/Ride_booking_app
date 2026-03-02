package com.KartikeySingh.project.UberApp.Uber_Cl.strategies.impl;

import com.KartikeySingh.project.UberApp.Uber_Cl.entities.RideRequest;
import com.KartikeySingh.project.UberApp.Uber_Cl.strategies.RideFareCalculationStrategy;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.DistanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
    @Service
    public class RiderFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {

        private final DistanceService distanceService;

        @Override
        public double calculateFare(RideRequest rideRequest) {
            double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(),
                    rideRequest.getDropOffLocation());
            return distance * RIDE_FARE_MULTIPLIER;
        }
    }


