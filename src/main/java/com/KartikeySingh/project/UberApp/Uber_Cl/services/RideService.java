package com.KartikeySingh.project.UberApp.Uber_Cl.services;

import com.KartikeySingh.project.UberApp.Uber_Cl.entities.Driver;
import com.KartikeySingh.project.UberApp.Uber_Cl.entities.Ride;
import com.KartikeySingh.project.UberApp.Uber_Cl.entities.RideRequest;
import com.KartikeySingh.project.UberApp.Uber_Cl.entities.Rider;
import com.KartikeySingh.project.UberApp.Uber_Cl.entities.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {
    Ride getRideById(Long rideId);

    Ride createNewRide(RideRequest rideRequest, Driver driver);

    Ride updateRideStatus(Ride ride, RideStatus rideStatus);

    Page<Ride> getAllRidesOfRider(Rider rider , PageRequest pageRequest);

    Page<Ride> getAllRidesOfDriver(Driver driver,PageRequest pageRequest);

}
