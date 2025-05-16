package com.KartikeySingh.project.UberApp.Uber_Cl.dto;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.PaymentMethod;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.RideRequestStatus;
import lombok.Data;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;
@Data

public class RideDTO {
        private Long id;
        private PointDTO pickupLocation;
        private PointDTO dropOffLocation;
        private LocalDateTime createdTime;
        private RiderDTO rider;
        private DriverDTO driver;
        private PaymentMethod paymentMethod;
        private RideRequestStatus rideStatus;
        private String OTP;
        private Double fare;
        private LocalDateTime startedAt;
        private LocalDateTime endedAt;
}
