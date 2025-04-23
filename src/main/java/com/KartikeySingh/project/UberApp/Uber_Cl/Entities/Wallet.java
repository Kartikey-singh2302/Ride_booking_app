package com.KartikeySingh.project.UberApp.Uber_Cl.Entities;

import jakarta.persistence.*;
import org.apache.logging.log4j.util.Lazy;

import java.util.List;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)

        private User user;
        private Double balance;
    @OneToMany(mappedBy="wallet",fetch = FetchType.LAZY)
    private List<WalletTransaction> transaction;



}
