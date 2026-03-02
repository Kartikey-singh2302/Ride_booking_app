package com.KartikeySingh.project.UberApp.Uber_Cl.entities;

import com.KartikeySingh.project.UberApp.Uber_Cl.entities.enums.PaymentMethod;
import com.KartikeySingh.project.UberApp.Uber_Cl.entities.enums.RideRequestStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.awt.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(indexes = {
        @Index(name = "idx_ride_request_rider", columnList = "rider_id")
})
public class RideRequest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition="Geometry(Point,4326)")
    private Point pickupLocation;

    @Column(columnDefinition = "Geometry(Point,4326)")
    private Point dropOffLocation;

    @CreationTimestamp
    private LocalDateTime requestedTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Rider rider;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private RideRequestStatus rideRequestStatus;

    private Double fare;

}
