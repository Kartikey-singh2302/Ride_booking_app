package com.KartikeySingh.project.UberApp.Uber_Cl.services.impl;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.*;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.RideRequestStatus;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.RideStatus;
import com.KartikeySingh.project.UberApp.Uber_Cl.Strategies.DriverMatchingStrategy;
import com.KartikeySingh.project.UberApp.Uber_Cl.Strategies.impl.RideStrategyManager;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.DriverDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.RideDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.RideRequestDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.RiderDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.exceptions.ResourceNotFoundException;
import com.KartikeySingh.project.UberApp.Uber_Cl.repositories.DriverRepository;
import com.KartikeySingh.project.UberApp.Uber_Cl.repositories.RideRequestRepository;
import com.KartikeySingh.project.UberApp.Uber_Cl.repositories.RiderRepository;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.DriverService;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.RatingService;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.RideService;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.RiderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class RiderServiceImpl implements RiderService {

        private final ModelMapper modelMapper;
        private final RideStrategyManager rideStrategyManager;
        private final DriverMatchingStrategy driverMatchingStrategy;
        private final RideRequestRepository rideRequestRepository;
        private final RiderRepository  riderRepository;
        private final RiderService riderService;
        private final RideService rideService;
        private final DriverRepository driverRepository;
        private final DriverService driverService;
        private final RatingService ratingService;

        @Override
        @Transactional
        public RideRequestDTO requestRide(RideRequestDTO rideRequestDTO) {
            Rider rider=getCurrentRider();
            RideRequest rideRequest = modelMapper.map(rideRequestDTO, RideRequest.class);
            rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
            rideRequest.setRider(rider);

            Double fare = rideStrategyManager.rideFareCalculationStrategy().calculateFare(rideRequest);
            rideRequest.setFare(fare);

            RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);

            List<Driver>drivers = rideStrategyManager.driverMatchingStrategy(rider.getRating()).findMatchingDriver(rideRequest);

            return modelMapper.map(savedRideRequest, RideRequestDTO.class);
        }

        @Override
        public RideDTO cancelRide(Long rideId) {
            Rider rider = getCurrentRider();
            Ride ride = riderService.getRideById(rideId);

            if(!rider.equals(ride.getRider()))
            {
                throw new RuntimeException("Rider does not own this ride with id: "+rideId);
            }

            if(!ride.getRideStatus().equals(RideStatus.CONFIRMED))
            {
                throw new RuntimeException("Ride cannot be cancelled ,invalid status:"+ride.getRideStatus());
            }

            Ride savedride = rideService.updateRideStatus(ride,RideStatus.CANCELLED);
            driverService.updateDriverAvailability(ride.getDriver(),true);

            return modelMapper.map(savedride,RideDTO.class);
        }

    @Override
    public DriverDTO rateDriver(Long rideId, Integer rating) {
          Ride ride = riderService.getRideById(rideId);
        Rider rider = getCurrentRider();

        if(!rider.equals(ride.getRider()))
        {
            throw new RuntimeException("Rider is not the owner of this ride");
        }

        if(!ride.getRideStatus().equals(RideStatus.ENDED))
        {
            throw new RuntimeException("Ride status is not ended hence cannot start rating, status:"+ride.getRideStatus());
        }
        return ratingService.rateDriver(ride, rating);
    }


    @Override
    public RiderDTO getMyProfile() {
        Rider currentRider = getCurrentRider();
        return modelMapper.map(currentRider, RiderDTO.class);

    }


    @Override
    public Page<RideDTO> getAllMyRides(PageRequest pageRequest) {
        Rider currentRider = getCurrentRider();
        return rideService.getAllRidesOfRider(currentRider,pageRequest).map(
                ride->modelMapper.map(ride,RideDTO.class)
        );
    }

    @Override
    public Rider createNewRider(User user) {
        Rider rider =Rider
                .builder()
                .user(user)
                .rating(0.0)
                .build();
        return riderRepository.save(rider);

    }

    @Override
    public Rider getCurrentRider() {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return riderRepository.findByUser(user).orElseThrow(()-> new ResourceNotFoundException(
                "Rider not associated with user with id: "+user.getId()
        ));
    }

    @Override
    public Ride getRideById(Long rideId) {
        return null;
    }
}
