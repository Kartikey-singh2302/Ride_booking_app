package com.KartikeySingh.project.UberApp.Uber_Cl.entities;

import com.KartikeySingh.project.UberApp.Uber_Cl.entities.enums.TransactionMethod;
import com.KartikeySingh.project.UberApp.Uber_Cl.entities.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
public class WalletTransaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private TransactionType transactiontype;
    private TransactionMethod transactionMethod;

    @ManyToOne
    private Ride ride;
    private String transactionId;
    @ManyToOne
    private Wallet wallet;
    @CreationTimestamp
    private LocalDateTime timestamp;
}
