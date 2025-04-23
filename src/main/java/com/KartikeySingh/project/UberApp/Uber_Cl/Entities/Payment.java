package com.KartikeySingh.project.UberApp.Uber_Cl.Entities;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.PaymentMethod;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.PaymentStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    PaymentMethod paymentMethod;

    @OneToOne(  fetch=FetchType.LAZY)
    private Ride ride;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentstatus;

    @CreationTimestamp
    private LocalDateTime paymentTime;

}
