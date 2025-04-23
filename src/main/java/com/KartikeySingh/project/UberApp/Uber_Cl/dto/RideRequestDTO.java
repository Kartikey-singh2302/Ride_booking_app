package com.KartikeySingh.project.UberApp.Uber_Cl.dto;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.PaymentMethod;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.RideRequestStatus;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;
public class RideRequestDTO {

        private Long id;

        private Point pickupLocation;

        private Point dropOffLocation;

        private LocalDateTime requestedTime;

        private RiderDTO rider;

        private PaymentMethod paymentMethod;

        private RideRequestStatus rideRequestStatus;



}
