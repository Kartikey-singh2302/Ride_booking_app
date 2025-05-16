package com.KartikeySingh.project.UberApp.Uber_Cl.services.impl;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.RideRequest;
import com.KartikeySingh.project.UberApp.Uber_Cl.exceptions.ResourceNotFoundException;
import com.KartikeySingh.project.UberApp.Uber_Cl.repositories.RideRequestRepository;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.RideRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideRequestServiceImpl implements RideRequestService {

   private final RideRequestRepository rideRequestRepository;
    @Override
    public RideRequest findRideRequestById(Long rideRequestId) {
        return rideRequestRepository.findById(rideRequestId).orElseThrow
                (()-> new ResourceNotFoundException("RideRequest Not found with id: "+rideRequestId));

    }

    @Override
    public void update(RideRequest rideRequest) {
         rideRequestRepository.findById(rideRequest.getId())
                .orElseThrow(()->new ResourceNotFoundException("RideRequest not found with id:"+rideRequest.getId()));
               rideRequestRepository.save(rideRequest);

    }
}
