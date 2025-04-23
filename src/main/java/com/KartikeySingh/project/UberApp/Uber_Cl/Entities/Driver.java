package com.KartikeySingh.project.UberApp.Uber_Cl.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

@Entity
@Getter
@Setter
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name="user_id") //--->The @JoinColumn annotation in JPA (Java Persistence API) is used to specify the foreign key column when defining a relationship between two entities in a relational database. It is commonly used with @OneToOne, @ManyToOne, and @OneToMany associations.
    private User user;
    private Double rating;

    private Boolean available;

    private String vehicleId;

    @Column(columnDefinition = "Geometry(Point,4326)")
    Point currentLocation;  //--->Spring Boot me Point ka use latitude aur longitude (GPS location) store karne ke liye hota hai. Agar aap kisi driver, delivery agent, ya kisi user ka current location store karna chahte ho, to Point type ka use kar sakte ho.
    
}
