package com.KartikeySingh.project.UberApp.Uber_Cl.Strategies;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.RideRequest;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.RideRequestDTO;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

public interface RideFareCalculationStrategy {

     double RIDE_FARE_MULTIPLIER = 10;

    @Contract(pure = true)
    static @Nullable Double CalculateFare(RideRequest rideRequest)
    {
        return null;
    };




    double calculateFare(RideRequest rideRequest);

}
