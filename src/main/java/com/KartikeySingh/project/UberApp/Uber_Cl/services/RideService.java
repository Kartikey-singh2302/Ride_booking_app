package com.KartikeySingh.project.UberApp.Uber_Cl.services;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Driver;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Ride;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.RideRequestStatus;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.RideRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {
    Ride getRideById(Long rideId);

    void matchWithDrivers(RideRequestDTO rideRequestDto);

    Ride createNewRide(RideRequestDTO rideRequestDto, Driver driver);

    Ride updateRideStatus(Long rideId, RideRequestStatus rideStatus);

    Page<Ride> getAllRidesOfRider(Long riderId, PageRequest pageRequest);

    Page<Ride> getAllRidesOfDriver(Long driverId,PageRequest pageRequest);

}
