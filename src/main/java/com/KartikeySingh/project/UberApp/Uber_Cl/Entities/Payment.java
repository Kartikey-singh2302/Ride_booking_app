package com.KartikeySingh.project.UberApp.Uber_Cl.entities;

import com.KartikeySingh.project.UberApp.Uber_Cl.entities.enums.PaymentMethod;
import com.KartikeySingh.project.UberApp.Uber_Cl.entities.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    PaymentMethod paymentMethod;

    @OneToOne(  fetch=FetchType.LAZY)
    private Ride ride;
    private Double Amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentstatus;

    @CreationTimestamp
    private LocalDateTime paymentTime;


}
