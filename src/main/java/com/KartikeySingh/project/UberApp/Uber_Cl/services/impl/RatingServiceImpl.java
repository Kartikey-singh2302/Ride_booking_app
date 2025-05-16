package com.KartikeySingh.project.UberApp.Uber_Cl.services.impl;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Driver;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Rating;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Ride;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Rider;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.DriverDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.RiderDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.exceptions.ResourceNotFoundException;
import com.KartikeySingh.project.UberApp.Uber_Cl.repositories.DriverRepository;
import com.KartikeySingh.project.UberApp.Uber_Cl.repositories.RatingRepository;
import com.KartikeySingh.project.UberApp.Uber_Cl.repositories.RiderRepository;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.RatingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;
    private final DriverRepository driverRepository;
    private final RiderRepository riderRepository;
    private final ModelMapper modelMapper;

    @Override
    public DriverDTO rateDriver(Ride ride, Integer rating) {
        Driver driver = ride.getDriver();
        Rating ratingObj = ratingRepository.findByRide(ride).orElseThrow
                (()->new ResourceNotFoundException("Rating not found for ride with id:"+ride.getId()));

        if(ratingObj.getDriverRating()!=null)
            throw new RuntimeException("Driver has already been rated, cannot rate again");

        ratingObj.setDriverRating(rating);

        ratingRepository.save(ratingObj);

        Double newRating = ratingRepository.findByDriver(driver)
                .stream()
                .mapToDouble(Rating::getDriverRating)
                .average().orElse(0.0);
        driver.setRating(newRating);

       Driver savedDriver =  driverRepository.save(driver);
       return modelMapper.map(savedDriver,DriverDTO.class);
    }

    @Override
    public RiderDTO rateRider(Ride ride, Integer rating) {
        Rider rider = ride.getRider();
        Rating ratingObj = ratingRepository.findByRide(ride).orElseThrow
                (()->new ResourceNotFoundException("Rating not found for ride with id:"+ride.getId()));
        if(ratingObj.getRiderRating()!=null)
            throw new RuntimeException("Rider has already been rated, cannot rate again");

        ratingObj.setDriverRating(rating);
        ratingRepository.save(ratingObj);

        ratingObj.setDriverRating(rating);
        ratingRepository.save(ratingObj);

        Double newRating = ratingRepository.findByRider(rider)
                .stream()
                .mapToDouble(Rating::getDriverRating)
                .average().orElse(0.0);
        rider.setRating(newRating);
        Rider savedRider = riderRepository.save(rider);
        return modelMapper.map(savedRider, RiderDTO.class);
    }

    @Override
    public void createNewRating(Ride ride) {
        Rating rating = Rating.builder()
                .rider(ride.getRider())
                .driver(ride.getDriver())
                .ride(ride)
                .build();
        ratingRepository.save(rating);
    }
}
