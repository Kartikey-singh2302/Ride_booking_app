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
<<<<<<< HEAD
    @JoinColumn(name = "user_id")
=======
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
>>>>>>> origin/master
    private Double rating;

    private Boolean available;

    private String vehicleId;
    private User user;

<<<<<<< HEAD
    @Column(columnDefinition = "Geometry(Point,4326)")//spatial refernce id (earth standard)
=======
    @Column(columnDefinition = "Geometry(Point,4326)")
>>>>>>> origin/master
    Point currentLocation;
}
