package com.KartikeySingh.project.UberApp.Uber_Cl.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Wallet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,optional = false, cascade = CascadeType.DETACH)
        private User user;

        private Double balance=0.0;
    @OneToMany(mappedBy="wallet",fetch = FetchType.LAZY)
    private List<WalletTransaction> transaction;
}
