package com.KartikeySingh.project.UberApp.Uber_Cl.services;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Driver;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Ride;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Rider;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.DriverDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.RiderDTO;

public interface RatingService {

    DriverDTO rateDriver(Ride ride, Integer rating);
    RiderDTO rateRider(Ride ride, Integer rating);
    void createNewRating(Ride ride);
}
