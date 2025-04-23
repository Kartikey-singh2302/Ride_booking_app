package com.KartikeySingh.project.UberApp.Uber_Cl.Entities;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.PaymentMethod;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.RideRequestStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
public class Ride {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(columnDefinition="Geometry(Point,4326)")
        private Point pickupLocation;
        @Column(columnDefinition = "Geometry(Point,4326)")
        private Point dropOffLocation;
        @CreationTimestamp
        private LocalDateTime createdTime;
        @ManyToOne(fetch = FetchType.LAZY)
        private Rider rider;
        @Enumerated(EnumType.STRING)
        private PaymentMethod paymentMethod;
        @Enumerated(EnumType.STRING)
        private RideRequestStatus rideStatus;
        private Double fare;
        private LocalDateTime startedAt;
        private LocalDateTime endedAt;

}
