package com.KartikeySingh.project.UberApp.Uber_Cl.strategies;

import com.KartikeySingh.project.UberApp.Uber_Cl.entities.Driver;
import com.KartikeySingh.project.UberApp.Uber_Cl.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {
      List<Driver> findMatchingDriver(RideRequest rideRequest);




}
