package com.KartikeySingh.project.UberApp.Uber_Cl.services;

import com.KartikeySingh.project.UberApp.Uber_Cl.dto.DriverDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.RideDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.RiderDTO;

import java.util.List;

public interface DriverService {
   RideDTO acceptRide(Long rideId);
    RideDTO cancelRide(Long RideId);
   RideDTO startRide(Long RideId);
   RideDTO endRide(Long rideId);
   RiderDTO rateRider(Long rideId,Integer rating);
   DriverDTO getMyProfile();
   List<RideDTO> getAllMyRides();
}
