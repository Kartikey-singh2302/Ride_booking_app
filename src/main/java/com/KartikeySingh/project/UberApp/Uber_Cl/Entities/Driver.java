package com.KartikeySingh.project.UberApp.Uber_Cl.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.Point;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(indexes = {
        @Index( name = "idx_driver_vehicle_id", columnList = "vehicleId")
})
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
    private Double rating;

    private Boolean available;

    private String vehicleId;

    @Column(columnDefinition = "Geometry(Point,4326)")
    Point currentLocation;
}
