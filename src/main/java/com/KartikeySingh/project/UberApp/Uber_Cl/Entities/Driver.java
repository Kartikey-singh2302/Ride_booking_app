package com.KartikeySingh.project.UberApp.Uber_Cl.entities;

import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.Point;

import java.io.Serializable;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(indexes = {
        @Index( name = "idx_driver_vehicle_id", columnList = "vehicleId")
})
public class Driver implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "user_id")
    private Double rating;

    private Boolean available;

    private String vehicleId;
    private User user;

    @Column(columnDefinition = "Geometry(Point,4326)")
    Point currentLocation;
}
