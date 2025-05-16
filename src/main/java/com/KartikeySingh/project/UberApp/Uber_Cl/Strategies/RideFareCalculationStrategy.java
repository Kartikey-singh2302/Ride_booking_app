package com.KartikeySingh.project.UberApp.Uber_Cl.Strategies;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.RideRequest;

public interface RideFareCalculationStrategy {

     double RIDE_FARE_MULTIPLIER = 10;

    double calculateFare(RideRequest rideRequest);

}
