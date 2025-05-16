package com.KartikeySingh.project.UberApp.Uber_Cl.Entities;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.PaymentMethod;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(indexes =
   @Index(name = "idx_vehicle_id", columnList ="vehicleId")
)
public class Payment {
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
