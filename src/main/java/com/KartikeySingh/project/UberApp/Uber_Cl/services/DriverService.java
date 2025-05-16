package com.KartikeySingh.project.UberApp.Uber_Cl.services;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Driver;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.DriverDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.RideDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.RiderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface DriverService {

   RideDTO acceptRide(Long rideRequestId);
    RideDTO cancelRide(Long RideId);
   RideDTO startRide(Long RideId,String otp);
   RideDTO endRide(Long rideId);
   RiderDTO rateRider(Long rideId,Integer rating);
   DriverDTO getMyProfile();
   Page<RideDTO> getAllMyRides(PageRequest pageRequest);

   Driver getCurrentDriver();
   Driver updateDriverAvailability(Driver driver,boolean available);
   Driver createNewDriver(Driver driver);
}
