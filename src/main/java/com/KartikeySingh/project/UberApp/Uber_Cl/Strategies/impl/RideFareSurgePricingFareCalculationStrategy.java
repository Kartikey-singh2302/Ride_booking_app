package com.KartikeySingh.project.UberApp.Uber_Cl.strategies.impl;

import com.KartikeySingh.project.UberApp.Uber_Cl.entities.RideRequest;
import com.KartikeySingh.project.UberApp.Uber_Cl.strategies.RideFareCalculationStrategy;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.DistanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {
    private final DistanceService distanceService;
    private static final Double SURGE_FACTOR= 2.0;

    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(),
                rideRequest.getDropOffLocation());
        return distance * RIDE_FARE_MULTIPLIER*SURGE_FACTOR;
    }
        }



