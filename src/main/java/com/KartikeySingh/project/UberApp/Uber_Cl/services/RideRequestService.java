package com.KartikeySingh.project.UberApp.Uber_Cl.services;

import com.KartikeySingh.project.UberApp.Uber_Cl.entities.RideRequest;

public interface RideRequestService {

    RideRequest findRideRequestById(Long rideRequestId);

    void update(RideRequest rideRequest);
}
