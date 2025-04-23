package com.KartikeySingh.project.UberApp.Uber_Cl.services.impl;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.RideRequest;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Rider;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.User;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.RideRequestStatus;
import com.KartikeySingh.project.UberApp.Uber_Cl.Strategies.DriverMatchingStrategy;
import com.KartikeySingh.project.UberApp.Uber_Cl.Strategies.RideFareCalculationStrategy;
import com.KartikeySingh.project.UberApp.Uber_Cl.Strategies.impl.RideStrategyManager;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.RideDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.RideRequestDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.RiderDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.repositories.RideRequestRepository;
import com.KartikeySingh.project.UberApp.Uber_Cl.repositories.RiderRepository;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.RiderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.KartikeySingh.project.UberApp.Uber_Cl.Strategies.DriverMatchingStrategy.findMatchingDriver;
import static com.KartikeySingh.project.UberApp.Uber_Cl.Strategies.RideFareCalculationStrategy.CalculateFare;


@Service
@RequiredArgsConstructor
@Slf4j

public class RiderServiceImpl implements RiderService {

        private final ModelMapper modelMapper;
        private final RideStrategyManager rideStrategyManager;
        private final RideRequestRepository rideRequestRepository;
        private final RiderRepository  riderRepository;

        @Override
        public RideRequestDTO requestRide(RideRequestDTO rideRequestDto) {
            RideRequest rideRequest = modelMapper.map(rideRequestDto, RideRequest.class);
            rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);

            Double fare = rideStrategyManager.rideFareCalculationStrategy().CalculateFare(rideRequest);
            rideRequest.setFare(fare);

            RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);

            rideStrategyManager.driverMatchingStrategy().findMatchingDriver(rideRequest);

            return modelMapper.map(savedRideRequest, RideRequestDTO.class);
        }

        @Override
        public RideDTO cancelRide(Long rideId) {
            return null;
        }

    @Override
    public RiderDTO rateRider(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public RiderDTO getMyProfile() {
        return null;
    }

    @Override
    public List<RideDTO> getAllMyRides() {
        return List.of();
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
        return null;
    }

    public Rider getcurrentRider()
    {
        return null;
}

}
