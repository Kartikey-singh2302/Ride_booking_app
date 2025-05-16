package com.KartikeySingh.project.UberApp.Uber_Cl.Entities;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.PaymentMethod;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.RideRequestStatus;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.RideStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(indexes = {
        @Index(name = "idx_ride_rider",columnList = "rider_id"),
        @Index(name = "idx_ride_driver",columnList = "driver_id")

})
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
        private String otp;
        private Driver driver;
        @Enumerated(EnumType.STRING)
        private PaymentMethod paymentMethod;
        @Enumerated(EnumType.STRING)
        private RideStatus rideStatus;
        private Double fare;
        private LocalDateTime startedAt;
        private LocalDateTime endedAt;
}
