package com.KartikeySingh.project.UberApp.Uber_Cl.Entities;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.TransactionMethod;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.TransactionType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public class WalletTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private TransactionType transactiontype;
    private TransactionMethod transactionMethod;

    @OneToOne
    private Ride ride;
    private String transactionId;
    @ManyToOne
    private Wallet wallet;
    @CreationTimestamp
    private LocalDateTime timestamp;




}
