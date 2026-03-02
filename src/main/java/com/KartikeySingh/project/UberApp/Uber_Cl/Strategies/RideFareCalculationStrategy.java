package com.KartikeySingh.project.UberApp.Uber_Cl.strategies;

import com.KartikeySingh.project.UberApp.Uber_Cl.entities.RideRequest;

public interface RideFareCalculationStrategy {

     double RIDE_FARE_MULTIPLIER = 10;

    double calculateFare(RideRequest rideRequest);

}
