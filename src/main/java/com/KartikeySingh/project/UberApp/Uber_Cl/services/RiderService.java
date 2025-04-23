package com.KartikeySingh.project.UberApp.Uber_Cl.services;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Rider;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.User;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.RideDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.RiderDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.RideRequestDTO;

import java.util.List;
public interface RiderService {

    RideRequestDTO requestRide(RideRequestDTO riderequestDTO);


    RideDTO cancelRide(Long rideId);

    RiderDTO rateRider(Long rideId, Integer rating);

    RiderDTO getMyProfile();

    List<RideDTO> getAllMyRides();

    Rider createNewRider(User user);

}
