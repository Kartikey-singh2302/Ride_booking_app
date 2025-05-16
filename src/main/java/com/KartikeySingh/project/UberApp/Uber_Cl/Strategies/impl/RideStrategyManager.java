package com.KartikeySingh.project.UberApp.Uber_Cl.Strategies.impl;

import com.KartikeySingh.project.UberApp.Uber_Cl.Strategies.DriverMatchingStrategy;
import com.KartikeySingh.project.UberApp.Uber_Cl.Strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@RequiredArgsConstructor
@Component
public class RideStrategyManager {

    private final DriverMatchingHighestRatedDriverStrategy highestRatedDriverStrategy;
    private final DriverMatchingNearestDriverStrategy nearestDriverStrategy;
    private final RideFareSurgePricingFareCalculationStrategy surgePricingFareCalculationStrategy;
    private final RiderFareDefaultFareCalculationStrategy defaultFareCalculationStrategy;


    public DriverMatchingStrategy driverMatchingStrategy(double riderRating){

        if(riderRating>=4.8)
        {
            return highestRatedDriverStrategy;
        }
        else
        {
            return nearestDriverStrategy;
        }

    }
    public RideFareCalculationStrategy rideFareCalculationStrategy() {

        //6pm to 9pm is SURGE PRICING TIME
        LocalTime surgeStartTime = LocalTime.of(18,0);
        LocalTime surgeEndTime = LocalTime.of(21,0);
        LocalTime currentTime =LocalTime.now();

        boolean isSurgeTime= currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);
                if(isSurgeTime)
                {
                    return surgePricingFareCalculationStrategy;
                }
                else
                {
                    return defaultFareCalculationStrategy;
                }
    }

}
