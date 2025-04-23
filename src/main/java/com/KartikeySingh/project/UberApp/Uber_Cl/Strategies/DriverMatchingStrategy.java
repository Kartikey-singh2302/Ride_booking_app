package com.KartikeySingh.project.UberApp.Uber_Cl.Strategies;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Driver;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {
    static List<Driver> findMatchingDriver(RideRequest rideRequest) {

        return List.of();
    }

    //List<Driver> findMatchingDriver(RideRequest rideRequest);

}
