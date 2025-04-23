package com.KartikeySingh.project.UberApp.Uber_Cl.Strategies.impl;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.RideRequest;
import com.KartikeySingh.project.UberApp.Uber_Cl.Strategies.RideFareCalculationStrategy;
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


